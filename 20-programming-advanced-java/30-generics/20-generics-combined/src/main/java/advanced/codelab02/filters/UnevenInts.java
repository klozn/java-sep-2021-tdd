package advanced.codelab02.filters;

import advanced.codelab02.Filter;

import java.util.Collection;
import java.util.stream.Collectors;

public class UnevenInts implements Filter<Integer> {
    @Override
    public Collection<Integer> apply(Collection<Integer> toFilter) {
        return toFilter.stream().filter(i -> i % 2 != 0)
                .collect(Collectors.toList());
    }
}
