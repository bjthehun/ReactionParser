package tools.vitruv.reactionsparser.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.misc.Interval;

import tools.vitruv.reactionsparser.parser.antlr.DebugInternalReactionsLanguageLexer;

import org.antlr.v4.runtime.InputMismatchException;

public class ANTLRErrorRecoveryExplorer extends DefaultErrorStrategy {
    private static record SubstituteToken(
        int tokenType,
        String content,
        int distance
    ) {};
    
    private int keywordTokenType = -1;
    private Token errorToken = null;

    private String removeSingleQuotes(String literalText) {
        var length = literalText.length();
        return literalText.substring(1, length - 1);
    }

    @Override
    public void recover(Parser parser, RecognitionException exception) {
        if (exception instanceof InputMismatchException) {
            var recognitionException = (InputMismatchException) exception;
            // What token caused the error?
            errorToken = recognitionException.getOffendingToken();
            var content = errorToken.getText();

            // What literals could we expect?
            var expectedTokens = exception.getExpectedTokens();
            var expectedLiterals = expectedTokens
                .toList()
                .stream()
                .filter(type -> parser.getVocabulary().getLiteralName(type) != null)
                .map(type -> new SubstituteToken(
                    type, 
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

            if (expectedLiterals.isEmpty()) {
                super.recover(parser, recognitionException);
            }
            // Rewrite to most suitable token
            // Try alternatives based on editing costs
            for (var alternative: expectedLiterals) {
                exploreAlternative(parser, alternative, recognitionException);
            }
        }
        else {
            super.recover(parser, exception);
        }
    }

    void exploreAlternative(Parser parser, SubstituteToken alternativeToken, InputMismatchException mismatchException) {
        System.out.println("Exploring alternative: " + alternativeToken);
        // Update token stream to work with alternative
        var originalTokenStream = (CommonTokenStream) parser.getTokenStream();
        originalTokenStream.fill();
        var manipulatedTokenStream = new TokenStreamRewriter(originalTokenStream);
        manipulatedTokenStream.replace(
            mismatchException.getOffendingToken().getTokenIndex(),
            alternativeToken.content);
        var manipulatedText = manipulatedTokenStream.getText();

        // Create new parser interpreter from current data
        var interpreter = new ParserInterpreter(
            parser.getGrammarFileName(), 
            parser.getVocabulary(),
            Arrays.asList(parser.getRuleNames()),
            parser.getATN(),
            new CommonTokenStream(new DebugInternalReactionsLanguageLexer(CharStreams.fromString(manipulatedText)))
        );
        interpreter.setErrorHandler(new ANTLRErrorRecoveryExplorer());
        interpreter.parse(0);
    }

    @Override
    public Token recoverInline(Parser parser) {
        if (keywordTokenType == -1) {
            return super.recoverInline(parser);
        }
        // Produce "correct token".
        parser.consume();
        var replacement = new CommonToken(errorToken);
        replacement.setType(keywordTokenType);
        replacement.setText(parser.getVocabulary().getLiteralName(keywordTokenType));
        keywordTokenType = -1;
        return replacement;
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