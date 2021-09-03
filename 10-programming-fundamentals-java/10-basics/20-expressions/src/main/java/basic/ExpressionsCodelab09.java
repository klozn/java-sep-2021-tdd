package basic;

//peer review exercise
public class ExpressionsCodelab09 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 9");
        System.out.println("--------------");

        // ----------------
        // Try to manually calculate the following expression
        // Discuss afterwards with a peer what your thought process was

        int result = 5 + 4 * 3 + ((4 + 5) * (2 - 3)) * 4 * 3 - 2 * 5 % (5 + 4) + 100;
        //  5 + 12 + (9 * -1) * 12 - 10 % 9 + 100
        //  17 - 108 - 1 + 100 = 8

        System.out.println(result);

        // Why is an expression like this so hard to read and how would you make it better should this be a real example?
        // better : int result = 5 + (4 * 3) + ((4 + 5) * (2 - 3)) * 4 * 3 - (2 * 5) % (5 + 4) + 100;
    }
}
