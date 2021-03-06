package codelab02;

public class Region {
    private int growableCount;
    private final static int MAX_GROWABLE_AMOUNT = 5;
    private final Growable[] growables = new Growable[MAX_GROWABLE_AMOUNT];
    private Vegetation vegetation;

    public Region() {
        this(Vegetation.BROADLEAF);
    }

    public Region(Vegetation vegetation) {
        this.vegetation = vegetation;
    }

    public Vegetation getVegetation() {
        return vegetation;
    }

    public Growable[] getGrowables() {
        return growables;
    }

    public void plant(Growable growable) {
        if (growableCount < MAX_GROWABLE_AMOUNT) {
            growables[growableCount] = growable;
            growable.plant(this);
            growableCount++;
        }
    }

    public void advanceSeason() {
        for (Growable growable : growables) {
            if (growable != null) {
                if (vegetation == Vegetation.BROADLEAF) {
                    growable.grow();
                }
                if (vegetation == Vegetation.RAINFOREST) {
                    growable.grow();
                    growable.grow();
                }
            }
        }
    }
}
