package lambdas.advanced.codelab02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Read the README.md file
 */
public class Matcher {

    public static <E> List<E> allMatches(List<E> list, Predicate<E> predicate) {
        List<E> matches = new ArrayList<>();
        for (E element : list) {
            if (predicate.test(element)) {
                matches.add(element);
            }
        }
        return matches;
    }
}
