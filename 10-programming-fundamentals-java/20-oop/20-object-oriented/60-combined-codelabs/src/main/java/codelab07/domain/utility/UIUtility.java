package codelab07.domain.utility;

import codelab07.domain.Player;

public class UIUtility {
    public static void askColIndexFrom(Player activePlayer) {
        System.out.println(activePlayer +
                ", Please select a column in which you want to drop your disk (First row is number 0)");
    }

    public static void printEndGameMessage(Player winner) {
        System.out.println(winner + ", YOU HAVE WON!");
        System.out.println("Final board situation:");
    }
}
