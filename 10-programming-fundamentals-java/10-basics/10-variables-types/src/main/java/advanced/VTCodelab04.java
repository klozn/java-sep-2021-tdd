package advanced;

public class VTCodelab04 {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Assignment 4");
        System.out.println("--------------");

        // ----------------
        // Declare and initialize a byte variable
        // Declare a short variable and initialize it with the above byte variable
        // Does it work? Write a comment on why (not)? If the code doesn't compile, put the code itself in comment

        byte aByte = 6;
        short aShort = aByte;
        //compiles because short > byte (16bit > 8bit) so there is no risk for loss of data, casting happens automatically.
    }

}
