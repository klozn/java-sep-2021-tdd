package advanced.codelab03;

public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T label;

    public Node(T label) {
        this.label = label;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return label.toString();
    }
}
