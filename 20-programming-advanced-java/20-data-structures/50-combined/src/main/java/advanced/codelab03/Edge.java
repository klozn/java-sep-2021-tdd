package advanced.codelab03;

public class Edge {
    private final Node left;
    private final Node right;
    private boolean visited;
    private boolean backEdge;

    public Edge(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setBackEdge(boolean backEdge) {
        this.backEdge = backEdge;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
