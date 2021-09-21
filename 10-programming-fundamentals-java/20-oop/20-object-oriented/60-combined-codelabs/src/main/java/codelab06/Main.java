package codelab06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SlotMachineService service = new SlotMachineService();
        Scanner scanner = new Scanner(System.in);
        boolean broke = false;  //it's funny, ok?

        do {
            System.out.println("\nWelcome to the Slot Machine Simulation.\n");
            System.out.print("Enter the amount you would like to bet: €");
            double bet = scanner.nextDouble();
            String[] spinResult = service.spinSlotMachine();
            printSpinResult(spinResult);
            int numberOfMatches = service.numberOfMatches(spinResult);
            System.out.print("You win €" + service.calculateWinnings(bet, numberOfMatches));

            System.out.println("\n\nWould you like to play again?");
            System.out.print("Enter Y for yes or N for no: ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) {
                broke = true;
            }
        } while (!broke);
    }

    private static void printSpinResult(String[] results) {
        System.out.printf("\n\n%s--%s--%s\n\n", results[0], results[1], results[2]);
    }
}
