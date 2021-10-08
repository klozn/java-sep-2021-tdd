package lambdas.advanced.codelab02;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Read the README.md file
 */
public class Matcher {

    public static <E> List<E> allMatches(List<E> list, Predicate<E> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T, U> List<U> transformedList(List<T> list, Function<T, U> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
