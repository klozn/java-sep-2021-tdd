package codelab07.domain;

import codelab07.domain.utility.DiskDropper;
import codelab07.domain.utility.GameEvaluationUtility;
import codelab07.domain.utility.UIUtility;
import codelab07.domain.grid.Grid;

import java.util.Scanner;

public class ConnectFourService {
    public final static char PLAYER_ONE_DISK_DISPLAY = 'X';
    public final static char PLAYER_TWO_DISK_DISPLAY = '0';
    private final Player[] players = new Player[2];
    private final Grid grid = new Grid();
    private Player activePlayer;

    public void launchGame() {
        Scanner scanner = new Scanner(System.in);
        setActivePlayer(players[0]);
        boolean gameOver;

        do {
            UIUtility.askColIndexFrom(activePlayer);
            displayGrid();
            System.out.print("> ");
            int colIndex = scanner.nextInt();
            boolean droppedDisk = false;

            if (!isValidColIndex(colIndex)) {
                colIndex = askForColIndexWileNotValid(colIndex, scanner);
            }
            while (!droppedDisk) {
                droppedDisk = dropDisk(colIndex);
                if (!droppedDisk) {
                    UIUtility.askColIndexFrom(activePlayer);
                    System.out.print("> ");
                    colIndex = scanner.nextInt();
                    if (!isValidColIndex(colIndex)) {
                        colIndex = askForColIndexWileNotValid(colIndex, scanner);
                    }
                }
            }
            gameOver = GameEvaluationUtility.isGameWon(grid);
            if (!gameOver) {
                System.out.println("No winner yet!");
                switchActivePlayer();
            }
        } while (!gameOver);
        UIUtility.printEndGameMessage(activePlayer);
        displayGrid();
    }

    private int askForColIndexWileNotValid(int colIndex, Scanner scanner) {
        while (!isValidColIndex(colIndex)) {
            System.out.println(colIndex + " is not a valid column index.");
            UIUtility.askColIndexFrom(activePlayer);
            System.out.print("> ");
            colIndex = scanner.nextInt();
        }
        return colIndex;
    }

    private boolean isValidColIndex(int i) {
        return (i >= 0) && (i < Grid.NR_OF_COLS);
    }

    public void displayGrid() {
        System.out.println(grid);
    }

    public void setPlayerOne(String name) {
        players[0] = new Player(1, name, PLAYER_ONE_DISK_DISPLAY);
    }

    public void setPlayerTwo(String name) {
        players[1] = new Player(2, name, PLAYER_TWO_DISK_DISPLAY);
    }

    public boolean dropDisk(int colIndex) {
        return DiskDropper.drop(activePlayer.getNextDisk(), colIndex, grid);
    }

    private void setActivePlayer(Player player) {
        activePlayer = player;
    }

    private void switchActivePlayer() {
        if (activePlayer.equals(players[0])) {
            setActivePlayer(players[1]);
        } else {
            setActivePlayer(players[0]);
        }
    }
}
