package advanced.codelab02;

public class Square {
    private int multiplier;
    private Tile tile;

    public Square(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int calcPoints() {
        if (getTile() != null) {
            return getTile().getPoints() * getMultiplier();
        }
        return 0;
    }

    @Override
    public String toString() {
        if (getTile() != null) {
            return getTile().toString();
        }
        return "  ";
    }
}
