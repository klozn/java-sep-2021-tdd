package basic.codelab03;

import basic.codelab03.shapes.Rectangle;
import basic.codelab03.shapes.Shape;
import basic.codelab03.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Rectangle(Color.RED, 5, 7),
                new Rectangle(Color.BLUE, 15, 20),
                new Triangle(Color.GREEN, 3, 8),
                new Triangle(Color.YELLOW, 60, 4)
        };

        for (Shape shape: shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape);
        }
    }
}
