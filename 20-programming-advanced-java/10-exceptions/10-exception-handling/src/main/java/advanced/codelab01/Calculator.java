package advanced.codelab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("===========          ===========");
        System.out.println("=========  CALCULATOR  =========");
        System.out.println("===========          ===========");
        System.out.println("================================");
        System.out.println("=======                  =======");
        System.out.println("=====   (divisions only)  ======");
        System.out.println("=======                  =======");
        System.out.println("================================");
        System.out.println("================================");

        int numerator = askFor("numerator");
        int denominator = askFor("denominator");

        try {
            var result = CalculatorService.divide(numerator, denominator);
            System.out.println("The quotient of the division is: " + result);
        } catch (ArithmeticException ae) {
            System.err.println("Could not divide " + numerator + " by " + denominator);
        }
    }

    private static int askFor(String numberType) {
        Scanner in = new Scanner(System.in);
        System.out.print("Provide a " + numberType + " (int): ");
        int number;
        try {
            number = in.nextInt();
        } catch (InputMismatchException ime) {
            number = numberType.equals("nominator") ? 10 : 5;
            System.out.println("\n(invalid " + numberType + " provided. Therefore it is set to value " + number + ")");
            System.out.println("Please try again");
            return askFor(numberType);
        }
        return number;
    }

}
