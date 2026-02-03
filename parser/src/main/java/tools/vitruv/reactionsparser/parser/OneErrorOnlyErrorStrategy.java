package tools.vitruv.reactionsparser.parser;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class OneErrorOnlyErrorStrategy extends DefaultErrorStrategy {
    private boolean errorFound = false;

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        if (!errorFound) {
            errorFound = true;
            super.recover(recognizer, e);
            return; 
        }
        throw new RuntimeException(e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        if (!errorFound) {
            errorFound = true;
            return super.recoverInline(recognizer);
        }
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    @Override
    public void sync(Parser recognizer) {
        if (!errorFound) {
            super.sync(recognizer);
        }
    }
}
