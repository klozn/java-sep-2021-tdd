package lambdas.advanced.codelab02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Read the README.md file
 */
public class Matcher {

    public static List<String> allMatches(List<String> stringList, Predicate<String> predicate) {
        List<String> matches = new ArrayList<>();
        for (String s : stringList) {
            if (predicate.test(s)) {
                matches.add(s);
            }
        }
        return matches;
    }
}
