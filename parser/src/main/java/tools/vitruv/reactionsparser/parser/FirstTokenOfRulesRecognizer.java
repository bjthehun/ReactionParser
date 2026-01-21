package tools.vitruv.reactionsparser.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.tool.Grammar;

public class FirstTokenOfRulesRecognizer {
    private final Grammar grammar;

    public FirstTokenOfRulesRecognizer(String grammarPath) throws IllegalArgumentException, IOException {
        final var reactionsGrammarText = Files.readAllLines(Path.of(grammarPath))
            .stream()
            .reduce("", (lines, line) -> lines + "\n" + line);
        try {
            grammar = new Grammar(grammarPath, reactionsGrammarText);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void getFirstTokensFor(String ruleName) {
        var rule = grammar.getRule(ruleName);
    }
}
