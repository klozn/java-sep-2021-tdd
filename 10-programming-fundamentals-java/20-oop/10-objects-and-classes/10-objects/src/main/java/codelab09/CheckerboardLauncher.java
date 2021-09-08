package codelab09;

import java.awt.*;

public class CheckerboardLauncher {

    /**
     * This is a completely optional codelab.
     * (But it's a fun one though...)
     *
     * ------------------
     * Do the following
     * ------------------
     *
     * Create a checkerboard (black and red tiles) using BigWindow, BigCanvas and BigSquare.
     * The checkerboard should dynamically generate tiles based on the BigWindow's dimensions.
     * Feel free to create extra (helper) methods if you feel they will help you write
     * cleaner / better / simpler code.
     *
     */
    public static void main(String[] args) {
        int width = 1000;
        int height = 700;

        BigWindow window = new BigWindow(width, height);
        BigCanvas canvas = new BigCanvas();

        for (BigShape[] shapes: generateSquares(width, height)) {
            for (BigShape shape: shapes) {
                canvas.addShape(shape);
            }
        }

        window.addComponent(canvas);
        window.launch();

    }

    private static BigSquare[][] generateSquares(int width, int height) {

        int nrOfSquaresH = width / 50;
        int nrOfSquaresV = height / 50;

        BigSquare[][] squares = new BigSquare[nrOfSquaresV][nrOfSquaresH];

        for (int i = 0; i < nrOfSquaresV; i++) {
            for (int j = 0; j < nrOfSquaresH; j++) {
                int yPos = i * 50;
                int xPos = j * 50;

                squares[i][j] = new BigSquare(xPos, yPos,
                        (i + j) % 2 == 0 ? Color.RED: Color.BLACK);
            }

        }
        return squares;
    }
}
