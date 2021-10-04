package basic.codelab03;

public class MainApp {
    public static void main(String[] args) {
        Pair<String, Integer> stringNumberPair = new FlexPair<>();
        Pair<String, String> stringPair = new FlexPair<>();
        SimplePair<String> simpleStringPair = new SimplePair<>();

        stringNumberPair.store("myNumber", 3);
        stringPair.store("SomeText", "MoreText");
        simpleStringPair.store("Tony", "Soprano");

        String leftString1 = stringNumberPair.getLeft();
        int rightInt1 = stringNumberPair.getRight();
        String leftString2 = stringPair.getLeft();
        String rightString2 = stringPair.getRight();
        String leftString3 = simpleStringPair.getLeft();
        String rightString3 = simpleStringPair.getRight();

        System.out.printf("StringNumber: %s - %d || StringFlex: %s - %s || StringSimple: %s - %s",
                leftString1, rightInt1, leftString2, rightString2, leftString3, rightString3);
    }
}
