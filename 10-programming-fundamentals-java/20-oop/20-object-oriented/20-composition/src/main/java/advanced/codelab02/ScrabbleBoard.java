package advanced.codelab02;

import java.util.Random;

public class ScrabbleBoard {
    public static final int BOARD_SIZE = 15;
    private Square[][] board;

    public ScrabbleBoard() {
         board = new Square[BOARD_SIZE][BOARD_SIZE];
         initializeSquares();
    }

    public Square getSquare(int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex];
    }

    private void initializeSquares() {
        Random random = new Random();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Square(random.nextInt(3) + 1);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Square[] row: board) {
            for (Square square: row) {
                sb.append("[");
                sb.append(square);
                sb.append("]");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
