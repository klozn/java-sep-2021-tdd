package advanced.codelab03;

import java.util.List;

public class Node<T> {
    private Node<T> node1;
    private Node<T> node2;
    private T label;

    public Node(T label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label.toString();
    }

    public Node(Node<T> node1, Node<T> node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public List<Node<T>> getNodes() {
        return List.of(node1, node2);
    }

}
