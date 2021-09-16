package codelab02.trees;

import codelab02.Height;

import java.util.Arrays;

public abstract class FruitTree extends Tree {
    private FruitItem[] fruitItems;

    public FruitTree(int age, Height height) {
        super(age, height);
        this.fruitItems = new FruitItem[10];
    }

    public FruitItem[] getFruitItems() {
        return fruitItems;
    }

    public boolean addFruitItem(FruitItem fruitItem) {
        boolean added = false;
        for (int i = 0; !added && i < fruitItems.length; i++) {
            if (fruitItems[i] == null) {
                fruitItems[i] = fruitItem;
                added = true;
            }
        }
        return added;
    }

    public void harvestFruit() {
        Arrays.fill(fruitItems, null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" fruitItems=").append(Arrays.toString(fruitItems));
        sb.append('}');
        return sb.toString();
    }
}
