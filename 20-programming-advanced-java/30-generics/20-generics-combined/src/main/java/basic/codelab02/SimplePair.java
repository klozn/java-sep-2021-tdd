package basic.codelab02;

public class SimplePair<T> implements Pair<T> {
    private T left;
    private T right;

    @Override
    public void store(T leftObject, T rightObject) {
        left = leftObject;
        right = rightObject;
    }

    @Override
    public T getLeft() {
        return left;
    }

    @Override
    public T getRight() {
        return right;
    }
}
