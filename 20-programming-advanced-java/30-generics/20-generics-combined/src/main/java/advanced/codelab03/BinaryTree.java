package advanced.codelab03;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(T rootLabel) {
        root = new Node<T>(rootLabel);
    }

    public Node<T> getRoot() {
        return root;
    }

    // TODO: 4/10/2021
    public void draw() {
        System.out.print(root);
        drawNodes(root, 0);
    }

    public void drawNodes(Node<T> node, int level) {
        String spacing = "\t".repeat(level);
        if (node != null) {
            if (node.getLeft() != null) {
                System.out.print("\n" + spacing + "\\ --- " + node.getLeft());
            }
            drawNodes(node.getLeft(), level + 1);
            if (node.getRight() != null) {
                System.out.print("\n" + spacing + "\\ --- " + node.getRight());
            }
            drawNodes(node.getRight(), level + 1);
        }
    }
}
