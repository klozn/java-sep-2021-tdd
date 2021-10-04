package basic.codelab03;

public interface Pair<T, U> {
    void store(T leftObject, U rightObject);
    T getLeft();
    U getRight();
}
