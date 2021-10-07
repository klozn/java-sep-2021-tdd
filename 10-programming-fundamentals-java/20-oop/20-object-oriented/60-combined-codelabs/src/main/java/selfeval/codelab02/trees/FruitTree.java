package selfeval.codelab02.trees;

import selfeval.codelab02.Height;

import java.util.ArrayList;
import java.util.List;

public abstract class FruitTree extends Tree {
    private final List<FruitItem> fruitItems;

    public FruitTree(int age, Height height) {
        super(age, height);
        this.fruitItems = new ArrayList<>();
    }

    public List<FruitItem> getFruitItems() {
        return fruitItems;
    }

    public void addFruitItem(FruitItem fruitItem) {
        if (fruitItems.size() >= 10) {
            throw new IllegalStateException("There can be no more than 10 fruitItems in a fruit tree.");
        }
        fruitItems.add(fruitItem);
    }

    public void harvestFruit() {
        while (fruitItems.size() != 0) {
            fruitItems.remove(0);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" fruitItems=").append(fruitItems);
        sb.append('}');
        return sb.toString();
    }
}
