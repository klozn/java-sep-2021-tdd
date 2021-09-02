package basic.solutions;

public class VTCodelab19 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 19");
        System.out.println("--------------");

        // ----------------
        // Declare and initialize a double variable, give it value 45.95
        // Declare an int variable, initialize it with the double variable, but this time, cast it to an int
        // Does it work? Write a comment on why (not)?
        // Print the result using: System.out.println("Printing an int initialized with a casted double: " + <YOUR_LONG_VARIABLE_NAME>);
        // Do you notice something about what is printed?

        double aDouble = 45.95;
        int anInt = (int) aDouble;
        // You can not put a large box in a smaller box, but if you tell java to do it anyway it will force it for you.

        System.out.println("Printing an int initialized with a casted double: " + anInt);
        //The only downside of casting a double to an int that some information is lost. In this case everything after the . is lost.
    }

}
