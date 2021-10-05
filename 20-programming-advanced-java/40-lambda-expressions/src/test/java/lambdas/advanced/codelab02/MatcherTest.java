package lambdas.advanced.codelab02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {

    List<String> words = Arrays.asList("Crustaceans", "form", "a", "large", "diverse", "arthropod", "taxon",
            "which", "includes", "such", "animals", "as", "crabs", "lobsters", "crayfish", "shrimps", "prawns", "krill",
            "woodlice", "and", "barnacles");

    @Test
    void allMatches_wordLengthSmallerThanFour() {
        var matches = Matcher.allMatches(words, s -> s.length() < 4);
        assertTrue(matches.containsAll(List.of("a", "as", "and")));
        assertEquals(3, matches.size());
    }

    @Test
    void allMatches_wordsWithB() {
        var matches = Matcher.allMatches(words, s -> s.contains("b"));
        assertTrue(matches.containsAll(List.of("crabs", "lobsters", "barnacles")));
        assertEquals(3, matches.size());
    }

    @Test
    void allMatches_evenLengthWords() {
        var matches = Matcher.allMatches(words, s -> s.length() % 2 == 0);
        assertTrue(matches.containsAll(List.of("form", "includes", "such", "as", "lobsters", "crayfish",
                "prawns", "woodlice")));
        assertEquals(8, matches.size());
    }
}