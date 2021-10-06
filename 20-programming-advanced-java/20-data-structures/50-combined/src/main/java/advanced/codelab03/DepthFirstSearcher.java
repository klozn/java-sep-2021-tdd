package advanced.codelab03;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DepthFirstSearcher implements SearchAlgorithm {
    @Override
    public void searchFromNodeToNode(Graph graph, Node node, Node goal) {
        node.setVisited(true);
        if (node.equals(goal)) {
            Logger.getAnonymousLogger().log(Level.INFO, "Found Node " + goal.getLabel());
        } else {
            for (Edge edge : graph.getEdgesByNode(node)) {
                if (!goal.isVisited()) {
                    if (!edge.isVisited()) {
                        Node adjacentNode = graph.getAdjacentNode(node, edge);
                        if (!adjacentNode.isVisited()) {
                            edge.setVisited(true);
                            searchFromNodeToNode(graph, adjacentNode, goal);
                        } else {
                            edge.setBackEdge(true);
                        }
                    }
                }
            }
        }
    }
}
