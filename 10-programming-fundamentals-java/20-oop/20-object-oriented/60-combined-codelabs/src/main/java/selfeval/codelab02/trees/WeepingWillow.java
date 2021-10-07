package selfeval.codelab02.trees;

import selfeval.codelab02.Height;

public class WeepingWillow extends Tree {
    public final static double GROWTH_AMOUNT = 0.1;
    public WeepingWillow(int age, Height height) {
        super(age, height);
    }

    @Override
    public void grow() {
        setHeight(new Height(getHeight().getHeightAmount() + GROWTH_AMOUNT,
                getHeight().getUnit()));
    }
}
