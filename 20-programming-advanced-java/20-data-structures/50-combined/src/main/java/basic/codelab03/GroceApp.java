package basic.codelab03;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GroceApp {
    public static void main(String[] args) {
        Rack rack = new Rack(List.of(new Shelf(), new Shelf(), new Shelf(), new Shelf()));
        rack.fill(List.of(
                new Grocery("apple"),
                new Grocery("pear"),
                new Grocery("orange"),
                new Grocery("apple"),
                new Grocery("pear")), 0);
        rack.fill(List.of(new Grocery("ham"), new Grocery("bacon")), 1);
        rack.fill(List.of(new Grocery("vegi ham"), new Grocery("vegi bacon")), 2);
        rack.fill(List.of(
                new Grocery("nintendo"),
                new Grocery("playstation"),
                new Grocery("pc"),
                new Grocery("xbox")), 3);

        do {
            System.out.println(rack);
            int input = askIndex();
            Grocery grocery = getGrocery(rack, input);
            System.out.println("You got: " + grocery.getName() + ".");
        } while (!rack.isEmpty());
        System.out.println("Do you need a bag?");
    }

    private static Grocery getGrocery(Rack rack, int index) {
        try {
            return rack.takeGroceryFromShelf(index);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Shelf " + index + " is empty.");
            int input = askIndex();
            return getGrocery(rack, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            int input = askIndex();
            return getGrocery(rack, input);
        }
    }

    private static int askIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index for the rack you want to get a grocery from:");
        System.out.print("> ");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please try again.");
            return askIndex();
        }
        return input;
    }
}
