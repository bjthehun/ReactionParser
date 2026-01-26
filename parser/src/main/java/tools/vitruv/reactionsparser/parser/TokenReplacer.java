package tools.vitruv.reactionsparser.parser;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class TokenReplacer extends TokenStreamRewriter {
    public TokenReplacer(TokenStream tokens) {
        super(tokens);
    }
}
