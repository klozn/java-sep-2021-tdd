package codelab09;

public class GridArea {
    private final int xPos;
    private final int yPos;
    private boolean hasShipPart;
    private String shipName;
    private boolean isFiredAt;

    public GridArea() {
        this(0, 0);
    }

    public GridArea(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        hasShipPart = false;
        shipName = "No ship";
        isFiredAt = false;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public boolean hasShipPart() {
        return hasShipPart;
    }

    public void addShipPart(Ship ship) {
        hasShipPart = true;
        shipName = ship.getName();
    }

    public boolean isFiredAt() {
        return isFiredAt;
    }

    public void bomb() {
        isFiredAt = true;
    }

    @Override
    public String toString() {
        if (!isFiredAt) {
            return "O";
        }
        return hasShipPart ? "H": "X";
    }
}
