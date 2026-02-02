package tools.vitruv.reactionsparser.parser;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 * Listens to the first parse error and records all required information
 * to fix that error.
 */
class ErrorFixInformationRecorder extends BaseErrorListener {
    private ErrorRecoveryExplorationNode explorer;

    public ErrorFixInformationRecorder(ErrorRecoveryExplorationNode explorer) {
        this.explorer = explorer;
    }
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
            int charPositionInLine, String msg, RecognitionException e) {
        if (explorer.actionType != RecoveryActionType.NONE_REQUIRED) {
            return;
        }

        explorer.recognitionException = e;
        var parser = (Parser) recognizer;
        if (e instanceof InputMismatchException) {
            // Input Mismatch -> record offending token and replacements

            explorer.actionType = RecoveryActionType.REPLACE;
            explorer.offendingToken = (Token) offendingSymbol;
            explorer.expectedTokens = e.getExpectedTokens();
        }
        else if (e instanceof NoViableAltException) {
            // No viable alternative -> delete offending token
            explorer.actionType = RecoveryActionType.DELETE;
            explorer.offendingToken = (Token) offendingSymbol;
        }
        else if (msg.startsWith("missing")) {
            // Missing input -> record token to insert
            explorer.actionType = RecoveryActionType.INSERT;
            explorer.offendingToken = (Token) offendingSymbol;
            explorer.expectedTokens = parser.getExpectedTokens();
        }
        else if (msg.startsWith("extraneous")) {
            // Extraneous tokens -> try to delete and replace them
            explorer.actionType = RecoveryActionType.REPLACE;
            explorer.offendingToken = (Token) offendingSymbol;
            explorer.expectedTokens = parser.getExpectedTokens();
        }
        else {
            explorer.actionType = RecoveryActionType.NONE_POSSIBLE;
        }
    }
}