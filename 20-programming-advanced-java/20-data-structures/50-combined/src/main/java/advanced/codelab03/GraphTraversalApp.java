package advanced.codelab03;

import java.util.Arrays;
import java.util.List;
public class GraphTraversalApp {

    public static void main(String[] args) {

        Graph graph = initializeGraph();

        Node nodeS = graph.getNode(18);
        Node nodeF = graph.getNode(5);
        Node nodeK = graph.getNode(10);

        DepthFirstSearcher dfSearcher = new DepthFirstSearcher();

        searchGraph(dfSearcher, graph, nodeS);
        resetGraph(graph);
        searchGraph(dfSearcher, graph, nodeF);
        resetGraph(graph);
        searchGraph(dfSearcher, graph, nodeK);
        resetGraph(graph);

    }
    private static void resetGraph(Graph graph) {
        graph.getNodes().forEach(node -> node.setVisited(false));
        graph.getEdges().forEach(node -> node.setVisited(false));
    }

    private static void searchGraph(SearchAlgorithm searchAlgorithm, Graph graph, Node goalNode) {
        Node nodeA = graph.getNode(0);
        searchAlgorithm.searchFromNodeToNode(graph, nodeA, goalNode);
    }

    private static Graph initializeGraph() {
        Node nodeA = new Node("A"); Node nodeB = new Node("B"); Node nodeC = new Node("C");
        Node nodeD = new Node("D"); Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeG = new Node("G"); Node nodeH = new Node("H"); Node nodeI = new Node("I");
        Node nodeJ = new Node("J"); Node nodeK = new Node("K"); Node nodeL = new Node("L");
        Node nodeM = new Node("M"); Node nodeN = new Node("N"); Node nodeO = new Node("O");
        Node nodeP = new Node("P"); Node nodeQ = new Node("Q"); Node nodeR = new Node("R");
        Node nodeS = new Node("S"); Node nodeT = new Node("T"); Node nodeU = new Node("U");
        Node nodeV = new Node("V"); Node nodeW = new Node("W"); Node nodeX = new Node("X");
        Node nodeY = new Node("Y"); Node nodeZ = new Node("Z");

        nodeA.addChildNodes(List.of(nodeB, nodeC, nodeD, nodeE, nodeF));
        nodeB.addChildNodes(List.of(nodeG, nodeH));
        nodeF.addChildNodes(List.of(nodeI, nodeX, nodeY));
        nodeH.addChildNodes(List.of(nodeJ, nodeK));
        nodeC.addChildNodes(List.of(nodeL, nodeM));
        nodeM.addChildNodes(List.of(nodeN, nodeO));
        nodeO.addChildNodes(List.of(nodeP, nodeQ));
        nodeE.addChildNodes(List.of(nodeR, nodeS, nodeT, nodeU));
        nodeT.addChildNodes(List.of(nodeV, nodeW));
        nodeY.addChildNode(nodeZ);

        List<Node> nodeList = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI,
                nodeJ, nodeK, nodeL, nodeM, nodeN, nodeO, nodeP, nodeQ, nodeR, nodeS, nodeT, nodeU,
                nodeV, nodeW, nodeX, nodeY, nodeZ);

        return new Graph(nodeList, Arrays.asList(
                new Edge(nodeA, nodeB), new Edge(nodeA, nodeC), new Edge(nodeA, nodeD), new Edge(nodeA, nodeE),
                new Edge(nodeA, nodeF), new Edge(nodeB, nodeG), new Edge(nodeB, nodeH), new Edge(nodeF, nodeI),
                new Edge(nodeF, nodeX), new Edge(nodeF, nodeY), new Edge(nodeH, nodeJ), new Edge(nodeH, nodeK),
                new Edge(nodeC, nodeL), new Edge(nodeC, nodeM), new Edge(nodeM, nodeN), new Edge(nodeM, nodeO),
                new Edge(nodeO, nodeP), new Edge(nodeO, nodeQ), new Edge(nodeE, nodeR), new Edge(nodeE, nodeS),
                new Edge(nodeE, nodeT), new Edge(nodeE, nodeU), new Edge(nodeT, nodeV), new Edge(nodeT, nodeW),
                new Edge(nodeY, nodeZ)
        ));
    }
}
