package advanced.codelab02.filters;

import advanced.codelab02.Filter;

public class UnevenInts implements Filter<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 == 1;
    }
}
