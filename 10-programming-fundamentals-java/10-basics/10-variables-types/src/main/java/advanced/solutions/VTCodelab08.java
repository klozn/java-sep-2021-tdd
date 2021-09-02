package advanced.solutions;

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

        // Since this time the number of the short is too big to fit in a bit, by explicitly casting the short,
        // java will throw away the most significant bit of the short to make it fit in a byte
    }

}
