package basic;

public class MethodsCodelab12 {

    public static void main(String[] args) {

        // ------------
        // This code could use some more methods
        // Use the principles of SRP and Duplication to find a good set of methods
        // Hint: Try to describe in your own words what this code does
        // - this code is used to ... (the final result of the code). Use this wording to find good method names.
        // - look for and remove duplication

        String name1 = "Jef";
        int birthYear1 = 1988;
        int age1 = 2021 - birthYear1;
        boolean isAdult1;
        if(age1 > 18) {
            isAdult1 = true;
        } else {
            isAdult1 = false;
        }
        String name2 = "Sofie";
        int birthYear2 = 2005;
        int age2 = 2021 - birthYear2;
        boolean isAdult2;
        if(age2 > 18) {
            isAdult2 = true;
        } else {
            isAdult2 = false;
        }

        System.out.println("***********************");
        System.out.println("Hi my name is " + name1);
        System.out.println("I am " + age1 + " years old.");
        System.out.println("Which means I am");
        if(isAdult1) {
            System.out.println("an adult");
        } else {
            System.out.println("not an adult");
        }

        System.out.println("***********************");
        System.out.println("Hi my name is " + name2);
        System.out.println("I am " + age2 + " years old.");
        System.out.println("Which means I am");
        if(isAdult2) {
            System.out.println("an adult");
        } else {
            System.out.println("not an adult");
        }
    }
}
