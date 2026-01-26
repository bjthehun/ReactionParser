package tools.vitruv.reactionsparser.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParserUtils {

    public static String getTextFromFile(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName))
            .stream()
            .map(line -> line + System.lineSeparator())
            .reduce("", (text1, text2) -> text1 + text2);
    }
    
}
