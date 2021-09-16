package codelab02.trees;

import codelab02.Height;

public class OrangeTree extends FruitTree {
    private static final double GROWTH_AMOUNT = 0.3;

    public OrangeTree(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
