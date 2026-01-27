package tools.vitruv.reactionsparser.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.antlr.v4.tool.Grammar;
import org.junit.jupiter.api.Test;

public class PureAntlrParserTest {

    @Test
    void testParseValidFile() throws IOException {
        var parser = new PureAntlrParser();
        var result = parser.parse(resourcePath("template.reactions"));

        System.out.println("Parse tree: " + result.getParseTree().toStringTree());
        System.out.println("Error count: " + result.getErrorCount());

        for (var error : result.getErrors()) {
            System.err.println(error);
        }

        // The template.reactions file should parse without errors
        assertEquals(0, result.getErrorCount(), "Expected no syntax errors");
    }

    @Test
    void testParseMultipleFiles() throws IOException {
        var parser = new PureAntlrParser();

        // Parse template.reactions
        var result1 = parser.parse(resourcePath("template.reactions"));
        System.out.println("template.reactions errors: " + result1.getErrorCount());

        // Parse template2.reactions
        var result2 = parser.parse(resourcePath("template2.reactions"));
        System.out.println("template2.reactions errors: " + result2.getErrorCount());

        // Print any errors
        for (var error : result1.getErrors()) {
            System.err.println("template.reactions: " + error);
        }
        for (var error : result2.getErrors()) {
            System.err.println("template2.reactions: " + error);
        }
    }

    @Test
    void testParseStringWithErrors() {
        var parser = new PureAntlrParser();

        // Invalid content - should have syntax errors
        String invalidContent = "import invalid syntax here";
        var result = parser.parseString(invalidContent);

        System.out.println("Invalid content error count: " + result.getErrorCount());
        for (var error : result.getErrors()) {
            System.err.println(error);
        }

        assertTrue(result.hasErrors(), "Expected syntax errors for invalid content");
    }

    @Test
    void testCountErrors() throws IOException {
        var parser = new PureAntlrParser();
        int errorCount = parser.countErrors(resourcePath("template.reactions"));
        System.out.println("Total errors in template.reactions: " + errorCount);
    }

    @Test
    void testFileWithKnownErrors() throws IOException {
        var parser = new PureAntlrParser();
        var result = parser.parse(resourcePath("with_errors.reactions"));

        System.out.println("=== with_errors.reactions ===");
        System.out.println("Error count: " + result.getErrorCount());
        for (var error : result.getErrors()) {
            System.out.println("  " + error);
        }

        // File has 2 known errors: "aftr" and "updat"
        assertTrue(result.hasErrors(), "Should have syntax errors");
    }

    @Test
    void testFileWithUnknownErrors() throws IOException, RecognitionException {
        var fixedParserResult = 
            new ANTLRErrorRecoveryExplorer(ParserUtils.getTextFromFile(resourcePath("with_interesting_errors.reactions"))
        )
        .findCorrectSubstituteTokens();
        assertEquals(2, fixedParserResult.size());
    }

    @Test
    void testFileWithMissingContent() throws IOException, RecognitionException {
        var fixedParserResult = 
            new ANTLRErrorRecoveryExplorer(ParserUtils.getTextFromFile(resourcePath("with_missing_content.reactions"))
        )
        .findCorrectSubstituteTokens();
        assertEquals(2, fixedParserResult.size());
    }

    private String resourcePath(String fileName) {
        return new File(this.getClass().getClassLoader().getResource(fileName).getFile()).getAbsolutePath();
    }
}
