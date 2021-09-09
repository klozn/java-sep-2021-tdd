package codelab05.shapes;

public class MyCircle {

    private double radius;
    private String color;

    public MyCircle() {
        this(1);
    }

    public MyCircle(double radius) {
        this.radius = radius;
        color = "blue";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * Math.pow(Math.PI, 2);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "I'm a circle with a radius of " + getRadius()
                + " cm and color " + getColor() + " so I cover an area of "
                + getArea() + " cm².";
    }
}
