package codelab09;

public class GridArea {
    private final int xPos;
    private final int yPos;
    private boolean hasShipPart;
    private Ship ship;
    private boolean isFiredAt;

    public GridArea() {
        this(0, 0);
    }

    public GridArea(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        hasShipPart = false;
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
        this.ship = ship;
        ship.addGridArea(this);
    }

    public boolean isFiredAt() {
        return isFiredAt;
    }

    public String bomb() {
        if (!isFiredAt) {
            isFiredAt = true;
            if (hasShipPart) {
                if (ship.isSunk()) {
                    return "Ship on " + getxPos() + ", " + getyPos() + " (" + ship.getName() + ") was hit and destroyed";
                }
                return "Ship on " + getxPos() + ", " + getyPos() +" (" + ship.getName() + ") was hit.";
            }
            return "Big miss";
        }
        return "There's no point in bombing " + getxPos() + ", " + getyPos() + " twice...";
    }

    public String printValue() {
        if (!isFiredAt) {
            return "O";
        }
        return hasShipPart ? "H": "X";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GridArea{");
        sb.append("xPos=").append(getxPos());
        sb.append(", yPos=").append(getyPos());
        sb.append('}');
        return sb.toString();
    }
}
