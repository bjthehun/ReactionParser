package tools.vitruv.reactionsparser.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.IntervalSet;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageLexer;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageParser;

import org.antlr.v4.runtime.InputMismatchException;

public class ANTLRErrorRecoveryExplorer {
    /**
     * Recovery action for fixing the input.
     */
    public static record RecoveryAction(
        /**
         * Token where we encountered the error
         */
        Token offendingToken,
        /**
         * Text that needs to be inserted/deleted/replaced.
         */
        String content,
        /**
         * Actual recovery action that needs to be conducted.
         */
        RecoveryActionType actionType,
        /**
         * Editing distance. Heuristic to prioritize recovery actions.
         */
        int distance
    ) {};
    
    /**
     * Types of error to correct.
     */
    public static enum RecoveryActionType {
        /**
         * Token needs to be replaced; guess alternative tokens.
         */
        REPLACE,
        /**
         * Token needs to be inserted.
         */
        INSERT,
        /**
         * No recovery action required; input parses without problems.
         */
        NONE_REQUIRED,
        /**
         * No recovery action possible; input is not parsable.
         */
        NONE_POSSIBLE
    }

    /**
     * Listens to the first parse error and records all required information
     * to fix that error.
     */
    private static class ErrorFixInformationRecorder extends BaseErrorListener {
        private ANTLRErrorRecoveryExplorer explorer;

        public ErrorFixInformationRecorder(ANTLRErrorRecoveryExplorer explorer) {
            this.explorer = explorer;
        }
        
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                int charPositionInLine, String msg, RecognitionException e) {
            if (explorer.actionType != RecoveryActionType.NONE_REQUIRED) {
                return;
            }

            explorer.recognitionException = e;
            var parser = (Parser) recognizer;
            if (e instanceof InputMismatchException
                || msg.startsWith("extraneous")
            ) {
                // Input Mismatch -> record offending token and replacements
                // Also when we have extraneous tokens -> try to replace them, too.
                explorer.actionType = RecoveryActionType.REPLACE;
                explorer.offendingToken = (Token) offendingSymbol;
                explorer.expectedTokens = parser.getExpectedTokens();
            }
            else if (msg.startsWith("missing")) {
                // Missing input -> record token to insert
                explorer.actionType = RecoveryActionType.INSERT;
                explorer.offendingToken = (Token) offendingSymbol;
                explorer.expectedTokens = parser.getExpectedTokens();
            }
            else {
                explorer.actionType = RecoveryActionType.NONE_POSSIBLE;
            }
        }
    }

    /**
     * Text of the program to parse.
     */
    private final String programText;
    /**
     * Type of recovery action that needs to be taken.
     */
    private RecoveryActionType actionType = RecoveryActionType.NONE_REQUIRED;
    /**
     * Token that caused the parser error.
     */
    private Token offendingToken;
    /**
     * Possible replacement tokens.
     */
    private IntervalSet expectedTokens;
    /**
     * RecognitionExcpetion, if any.
     */
    private RecognitionException recognitionException;

    /**
     * Creates a new recoverer.
     * 
     * @param reactionsText
     * @param grammar
     * @param substituteToken
     */
    public ANTLRErrorRecoveryExplorer(String reactionsText){
        this.programText = reactionsText;
    }

    public List<RecoveryAction> findCorrectingOperations() {
        // Set up parser
        DebugInternalReactionsLanguageParser parser = new DebugInternalReactionsLanguageParser(
            new CommonTokenStream(
                new DebugInternalReactionsLanguageLexer(
                    CharStreams.fromString(programText))
                )
            );
        // Intercept wrong token problems
        parser.addErrorListener(new ErrorFixInformationRecorder(this));
        parser.ruleReactionsFile();

        // No parser error occurred -> nothing needs to be done
        if (actionType == RecoveryActionType.NONE_REQUIRED) {
            return new LinkedList<RecoveryAction>();
        }
        var recoveryActions = guessActions(parser);
        // Rewrite to most suitable token
        // Try alternatives based on editing costs
        for (var action: recoveryActions) {
            var tokenFixes = exploreAlternative(parser, action);
            if (tokenFixes != null) {
                tokenFixes.add(action);
            }
            return tokenFixes;
        }

        System.out.println("Failed at: ");
        System.out.println(programText);
        return null;
    }

    private List<RecoveryAction> guessActions(Parser parser) {
        if (actionType == RecoveryActionType.REPLACE || actionType == RecoveryActionType.INSERT) {
            // What token caused the error?
            var content = offendingToken.getText();
            // What literals could we expect?
            var expectedLiterals = expectedTokens
                .toList()
                .stream()
                .filter(type -> parser.getVocabulary().getLiteralName(type) != null)
                .map(type -> new RecoveryAction(
                    offendingToken,
                    removeSingleQuotes(parser.getVocabulary().getLiteralName(type)), 
                    actionType,
                    levenshteinDistance(content, 
                        removeSingleQuotes(parser.getVocabulary().getLiteralName(type)))
                ))
                .toList();
            expectedLiterals = new ArrayList<>(expectedLiterals); 
             // What literal fits best, i.e. has minimum editing costs?
            Collections.sort(expectedLiterals, (token1, token2) -> {
                return token1.distance() - token2.distance();
            });
            return expectedLiterals;
        }
        return List.of();
    }
    
    private String removeSingleQuotes(String literalText) {
        var length = literalText.length();
        return literalText.substring(1, length - 1);
    }

    private List<RecoveryAction> exploreAlternative(
        Parser parser,
        RecoveryAction action) {
        // Replace token in token stream
        var originalTokenStream = (CommonTokenStream) parser.getTokenStream();
        originalTokenStream.fill();
        var manipulatedTokenStream = new TokenStreamRewriter(originalTokenStream);

        if (action.actionType == RecoveryActionType.REPLACE) {
            manipulatedTokenStream.replace(offendingToken.getTokenIndex(), action.content);
        }
        else {
            manipulatedTokenStream.insertBefore(offendingToken.getTokenIndex(), action.content + " ");
        }
        var manipulatedText = manipulatedTokenStream.getText();

        // Try out alternative
        return new ANTLRErrorRecoveryExplorer(manipulatedText).findCorrectingOperations();
    }

    private int levenshteinDistance(String tokenToFix, String alternativeToken) {
        var m = tokenToFix.length();
        var n = alternativeToken.length();

        int [][] distances = new int[m + 1][n + 1];
        for (var i = 1; i <= m; i++) {
            distances[i][0] = i;
        }
        for (var j = 1; j <= n; j++) {
            distances[0][j] = j;
        }
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                int substitutionCost = tokenToFix.charAt(i - 1) != alternativeToken.charAt(j - 1) ? 1 : 0;
                int bestCost = distances[i - 1][j - 1] + substitutionCost;
                bestCost = Math.min(bestCost, distances[i - 1][j] + 1);
                bestCost = Math.min(bestCost, distances[i][j - 1] + 1);
                distances[i][j] = bestCost;
            }
        }
        return distances[m][n];
    }
}