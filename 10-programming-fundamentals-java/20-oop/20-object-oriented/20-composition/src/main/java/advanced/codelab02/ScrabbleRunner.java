package advanced.codelab02;

public class ScrabbleRunner {
    public static void main(String[] args) {
        ScrabbleBoard scrabbleBoard = new ScrabbleBoard();

        scrabbleBoard.getSquare(1,4).setTile(new Tile('H', 1));
        scrabbleBoard.getSquare(1,5).setTile(new Tile('E',2));
        scrabbleBoard.getSquare(1,6).setTile(new Tile('L', 1));
        scrabbleBoard.getSquare(1,7).setTile(new Tile('L', 1));
        scrabbleBoard.getSquare(1,8).setTile(new Tile('O', 3));

        System.out.println(scrabbleBoard);

        for (int i = 4; i < 9; i++) {
            System.out.printf("Square on (1,%d) has a multiplier of %d and results in %d points\n",
                    i,
                    scrabbleBoard.getSquare(1,i).getMultiplier(),
                    scrabbleBoard.getSquare(1,i).calcPoints());
        }
    }
}
