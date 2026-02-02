package tools.vitruv.reactionsparser.parser;

import java.util.List;
import java.util.Optional;

public interface ErrorRecoverySearchStrategy {
    /**
     * Attempts to find a sequence of {@link RecoveryAction}s whose application
     * on {@code reactionsText} produces a syntactically correct 
     * (but not necessarily semantically correct) reactions file.
     * 
     * @param reactionsText - {@link String}
     * @return {@link Optional} of {@link List}
     *      When {@code isPresent()} is true, the recovery did succeed.
     */
    Optional<List<RecoveryAction>> findRecoveryActions(String reactionsText);
}