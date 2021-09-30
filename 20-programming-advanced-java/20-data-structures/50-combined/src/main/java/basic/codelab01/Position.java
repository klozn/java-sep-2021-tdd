package basic.codelab01;

public enum Position {
    GOALKEEPER(3), DEFENDER(2), MIDFIELDER(1), STRIKER(4);

    private final int orderWeight;

    Position(int orderWeight) {
        this.orderWeight = orderWeight;
    }

    public int getOrderWeight() {
        return orderWeight;
    }
}
