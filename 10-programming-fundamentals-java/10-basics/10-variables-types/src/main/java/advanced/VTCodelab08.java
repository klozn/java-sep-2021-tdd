package advanced;

public class VTCodelab08 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 8");
        System.out.println("--------------");

        // ----------------
        // Declare and initialize a short variable, give it value 128
        // Declare a byte variable, initialize it with the short variable, cast it to a byte
        // Print the result using: System.out.println("Printing a byte initialized with a casted short (128): " + <YOUR_BYTE_VARIABLE_NAME>);
        // Does it look as expected? Write a comment on why (not)?

        short aShort = 128;
        byte aByte = (byte) aShort;
        System.out.println("Printing a byte initialized with a casted short (128): " + aByte);
        // a byte can only hold integers up to 128, not 128 itself.
    }

}
