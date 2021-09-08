package advanced.codelab01;

public class Zorro {

    public static char[][] generateZ(int size) {
        if (size < 2) {
            return null;
        }
        char[][] zThatStandsForZorro = new char[size][size];
        zThatStandsForZorro = fillWithSpaces(zThatStandsForZorro);

        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                for (int j = 0; j < size; j++) {
                    zThatStandsForZorro[i][j] = '@';
                }
            } else {
                zThatStandsForZorro[i][size - i - 1] = '@';
            }
        }
        printZ(zThatStandsForZorro);
        return zThatStandsForZorro;
    }

    private static void printZ(char[][] z) {
        for (char[] line: z) {
            for (char c: line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] fillWithSpaces(char[][] drawingBoard) {
        for (char[] line: drawingBoard) {
            for (int i = 0; i < drawingBoard.length; i++) {
                line[i] = ' ';
            }
        }
        return drawingBoard;
    }
}
