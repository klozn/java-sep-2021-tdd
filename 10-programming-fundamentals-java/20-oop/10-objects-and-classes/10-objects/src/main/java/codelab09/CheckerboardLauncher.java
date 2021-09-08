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
    final static int SQUARE_SIZE = 50;

    public static void main(String[] args) {
        int width = 1920;
        int height = 1080;

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

        int nrOfSquaresH = width / SQUARE_SIZE;
        int nrOfSquaresV = height / SQUARE_SIZE;

        BigSquare[][] squares = new BigSquare[nrOfSquaresH][nrOfSquaresV];

        for (int i = 0; i < nrOfSquaresH; i++) {
            for (int j = 0; j < nrOfSquaresV; j++) {
                int xPos = i * SQUARE_SIZE;
                int yPos = j * SQUARE_SIZE;

                squares[i][j] = new BigSquare(xPos, yPos,
                        (i + j) % 2 == 0 ? Color.RED: Color.BLACK);
            }
        }
        return squares;
    }
}
