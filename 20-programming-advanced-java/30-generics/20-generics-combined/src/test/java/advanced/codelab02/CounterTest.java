package advanced.codelab02;

import advanced.codelab02.filters.MaxLength5;
import advanced.codelab02.filters.UnevenInts;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    Counter counter = new Counter();

    @Test
    void genericCounter_worksWithStrings() {
        Filter<String> filter = new MaxLength5();
        int count = counter.genericCounter(Set.of("HELLO", "Wooooooorld", "ok"), filter);
        assertEquals(2, count);
    }

    @Test
    void genericCounter_worksWithIntegers() {
        Filter<Integer> filter = new UnevenInts();
        int count = counter.genericCounter(List.of(1, 2, 3, 4, 5, 6, 7), filter);
        assertEquals(4, count);
    }
}