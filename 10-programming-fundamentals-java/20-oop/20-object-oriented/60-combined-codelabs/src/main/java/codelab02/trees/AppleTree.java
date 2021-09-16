package codelab02.trees;

import codelab02.Height;

public class AppleTree extends FruitTree {
    public final static double GROWTH_AMOUNT = 0.6;

    public AppleTree(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
