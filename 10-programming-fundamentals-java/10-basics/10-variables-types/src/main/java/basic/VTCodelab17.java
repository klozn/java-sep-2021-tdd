package basic;

public class VTCodelab17 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 17");
        System.out.println("--------------");

        // ----------------
        // Declare and initialize a long variable, give it value 10 000 000 000
        // Declare a int variable, initialize it with the long variable but explicitly cast it to an int
        // How is this different than assignment 6?
        // Print the result using: System.out.println("Printing a int initialized with a casted long: " + <YOUR_INT_VARIABLE_NAME>);

        long aLongVariable = 10000000000L;
        int anIntVariable = (int) aLongVariable;
        //with the casting we force the long into the int variable.
        System.out.println("Printing a int initialized with a casted long: " + anIntVariable);
    }

}
