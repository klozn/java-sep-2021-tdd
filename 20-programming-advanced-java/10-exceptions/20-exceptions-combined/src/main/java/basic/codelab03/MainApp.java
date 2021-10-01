package basic.codelab03;

import java.time.DateTimeException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        int year = askFor("year");
        int month = askFor("month");
        int dayOfMonth = askFor("dayOfMonth");
        MyOwnLocalDate date = null;
        try {
            date = MyOwnLocalDate.create(year, month, dayOfMonth);
        } catch (DateTimeException exception) {
            System.out.println(exception.getMessage());
            main(args);
        } finally {
            System.out.println(date);
        }
    }

    private static int askFor(String numberType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number for " + numberType);
        System.out.print("> ");
        int input;
        try {
            input = scanner.nextInt();
        } catch (RuntimeException exception) {
            System.out.println("Something went wrong: " + exception.getMessage());
            System.out.println("Please try again.");
            return askFor(numberType);
        }
        return input;
    }
}
