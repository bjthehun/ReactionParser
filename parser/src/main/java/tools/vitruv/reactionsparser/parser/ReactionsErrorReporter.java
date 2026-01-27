package tools.vitruv.reactionsparser.parser;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.antlr.runtime.RecognitionException;

public class ReactionsErrorReporter {
    public static final String[] GUESS_CORRECT_FLAGS = {
        "-gcp",
        "--guess-correct-program"
    };

    public static void main(String[] args) throws IOException, RecognitionException {
        // Validate input
        if (args.length <= 1 || args.length >= 3) {
            System.err.println("usage: ReactionsErrorReporter [-gcp|--guess-correct-program] <<reactionsFile>>");
            System.exit(-1);
        }
        boolean shouldGuessCorrectProgram = args[0].equals(GUESS_CORRECT_FLAGS[0]) || args[0].equals(GUESS_CORRECT_FLAGS[1]);
        if (args.length == 1 && shouldGuessCorrectProgram) {
            System.err.println("error: missing path to reactions file");
            System.exit(-1);
        }
        var filePath = args.length == 2 ? args[1] : args[0];

        // Read reactions file
        var reactionsText = ParserUtils.getTextFromFile(filePath);
        var parser = new PureAntlrParser();
        var parseResult = parser.parseString(reactionsText);

        // Report results, errors
        System.out.println("File " + filePath + ": ANTLR reports "
            + (!parseResult.hasErrors() ? " no " : parseResult.getErrorCount())
            + (parseResult.getErrorCount() != 1 ? " errors " : " error ")
        );
        for (var parseError: parseResult.getErrors()) {
            System.out.println(parseError);
        }

        // Guess syntax error fixes, if required
        if (!shouldGuessCorrectProgram) {
            return;
        }    
        var recoveryExplorer = new ANTLRErrorRecoveryExplorer(reactionsText);
        var recoveryTokens = recoveryExplorer.findCorrectSubstituteTokens();
        if (recoveryTokens == null) {
            System.out.println("Cannot guess correct tokens to recover from syntax errors");
            System.exit(0);
        }
        else {
            System.out.println("Syntax fixes: " + recoveryTokens.size() + " substitutions required");
        }

        // Translate to parser errors
        Collections.reverse(recoveryTokens);
        var recoveryTokensAsParserErrors = recoveryTokens
            .stream()
            .map(token -> new PureAntlrParser.SyntaxError(
                token.originalToken().getLine(), 
                token.originalToken().getCharPositionInLine(),
                "Use " + token.content() + " as replacement for "
                + token.originalToken().getText(),
                token.originalToken()))
            .toList();
        for (var recoveryMessage : recoveryTokensAsParserErrors) {
            System.out.println(recoveryMessage);
        }
    }
}
