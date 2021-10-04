package basic.codelab01;

public class MainApp {
    public static void main(String[] args) {
        Pair<Integer> integerPair = new IntegerPair();
        Pair<String> stringPair = new StringPair();
        integerPair.store(5, 7);
        stringPair.store("good", "boy");
        //integerPair.store("hello", "goodbye");
        String leftString = stringPair.getLeft();
        String rightString = stringPair.getRight();
        int leftInt = integerPair.getLeft();
        int rightInt = integerPair.getRight();

        System.out.printf("Strings : %s - %s  Integers : %d - %d", leftString, rightString, leftInt, rightInt);
    }
}
