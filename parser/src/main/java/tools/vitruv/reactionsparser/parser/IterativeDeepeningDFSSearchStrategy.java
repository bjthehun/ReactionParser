package tools.vitruv.reactionsparser.parser;

import java.util.List;
import java.util.Optional;

public class IterativeDeepeningDFSSearchStrategy implements ErrorRecoverySearchStrategy {
    private long exploredActions = 0;

    private static class SearchNode {
        ErrorRecoveryExplorationNode explorationNode;
        boolean furtherActionsPossible = false;

        public SearchNode(ErrorRecoveryExplorationNode explorationNode, boolean furtherActionsPossible
        ) {
            this.explorationNode = explorationNode;
            this.furtherActionsPossible = furtherActionsPossible;
        }
    }

    @Override
    public Optional<List<RecoveryAction>> findRecoveryActions(String reactionsText) {
        // Construct root node
        var explorationNode = new ErrorRecoveryExplorationNode(reactionsText);

        for (long maxDepth = 0;
            maxDepth >= 0;
            maxDepth++
        ) {
            System.out.println("Search depth " + maxDepth);
            System.out.println("Explored " + exploredActions + " actions");
            SearchNode root = new SearchNode(explorationNode, false);
            SearchNode found = dls(root, maxDepth);
            if (found.explorationNode != null) {
                return Optional.of(List.<RecoveryAction>of());
            }
            if (!found.furtherActionsPossible) {
                break;
            }
        }
        return Optional.empty();
    }

    private SearchNode dls(SearchNode root, long depth) {
        var parser = root.explorationNode.prepare();
        var explorationNode = root.explorationNode;
        if (explorationNode.didFindCorrectInput()) {
            return root;
        }
        if (depth == 0) {
            return new SearchNode(null, true);
        }

        boolean furtherActionsPossible = false;
        for (var action: explorationNode.guessActions()) {
            exploredActions ++;
            var nextExplorationNode = explorationNode.exploreAlternative(parser, action);
            var nextNode = new SearchNode(nextExplorationNode, false);
            var nextIteration = dls(nextNode, depth - 1);
            furtherActionsPossible |= nextIteration.furtherActionsPossible;

            if (nextIteration.explorationNode != null) {
                return nextIteration;
            }
        }
        return new SearchNode(null, furtherActionsPossible);
    }
}
