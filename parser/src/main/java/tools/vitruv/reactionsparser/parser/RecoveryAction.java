package tools.vitruv.reactionsparser.parser;

import org.antlr.v4.runtime.Token;

/**
 * Recovery action for fixing the input.
 */
public record RecoveryAction(
    /**
     * Token where we encountered the error
     */
    Token offendingToken,
    /**
     * Text that needs to be inserted/deleted/replaced.
     */
    String content,
    /**
     * Actual recovery action that needs to be conducted.
     */
    RecoveryActionType actionType,
    /**
     * Editing distance. Heuristic to prioritize recovery actions.
     */
    int distance
) {}