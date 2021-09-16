package codelab02.trees;

import java.awt.*;

public enum FruitItem {
    APPLE(Color.RED),
    ORANGE(Color.ORANGE),
    BULA(Color.YELLOW),
    YAKA(Color.RED);

    private final Color color;

    FruitItem(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
