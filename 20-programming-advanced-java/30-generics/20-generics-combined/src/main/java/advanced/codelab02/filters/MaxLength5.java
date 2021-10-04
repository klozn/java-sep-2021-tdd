package advanced.codelab02.filters;

import advanced.codelab02.Filter;

import java.util.Collection;
import java.util.stream.Collectors;

public class MaxLength5 implements Filter<String> {
    @Override
    public Collection<String> apply(Collection<String> toFilter) {
        return toFilter.stream().filter(s -> s.chars().count() <= 5)
                .collect(Collectors.toList());
    }
}
