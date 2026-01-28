package tools.vitruv.reactionsparser.parser;

/**
 * Types of error to correct.
 */
public enum RecoveryActionType {
    /**
     * Token needs to be replaced; guess alternative tokens.
     */
    REPLACE,
    /**
     * Token needs to be inserted.
     */
    INSERT,
    /**
     * Token needs to be deleted.
     */
    DELETE,
    /**
     * No recovery action required; input parses without problems.
     */
    NONE_REQUIRED,
    /**
     * No recovery action possible; input is not parsable.
     */
    NONE_POSSIBLE
}