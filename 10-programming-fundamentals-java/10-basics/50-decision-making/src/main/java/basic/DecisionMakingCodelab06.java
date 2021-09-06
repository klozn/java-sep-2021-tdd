package basic;

import java.util.Scanner;

public class DecisionMakingCodelab06 {

    /**
     * Make a program that will ask the user: "Which kind of greeting do you want (hello/goodbye)?: "
     * Depending on the answer you print out a different message:
     * - in case of 'hello': "We welcome you to our awesome application!"
     * - in case of 'goodbye': "Goodbye, hope to see you again."
     *
     * You can make your life easier by just copying the code from the previous exercise and use that as a starting point.
     * Finished? Try it out!
     *
     * Before we continue, did you think of the edge cases?
     * Try to think of all the different ways a user can break your small application.
     * Which ones can you prevent?
     * Adapt your solution with guard clauses so that even if the user writes something unexpected, your program still behaves in a logical way.
     */
    public static void main(String[] args) {
        System.out.println("Which kind of greeting do you want (hello/goodbye)?: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toLowerCase();

        switch (userInput) {
            case "hello" :
                System.out.println("We welcome you to our awesome application!");
                break;
            case "goodbye" :
                System.out.println("Goodbye, hope to see you again.");
                break;
            default:
                System.out.println("I could not interpret your input. Shutting down.");
        }
    }
}
