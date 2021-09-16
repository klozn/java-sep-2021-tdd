package codelab02.trees;

import codelab02.Height;

public class Oak extends Tree {
    public final static double GROWTH_AMOUNT = 0.6;

    public Oak(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
