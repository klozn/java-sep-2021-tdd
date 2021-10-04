package advanced.codelab02;

import java.util.Collection;

public class Counter {

    public <T> int genericCounter(Collection<T> collection, Filter<T> filter) {
        int count = 0;
        for (T element : collection) {
            if (filter.test(element)) {
                count++;
            }
        }
        return count;
    }
}
