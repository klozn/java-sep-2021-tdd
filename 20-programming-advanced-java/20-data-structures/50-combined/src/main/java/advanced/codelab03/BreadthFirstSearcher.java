package advanced.codelab03;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BreadthFirstSearcher implements SearchAlgorithm {
    @Override
    public void searchFromNodeToNode(Graph graph, Node next, Node goal) {
        var queue = new LinkedList<Node>();
        queue.offer(next);
        next.setVisited(true);
        while (!goal.isVisited() && queue.peekFirst() != null) {
            Node node = queue.pollFirst();

            for (Edge edge : graph.getEdgesByNode(node)) {
                edge.setVisited(true);
                Node adjacent = graph.getAdjacentNode(node, edge);
                if (!adjacent.isVisited()) {
                    adjacent.setVisited(true);
                    queue.offer(adjacent);
                }
            }
        }
        Logger.getAnonymousLogger().log(Level.INFO, "Found Node " + goal.getLabel());
    }
}
