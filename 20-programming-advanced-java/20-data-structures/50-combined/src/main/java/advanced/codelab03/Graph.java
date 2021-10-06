package advanced.codelab03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    public List<Edge> getEdgesByNode(Node node) {
        return edges.stream()
                .filter(e -> e.getLeft().equals(node))
                .collect(Collectors.toList());
    }

    public Node getAdjacentNode(Node node, Edge edge) {
        return edge.getLeft().equals(node) ? edge.getRight() : edge.getLeft();
    }
}
