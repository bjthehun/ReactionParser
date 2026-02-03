package tools.vitruv.reactionsparser.parser;

import java.io.IOException;
import java.util.Collections;

import org.antlr.runtime.RecognitionException;

public class ReactionsErrorReporter {
    public static void main(String[] args) throws IOException, RecognitionException {
        // Validate input
        if (args.length != 1) {
            System.err.println("usage: ReactionsErrorReporter  <<reactionsFile>>");
            System.exit(-1);
        }
        var filePath = args[0];

        // Read reactions file
        var reactionsText = ParserUtils.getTextFromFile(filePath);
        var parser = new PureAntlrParser();
        var parseResult = parser.parseString(reactionsText);

        // Report #of parser errors
        System.out.println("ANTLR error count: " + parseResult.getErrorCount());
    }
}
