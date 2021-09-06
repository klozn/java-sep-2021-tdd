package basic;

public class MethodsCodelab12 {

    public static void main(String[] args) {
        printAgeEvaluation("Jef", 1988);
        printAgeEvaluation("Sofie", 2005);
    }

    public static void printAgeEvaluation(String name, int yearOfBirth) {
        System.out.println("***********************");
        System.out.println("Hi my name is " + name);
        int age = calcAge(yearOfBirth);
        System.out.println("I am " + age + " years old.");
        System.out.println("Which means I am");
        if (isAdult(age)) {
            System.out.println("an adult");
        } else {
            System.out.println("not an adult");
        }
    }

    public static int calcAge(int yearOfBirth) {
        return 2021 - yearOfBirth;
    }

    public static boolean isAdult(int age) {
        return age >= 18;
    }
}
