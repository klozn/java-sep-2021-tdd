package advanced.codelab02;

@FunctionalInterface
public interface Filter<T> {
    boolean apply(T object);
}
