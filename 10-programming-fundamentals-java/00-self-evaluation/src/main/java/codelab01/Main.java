package codelab01;

/**
 * Read the README.md for the assignment
 */
public class Main {

    public static void printHelloWorld() {
        System.out.println("Hello World");
    }

    public static void printAny(String text) {
        System.out.println(text);
    }

    public static void printNumber(int number) {
        System.out.println("I'm an int: " + number);
    }

    public static void printNumber(double number) {
        System.out.println("I'm a double: " + number);
    }

    public static int addOne(int number) {
        return number + 1;
    }

    public static void main(String[] args) {
        printHelloWorld();
        printAny("How's the weather?");
        printNumber(65);
        printNumber(3.50);
        System.out.println(addOne(6));
    }
}
