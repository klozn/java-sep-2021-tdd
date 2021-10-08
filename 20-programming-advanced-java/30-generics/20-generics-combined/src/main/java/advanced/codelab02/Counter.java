package advanced.codelab02;

import java.util.Collection;

public class Counter {

    public <T> int genericCounter(Collection<T> collection, Filter<T> filter) {
        return (int) collection.stream()
                .filter(filter::apply)
                .count();
    }
}
