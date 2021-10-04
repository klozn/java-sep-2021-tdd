package advanced.codelab02;

import java.util.Collection;

public interface Filter<T> {
    Collection<T> apply(Collection<T> toFilter);
}
