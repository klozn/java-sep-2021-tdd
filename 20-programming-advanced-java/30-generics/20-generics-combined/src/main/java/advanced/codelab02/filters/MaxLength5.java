package advanced.codelab02.filters;

import advanced.codelab02.Filter;

public class MaxLength5 implements Filter<String> {
    @Override
    public boolean apply(String text) {
        return text.chars().count() <= 5;
    }
}
