package advanced.codelab03;

public class TestApp {
    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<>('A');
        Node<Character> root = tree.getRoot();
        Node<Character> leftNode = new Node<>('B');
        Node<Character> rightNode = new Node<>('C');
        leftNode.setLeft(new Node<>('X'));
        leftNode.setRight(new Node<>('Y'));
        root.setLeft(leftNode);
        root.setRight(rightNode);

        tree.draw();
    }

}
