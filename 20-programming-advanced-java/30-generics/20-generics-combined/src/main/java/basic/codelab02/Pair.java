package basic.codelab02;

public interface Pair<T> {
    void store(T leftObject, T rightObject);
    T getLeft();
    T getRight();
}
