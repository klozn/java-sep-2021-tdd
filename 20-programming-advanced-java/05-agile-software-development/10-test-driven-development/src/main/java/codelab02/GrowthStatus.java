package codelab02;

public enum GrowthStatus {
    SEED, SPROUT, PLANT, TREE;

    public GrowthStatus next() {
        return switch(this) {
            case SEED -> SPROUT;
            case SPROUT -> PLANT;
            default -> TREE;
        };
    }
}
