package codelab03;

/**
 * Read the README.md for the assignment
 */
public class Main {

    public static char[][] createArrayForSize(int size) {
        char[][] square = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1) {
                    square[i][j] = '@';
                } else if (j == 0 || j == size - 1) {
                    square[i][j] = '@';
                } else {
                    square[i][j] = ' ';
                }
            }
        }
        return square;
    }

    public static void main(String[] args) {
        char[][] square = createArrayForSize(6);

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

}
