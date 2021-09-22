package codelab07;

import codelab07.domain.ConnectFourService;

import java.util.Scanner;

public class ConnectFourApp {
    public static void main(String[] args) {
        ConnectFourService service = new ConnectFourService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Connect Four.");
        String playerOneName = askForName(scanner, 1);
        String playerTwoName = askForName(scanner, 2);

        service.setPlayerOne(playerOneName);
        service.setPlayerTwo(playerTwoName);
        System.out.println("Thank you, get ready to play!");
        service.launchGame();
    }

    private static String askForName(Scanner scanner, int playerNr) {
        String name = "";
        do {
            System.out.println("Please specify player name " + playerNr);
            name = scanner.nextLine();
        } while (!isValidName(name));
        return name;
    }

    private static boolean isValidName(String name) {
        if (name.isBlank()) {
            return false;
        }
        return true;
    }
}
