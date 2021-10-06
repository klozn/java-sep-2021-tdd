package advanced.codelab03;

@FunctionalInterface
public interface SearchAlgorithm {
    void searchFromNodeToNode(Graph graph, Node start, Node goal);
}
