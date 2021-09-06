package basic;

import java.util.Scanner;

public class DecisionMakingCodelab07 {

    /**
     * This application will calculate the square root of a provided number.
     * In which different ways can the user break the application by providing incorrect input?
     *
     * Provide guard clauses so that the user will get an appropriate response in case he/she provides a wrong input.
     *
     * Hint: You can make use of the isInteger() function to help you.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide a number: ");
        String userInput = scanner.nextLine();

        while (userInput.isBlank()) {
            userInput = scanner.nextLine();
        }

        while (!isInteger(userInput)) {
            System.out.println("That was not a number, try again: ");
            userInput = scanner.nextLine();
        }

        System.out.println("*******************");
        System.out.println();
        System.out.println(squareRoot(userInput));
    }

    private static String squareRoot(String number) {
        return "" + Math.sqrt(Integer.parseInt(number));
    }

    private static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
