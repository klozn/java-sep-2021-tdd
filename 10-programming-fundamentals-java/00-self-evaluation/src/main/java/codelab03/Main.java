package codelab03;

/**
 * Read the README.md for the assignment
 */
public class Main {
    public static final char SYMBOL = '@';

    public static char[][] createArrayForSize(int size) {
        char[][] square = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1) {
                    square[i][j] = SYMBOL;
                } else if (j == 0 || j == size - 1) {
                    square[i][j] = SYMBOL;
                } else {
                    square[i][j] = ' ';
                }
            }
        }
        return square;
    }

    public static void main(String[] args) {
        char[][] square = createArrayForSize(6);
        printArray(square);
    }

    private static void printArray(char[][] array) {
        for (char[] chars : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

}
