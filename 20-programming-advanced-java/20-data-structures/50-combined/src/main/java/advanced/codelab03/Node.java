package advanced.codelab03;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Node {
    private final String label;
    private final List<Node> childNodes;
    private boolean visited;

    public Node(String label) {
        this(label, new ArrayList<>());
    }

    public Node(String label, List<Node> childNodes) {
        this.label = label;
        this.childNodes = childNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
        if (visited) {
            Logger.getAnonymousLogger().log(Level.INFO, "Node " + label + " visited.");
        }
    }

    public String getLabel() {
        return label;
    }

    public void addChildNode(Node node) {
        childNodes.add(node);
    }

    public void addChildNodes(List<Node> nodes) {
        childNodes.addAll(nodes);
    }
}
