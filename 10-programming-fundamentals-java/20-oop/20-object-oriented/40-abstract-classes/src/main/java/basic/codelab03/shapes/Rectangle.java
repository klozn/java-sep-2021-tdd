package basic.codelab03.shapes;

import basic.codelab03.Color;

public class Rectangle extends Shape{

    private double length;
    private double width;

    public Rectangle(Color color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " length: " + length + " width: " + width;
    }
}
