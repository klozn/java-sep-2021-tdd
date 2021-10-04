package basic.codelab01;

public class StringPair implements Pair<String> {
    private String left;
    private String right;

    @Override
    public void store(String leftString, String rightString) {
        left = leftString;
        right = rightString;
    }

    @Override
    public String getLeft() {
        return left;
    }

    @Override
    public String getRight() {
        return right;
    }
}
