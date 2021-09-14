package basic.codelab02;

public class ShapeApp {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Rectangle(Color.RED, 5, 8),
                new Rectangle(Color.GREEN, 7, 2),
                new Triangle(Color.BLUE, 5, 13),
                new Triangle(Color.YELLOW, 7, 55)
        };

        for (Shape shape: shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape);
        }
    }
}
