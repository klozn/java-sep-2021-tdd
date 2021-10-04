package basic.codelab02;

public class MainApp {
    public static void main(String[] args) {
        Pair<String> stringPair = new SimplePair<>();
        Pair<Integer> integerPair = new SimplePair<>();
        Pair<Double> doublePair = new SimplePair<>();

        stringPair.store("hello", "darkness");
        integerPair.store(78, 43);
        doublePair.store(2.4, 99.99);

        System.out.printf("Strings: %s - %s || Integers: %d - %d || Doubles: %.2f - %.2f",
                stringPair.getLeft(), stringPair.getRight(),
                integerPair.getLeft(), integerPair.getRight(),
                doublePair.getLeft(), doublePair.getRight());
    }
}
