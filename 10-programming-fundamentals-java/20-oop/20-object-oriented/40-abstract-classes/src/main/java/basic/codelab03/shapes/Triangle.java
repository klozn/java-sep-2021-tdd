package basic.codelab03.shapes;

import basic.codelab03.Color;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return base * height / 2;
    }

    @Override
    public String toString() {
        return super.toString() + " base: " + base + " height: " + height;
    }
}
