package advanced.codelab02;

public class TicTacToe {

    public static void checkWin(char[][] chars) {
        if (chars.length != 3) {
            throw new IllegalArgumentException("Not a TicTacToe 'board'.");
        }

        boolean winner = false;
        char winningChar = 'a';

        //  check horizontally
        for (char[] row: chars) {
            if (row[0] != ' ') {
                if (row[0] == row[1] && row[0] == row[2]) {
                    winner = true;
                    winningChar = row[0];
                }
            }
        }

        //  check vertically
        for (int i = 0; i < chars.length; i++) {
            if (chars[0][i] != ' ') {
                if (chars[0][i] == chars[1][i] && chars[0][i] == chars[2][i]) {
                    winner = true;
                    winningChar = chars[0][i];
                }
            }
        }

        //  check diagonally
        if (chars[0][0] != ' ') {
            if (chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2]) {
                winner = true;
                winningChar = chars[0][0];
            }
        }
        if (chars[0][2] != ' ') {
            if (chars[0][2] == chars[1][1] && chars[0][2] == chars[2][0]) {
                winner = true;
                winningChar = chars[0][2];
            }
        }
        System.out.println(winner ? "Player " + winningChar + " has won the game." : "No one has won the game.");
    }

}
