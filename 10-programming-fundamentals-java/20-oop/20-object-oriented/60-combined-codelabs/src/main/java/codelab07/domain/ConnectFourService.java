package codelab07.domain;

import codelab07.domain.grid.Grid;

public class ConnectFourService {
    private final Player[] players = new Player[2];
    private final Grid grid = new Grid();
    private Player activePlayer;

    public void displayGrid() {
        System.out.println(grid);
    }

    public void turnEnd() {
        switchActivePlayer();
    }

    private void switchActivePlayer() {
        if (activePlayer.equals(players[0])) {
            activePlayer = players[1];
        } else {
            activePlayer = players[0];
        }
    }
}
