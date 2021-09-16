package codelab02.trees;

import codelab02.Height;

public class BulaYakaTree extends FruitTree {
    private static final double GROWTH_AMOUNT = 0.8;

    public BulaYakaTree(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
