package tools.vitruv.reactionsparser.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.IntervalSet;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageLexer;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageParser;

public class ErrorRecoveryExplorer {
    /**
     * Counter for produced tokens during error recovery.
     */
    private static long tokenProducedCounter = 0;

    /**
     * Text of the program to parse.
     */
    private final String programText;
    /**
     * Did the parse succeed, and did we fully parse the reaction?
     */
    private boolean didParseSucceed;
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

    /**
     * Parses the program input, and checks whether errors exists.
     * <br>
     * Returns the used {@code parser} for further work.
     * Call this method to prepare the explorer for further exploration of parse errors.
     * 
     * @return {@link Parser}
     */
    public Parser prepare() {
        // Force entire input to be parsed
        // Otherwise ANTLR may ignore some invalid input and we prefer to know about that
        CommonTokenStream stream = new CommonTokenStream(new DebugInternalReactionsLanguageLexer(CharStreams.fromString(programText)));
        stream.fill();

        // Find the first parser error
        DebugInternalReactionsLanguageParser parser = new DebugInternalReactionsLanguageParser(stream);     
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorFixInformationRecorder(this));
        var result = parser.reactionsFile();

        // Parse succeeded -> nothing needs to be done
        if (actionType == RecoveryActionType.NONE_REQUIRED) {
            // Did it _really_ succeed?
            // Compare the last token parsed sucessfully
            // against the last token that could be parsed
            // (neither EOF, nor on hidden channel)
            var allTokens = stream.getTokens();
            final int lastParsedToken = result.getStop().getTokenIndex();
            int lastParsableToken = -1;
            for (int i = allTokens.size() - 1; i >= 0; i--) {
                var token = allTokens.get(i);
                if (token.getType() != -1 && token.getChannel() == 0) {
                    lastParsableToken = i;
                    break;
                }
            }
            didParseSucceed = (lastParsedToken >= lastParsableToken);
        }
        else {
            didParseSucceed = false;
        }
        return parser;
    }

    /**
     * Depth-first search strategy to find correcting operations.
     * 
     * @return {@link List} of {@link RecoveryAction}s
     */
    public List<RecoveryAction> findCorrectingOperations() {
        var parser = prepare();
        if (didFindCorrectInput()) {
            System.out.println("Parser accepts this input: ");
            System.out.println(programText);
            return new LinkedList<RecoveryAction>();
        }
    
        var recoveryActions = guessActions();
        // Rewrite to most suitable token
        // Try alternatives based on editing costs
        for (var action: recoveryActions) {
            var appliedAction = exploreAlternative(parser, action);
            var tokenFixes = appliedAction.findCorrectingOperations();

            if (tokenFixes != null) {
                tokenFixes.add(action);
                return tokenFixes;
            }
        }

        System.out.println("Failed at: ");
        System.out.println(programText);
        return null;
    }

    public boolean didFindCorrectInput() {
        return didParseSucceed;
    }

    /**
     * Comes up with possible recovery actions for the current state
     * (i.e. the current program text and last encountered parse error, if any).
     *
     * @return {@link List}
     */
    public List<RecoveryAction> guessActions() {
        List<RecoveryAction> actions = new LinkedList<>();
        if (actionType == RecoveryActionType.REPLACE 
            || actionType == RecoveryActionType.INSERT) {
            // What token caused the error?
            var content = offendingToken.getText();
            // What literals could we expect?
            var expectedLiterals = expectedTokens
                .toList()
                .stream()
                .map(type -> guessTextForTokenType(type))
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

    /**
     * Creates a token text for recovery.
     * 
     * @param tokenType - int
     * @return new String
     */
    private String guessTextForTokenType(int tokenType) {
        // Literals/Keywords, Operators etc.: Text is directly available, remove single quotes.
        String tokenText = DebugInternalReactionsLanguageLexer.VOCABULARY.getLiteralName(tokenType);
        if (tokenText != null) {
            return tokenText.substring(1, tokenText.length() - 1);
        }
        tokenProducedCounter++;
        // Symbols/Non-Literals, return dummy expressions.
        switch (tokenType) {
            case DebugInternalReactionsLanguageLexer.RULE_DECIMAL:
                return "47.67" + tokenProducedCounter;
            case DebugInternalReactionsLanguageLexer.RULE_HEX:
                return "0x4767" + tokenProducedCounter;
            case DebugInternalReactionsLanguageLexer.RULE_ID:
                return "unknownId" + tokenProducedCounter;
            case DebugInternalReactionsLanguageLexer.RULE_INT:
                return "4767" + tokenProducedCounter;
            case DebugInternalReactionsLanguageLexer.RULE_ML_COMMENT:
                return "/* ML comment 4767" + tokenProducedCounter + " */";
            case DebugInternalReactionsLanguageLexer.RULE_SL_COMMENT:
                return "// SL comment 6747 " + tokenProducedCounter;
            case DebugInternalReactionsLanguageLexer.RULE_STRING:
                return "\"unknownStringLiteral" + tokenProducedCounter + "\"";
            case DebugInternalReactionsLanguageLexer.RULE_WS:
                return " ";
            case DebugInternalReactionsLanguageLexer.RULE_ANY_OTHER:
            default:
                return null;
        }
    }
    
    /**
     * Applies {@code action} to the input of {@code parser}, and returns a new {@link ErrorRecoveryExplorer}
     * to continue the search from.
     * 
     * @param parser - {@link Parser}
     * @param action - {@link RecoveryAction}
     * @return new ErrorRecoveryExplorer
     */
    public ErrorRecoveryExplorer exploreAlternative(
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
        return new ErrorRecoveryExplorer(manipulatedText);
    }

    /**
     * Computes the Levenshtein distance between two strings.
     * 
     * @param from - String
     * @param to - String
     * @return int
     */
    private int levenshteinDistance(String from, String to) {
        var m = from.length();
        var n = to.length();

        int [][] distances = new int[m + 1][n + 1];
        for (var i = 1; i <= m; i++) {
            distances[i][0] = i;
        }
        for (var j = 1; j <= n; j++) {
            distances[0][j] = j;
        }
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                int substitutionCost = from.charAt(i - 1) != to.charAt(j - 1) ? 1 : 0;
                int bestCost = distances[i - 1][j - 1] + substitutionCost;
                bestCost = Math.min(bestCost, distances[i - 1][j] + 1);
                bestCost = Math.min(bestCost, distances[i][j - 1] + 1);
                distances[i][j] = bestCost;
            }
        }
        return distances[m][n];
    }
}