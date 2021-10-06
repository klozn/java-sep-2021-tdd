package advanced.codelab03;

public class Edge {
    private final Node left;
    private final Node right;

    public Edge(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
