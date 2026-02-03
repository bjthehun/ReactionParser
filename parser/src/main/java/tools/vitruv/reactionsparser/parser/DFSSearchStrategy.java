package tools.vitruv.reactionsparser.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DFSSearchStrategy implements ErrorRecoverySearchStrategy {
    @Override
    public Optional<List<RecoveryAction>> findRecoveryActions(String reactionsText) {
        var actions = this.findRecoveryActionsFrom(
            new ErrorRecoveryExplorationNode(reactionsText)
        );
        return actions != null ? Optional.of(actions) : Optional.empty();
    }

    /**
     * Depth-first search strategy to find correcting operations.
     * 
     * @return {@link List} of {@link RecoveryAction}s
     */
    private List<RecoveryAction> findRecoveryActionsFrom(ErrorRecoveryExplorationNode node) {
        var parser = node.prepare();
        if (node.didFindCorrectInput()) {
            System.out.println("Parser accepts this input: ");
            System.out.println(node.getProgramText());
            return new LinkedList<RecoveryAction>();
        }
    
        var recoveryActions = node.guessActions();
        // Rewrite to most suitable token
        // Try alternatives based on editing costs
        for (var action: recoveryActions) {
            var appliedAction = node.exploreAlternative(parser, action);
            var tokenFixes = findRecoveryActionsFrom(appliedAction);

            if (tokenFixes != null) {
                tokenFixes.add(action);
                return tokenFixes;
            }
        }

        System.out.println("Failed at: ");
        System.out.println(node.getProgramText());
        return null;
    }
}
