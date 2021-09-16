package codelab02.trees;

import codelab02.Height;

public class Fir extends Tree {
    public final static double GROWTH_AMOUNT = 1.2;

    public Fir(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
