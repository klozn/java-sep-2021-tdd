package codelab02;

import codelab02.trees.FruitTree;
import codelab02.trees.Tree;

public class Forest {
    private Tree[] trees;

    public Forest(Tree[] trees) {
        this.trees = trees;
    }

    public void displayTrees() {
        for (Tree tree : trees) {
            System.out.println(tree);
        }
    }

    public void forestFire() {
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] instanceof FruitTree) {
                trees[i] = null;
            }
        }
    }

    public Tree[] getTrees() {
        return trees;
    }
}
