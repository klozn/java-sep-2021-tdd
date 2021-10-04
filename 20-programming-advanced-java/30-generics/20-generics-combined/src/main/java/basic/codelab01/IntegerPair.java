package basic.codelab01;

public class IntegerPair implements Pair<Integer> {
    private int left;
    private int right;
    @Override
    public void store(Integer leftInteger, Integer rightInteger) {
        left = leftInteger;
        right = rightInteger;
    }

    @Override
    public Integer getLeft() {
        return left;
    }

    @Override
    public Integer getRight() {
        return right;
    }
}
