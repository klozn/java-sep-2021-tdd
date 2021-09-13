package codelab09;

import java.util.Scanner;

public class BattleShipApp {
    public static void main(String[] args) {
        BattleShipGameService grid = new BattleShipGameService();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(grid);
            int[] coordinates = askForUserInput(scanner);
            System.out.println(grid.bomb(coordinates[0], coordinates[1]));
            grid.updateGameStatus();
        } while (!grid.isGameOver());
        System.out.println("###GAME OVER###");
    }

    private static int[] askForUserInput(Scanner scanner) {
        System.out.println("Enter coordinates (X,Y) [0-9]");
        String input = scanner.nextLine();
        input = input.replace("(", "");
        input = input.replace(")", "");
        input = input.strip();
        input = input.replace(",", "");
        input = input.replace(" ", "");
        String[] coordinates = input.split("");

        int[] coordinatesAsInts = new int[2];
        try {
            coordinatesAsInts[0] = Integer.parseInt(coordinates[0]);
            coordinatesAsInts[1] = Integer.parseInt(coordinates[1]);
        } catch (Exception e) {
            System.out.println("Could not interpret input.");
            askForUserInput(scanner);
        }
        return coordinatesAsInts;
    }
}
