package codelab04;

/**
 * Read the README.md for the assignment
 */
public class Main {

    public static String month(int numberOfMonth) {
        return switch (numberOfMonth) {
            default -> throw new IllegalArgumentException("The argument provided does not correspond to a month.");
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
        };

        // return Month.of(numberOfMonth).name();
    }

    public static double calculatePrice(int amountOfElements) {
        if (amountOfElements < 0) {
            return 0;
        }
        if (amountOfElements < 11) {
            return amountOfElements * 5;
        }
        if (amountOfElements < 16) {
            return 50 + (amountOfElements - 10) * 4;
        }
        return 70 + (amountOfElements - 15) * 3;
    }

    public static String returnText(int input) {
        return switch (input) {
            default -> "That's a fail whale";
            case 1 -> "It's something";
            case 2 -> "That's more like it";
            case 3 -> "Way to go";
        };
    }
}
