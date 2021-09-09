package codelab01;

import java.awt.*;

public class PointRunner {

    /**
     * The goal of this codelab is the gain some insight on Object references.
     * Therefore, don't yet execute the main method!
     * First, do the following:
     *      1. Determine what the printed output will be and why!
     *      2. Draw on a piece of paper which variables (holding references) point to which objects (as we did on the slides)
     *      3. Only then execute the code and validate whether your solutions from step 1 and 2 were correct!
     *          - To execute the code, turn the code on line 17 into a comment (or simply remove it)
     */
    public static void main(String[] args) {

        Point pointAlpha = new Point(99,45);
        Point pointBeta = pointAlpha;
        Point pointCharlie = pointBeta;

        pointCharlie.move(45,205);
        System.out.println(pointAlpha.toString()); // what is the output and why?
        //  pointAlpha will be at (45, 205) because all variables are referring to the same object in memory
        System.out.println("----------------------");

        pointBeta = new Point(85,99);
        System.out.println(pointAlpha.toString()); // what is the output and why?
        //  (45, 205) : nothing happened to the pointAlpha variable since previous print statement
        System.out.println(pointBeta.toString()); // what is the output and why?
        //  (85, 99) : pointBeta is now referring to its own object in memory
        System.out.println("----------------------");

        Point pointDelta = Add50(pointAlpha);
        System.out.println(pointDelta); // what is the output and why?
        //  (95, 255) : add50 creates a new Point object, only using the x and y of the parameter object

        System.out.println(pointAlpha); // what is the output and why?
        //  (45, 205) : pointAlpha was not altered by the add50 method.
        System.out.println("----------------------");

        Point pointEcho = moveTo100(pointAlpha);
        System.out.println(pointCharlie.toString()); // what is the output and why?
        //  (100, 100) : pointEcho is now referring to the same object as pointAlpha, as is pointCharlie,
        //  which has been moved by the method
        System.out.println(pointEcho.toString()); // what is the output and why?
        //  (100, 100) : see above
        System.out.println("----------------------");
    }

    private static Point Add50(Point point) {
        return new Point(point.x + 50, point.y + 50);
    }

    private static Point moveTo100(Point point) {
        point.move(100, 100);
        return point;
    }

    private static void thinkBeforeYouRunThisExercise() {
        throw new RuntimeException("Not so fast. Why don't you think about it first? Then remove the call to this method.");
    }



}
