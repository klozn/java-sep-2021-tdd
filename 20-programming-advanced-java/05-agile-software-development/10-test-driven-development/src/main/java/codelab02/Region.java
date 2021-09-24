package codelab02;

public class Region {
    private static int growableCount;
    private final Growable[] growables = new Growable[5];

    public Growable[] getGrowables() {
        return growables;
    }

    public void plant(Growable growable) {
        if (growableCount < 5) {
            for (int i = 0; i < growables.length; i++) {
                if (growables[i] == null) {
                    growables[i] = growable;
                    growable.plant(this);
                    growableCount++;
                }
            }
        }
    }
}
