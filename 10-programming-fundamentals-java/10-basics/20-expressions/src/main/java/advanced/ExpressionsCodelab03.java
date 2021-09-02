package advanced;

//Peer review exercise. Discuss the flow of this program with a peer afterwards
public class ExpressionsCodelab03 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 3");
        System.out.println("--------------");

        // ----------------
        // An extra bit of information
        // ++ or -- are evaluated after () but before *, / and %
        // Knowing this: what is the result of the following expression?
        // Try to calculate it first manually
        // What are the values of first and second after execution?

        int first = 1;
        int second = 3;

        int result = second-- + 3 + 2 * 4 / ++first - (2 + --second) % 2 + ++first + second;
    }
}
