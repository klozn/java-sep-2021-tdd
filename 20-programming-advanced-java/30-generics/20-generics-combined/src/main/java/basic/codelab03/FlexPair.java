package basic.codelab03;

public class FlexPair<T, U> implements Pair<T, U> {
    private T left;
    private U right;

    @Override
    public void store(T leftObject, U rightObject) {
        left = leftObject;
        right = rightObject;
    }

    @Override
    public T getLeft() {
        return left;
    }

    @Override
    public U getRight() {
        return right;
    }
}
