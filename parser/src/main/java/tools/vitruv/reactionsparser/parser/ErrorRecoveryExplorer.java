package tools.vitruv.reactionsparser.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageLexer;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageParser;

public class ErrorRecoveryExplorer {
    /**
     * Text of the program to parse.
     */
    private final String programText;
    /**
     * Type of recovery action that needs to be taken.
     */
    RecoveryActionType actionType = RecoveryActionType.NONE_REQUIRED;
    /**
     * Token that caused the parser error.
     */
    Token offendingToken;
    /**
     * Possible replacement tokens.
     */
    IntervalSet expectedTokens;
    /**
     * RecognitionExcpetion, if any.
     */
    RecognitionException recognitionException;

    /**
     * Creates a new recoverer.
     * 
     * @param reactionsText
     * @param grammar
     * @param substituteToken
     */
    public ErrorRecoveryExplorer(String reactionsText){
        this.programText = reactionsText;
    }

    public List<RecoveryAction> findCorrectingOperations() {
        // Set up parser
        CommonTokenStream stream = new CommonTokenStream(new DebugInternalReactionsLanguageLexer(CharStreams.fromString(programText)));
        stream.fill();
        DebugInternalReactionsLanguageParser parser = new DebugInternalReactionsLanguageParser(stream);
            
        // Intercept wrong token problems
        parser.addErrorListener(new ErrorFixInformationRecorder(this));
        var result = parser.reactionsFile();


        // Parse succeeded -> nothing needs to be done
        if (actionType == RecoveryActionType.NONE_REQUIRED) {
            // Did it _really_ succeed?
            // Compare the last token parsed sucessfully
            // against the last token that could be parsed
            // (neither EOF, nor on hidden channel)
            int lastParsedToken = result.getStop().getTokenIndex();
            var allTokens = stream.getTokens();
            int lastParsableToken = -1;
            for (int i = allTokens.size() - 1; i >= 0; i--) {
                var token = allTokens.get(i);
                if (token.getType() != -1 && token.getChannel() == 0) {
                    lastParsableToken = i;
                    break;
                }
            }
            if (lastParsedToken < lastParsableToken) {
                return null;
            }

            System.out.println("Parser accepts this input: ");
            System.out.println(programText);
            return new LinkedList<RecoveryAction>();
        }
        var recoveryActions = guessActions(parser);
        // Rewrite to most suitable token
        // Try alternatives based on editing costs
        for (var action: recoveryActions) {
            var tokenFixes = exploreAlternative(parser, action);
            if (tokenFixes != null) {
                tokenFixes.add(action);
                return tokenFixes;
            }
        }

        System.out.println("Failed at: ");
        System.out.println(programText);
        return null;
    }

    private List<RecoveryAction> guessActions(Parser parser) {
        List<RecoveryAction> actions = new LinkedList<>();
        if (actionType == RecoveryActionType.REPLACE 
            || actionType == RecoveryActionType.INSERT) {
            // What token caused the error?
            var content = offendingToken.getText();
            // What literals could we expect?
            var expectedLiterals = expectedTokens
                .toList()
                .stream()
                .map(type -> guessTextForTokenType(type, parser.getVocabulary()))
                .filter(text -> text != null)
                .map(text -> new RecoveryAction(
                    offendingToken,
                    text,
                    actionType,
                    levenshteinDistance(content, text)
                ))
                .toList();
            expectedLiterals = new ArrayList<>(expectedLiterals); 
             // What literal fits best, i.e. has minimum editing costs?
            Collections.sort(expectedLiterals, (token1, token2) -> {
                return token1.distance() - token2.distance();
            });
            actions.addAll(expectedLiterals);
        }
        if (actionType == RecoveryActionType.DELETE) {
            actions.add(
                new RecoveryAction(offendingToken, "", actionType, 0)
            );
        }
        return actions;
    }

    private String guessTextForTokenType(int tokenType, Vocabulary vocabulary) {
        // Literals/Keywords, Operators etc.: Text is directly available, remove single quotes.
        String tokenText = vocabulary.getLiteralName(tokenType);
        if (tokenText != null) {
            return tokenText.substring(1, tokenText.length() - 1);
        }
        // Symbols/Non-Literals, return dummy expressions.
        switch (tokenType) {
            case DebugInternalReactionsLanguageLexer.RULE_DECIMAL:
                return "47.67";
            case DebugInternalReactionsLanguageLexer.RULE_HEX:
                return "0x4767";
            case DebugInternalReactionsLanguageLexer.RULE_ID:
                return "unknownId";
            case DebugInternalReactionsLanguageLexer.RULE_INT:
                return "4767";
            case DebugInternalReactionsLanguageLexer.RULE_ML_COMMENT:
                return "/* ML comment 4767 */";
            case DebugInternalReactionsLanguageLexer.RULE_SL_COMMENT:
                return "// SL comment 6747";
            case DebugInternalReactionsLanguageLexer.RULE_STRING:
                return "\"unknownStringLiteral\"";
            case DebugInternalReactionsLanguageLexer.RULE_WS:
                return " ";
            case DebugInternalReactionsLanguageLexer.RULE_ANY_OTHER:
            default:
                return null;
        }
    }
    
    private String removeSingleQuotes(String literalText) {
        var length = literalText.length();
        return literalText.substring(1, length - 1);
    }

    private List<RecoveryAction> exploreAlternative(
        Parser parser,
        RecoveryAction action) {
        // Replace token in token stream
        var originalTokenStream = parser.getTokenStream();
        var manipulatedTokenStream = new TokenStreamRewriter(originalTokenStream);

        if (action.actionType() == RecoveryActionType.REPLACE) {
            manipulatedTokenStream.replace(offendingToken.getTokenIndex(), " " + action.content() + " ");
        }
        else if (action.actionType() == RecoveryActionType.INSERT) {
            manipulatedTokenStream.insertBefore(offendingToken.getTokenIndex(), " " + action.content() + " ");
        }
        else {
            manipulatedTokenStream.delete(offendingToken.getTokenIndex());
        }
        var manipulatedText = manipulatedTokenStream.getText();

        // Try out alternative
        return new ErrorRecoveryExplorer(manipulatedText).findCorrectingOperations();
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