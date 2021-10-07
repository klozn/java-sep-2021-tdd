package selfeval.codelab02;

import selfeval.codelab02.trees.FruitTree;
import selfeval.codelab02.trees.Tree;

import java.util.List;

public class Forest {
    private List<Tree> trees;

    public Forest(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void displayTrees() {
        trees.forEach(System.out::println);
    }

    public void forestFire() {
        trees.removeIf(tree -> tree instanceof FruitTree);
    }
}
