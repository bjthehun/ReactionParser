package tools.vitruv.reactionsparser.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.lang.model.type.ErrorType;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.tool.Grammar;

import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageLexer;
import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageParser;

import org.antlr.v4.runtime.InputMismatchException;

public class ANTLRErrorRecoveryExplorer {
    /**
     * Substitute token for replacing incorrect tokens.
     */
    public static record SubstituteToken(
        Token originalToken,
        String content,
        int distance
    ) {};

    private static class InputMismatchReporter extends BaseErrorListener {
        public InputMismatchReporter(ANTLRErrorRecoveryExplorer explorer) {
            this.explorer = explorer;
        }
        private ANTLRErrorRecoveryExplorer explorer;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                int charPositionInLine, String msg, RecognitionException e) {
            explorer.parserErrorOccurred = true;
            if (e instanceof InputMismatchException inputMismatch
                && explorer.inputMismatch == null
            ) {
                explorer.inputMismatch = inputMismatch;
            }
        }
    }

    /**
     * Text of the program to parse
     */
    private final String programText;
    /**
     * Did we encounter a parser error (yet)?;
     */
    private boolean parserErrorOccurred = false;
    /**
     * Tells us about a token causing a parser error.
     */
    private InputMismatchException inputMismatch;

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

    public List<SubstituteToken> findCorrectSubstituteTokens() {
        // Set up parser
        DebugInternalReactionsLanguageParser parser = new DebugInternalReactionsLanguageParser(
            new CommonTokenStream(
                new DebugInternalReactionsLanguageLexer(
                    CharStreams.fromString(programText))
                )
            );
        // Intercept wrong token problems
        parser.addErrorListener(new InputMismatchReporter(this));
        parser.ruleReactionsFile();

        if (!parserErrorOccurred) {
            return new LinkedList<SubstituteToken>();
        }

        if (inputMismatch != null) {
            // What token caused the error?
            var errorToken = inputMismatch.getOffendingToken();
            var content = errorToken.getText();

            // What literals could we expect?
            var expectedTokens = inputMismatch.getExpectedTokens();
            var expectedLiterals = expectedTokens
                .toList()
                .stream()
                .filter(type -> parser.getVocabulary().getLiteralName(type) != null)
                .map(type -> new SubstituteToken(
                    errorToken,
                    removeSingleQuotes(parser.getVocabulary().getLiteralName(type)), 
                    levenshteinDistance(content, 
                        removeSingleQuotes(parser.getVocabulary().getLiteralName(type)))
                ))
                .toList();
            expectedLiterals = new ArrayList<>(expectedLiterals); 

            // What literal fits best, i.e. has minimum editing costs?
            Collections.sort(expectedLiterals, (token1, token2) -> {
                return token1.distance() - token2.distance();
            });
            // Rewrite to most suitable token
            // Try alternatives based on editing costs
            for (var alternative: expectedLiterals) {
                var tokenFixes = exploreAlternative(parser, alternative, inputMismatch);
                if (tokenFixes != null) {
                    tokenFixes.add(alternative);
                }
                return tokenFixes;
            }
        }
        return null;
    }
    
    private String removeSingleQuotes(String literalText) {
        var length = literalText.length();
        return literalText.substring(1, length - 1);
    }

    private List<SubstituteToken> exploreAlternative(
        Parser parser,
        SubstituteToken alternativeToken,
        InputMismatchException mismatchException) {
        // Update token stream to work with alternative
        var originalTokenStream = (CommonTokenStream) parser.getTokenStream();
        originalTokenStream.fill();
        var manipulatedTokenStream = new TokenStreamRewriter(originalTokenStream);
        manipulatedTokenStream.replace(
            mismatchException.getOffendingToken().getTokenIndex(),
            alternativeToken.content);
        var manipulatedText = manipulatedTokenStream.getText();

        // Try out alternative
        return new ANTLRErrorRecoveryExplorer(manipulatedText).findCorrectSubstituteTokens();
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