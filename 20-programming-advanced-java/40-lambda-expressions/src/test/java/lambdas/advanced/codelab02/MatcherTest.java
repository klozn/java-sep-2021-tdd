package lambdas.advanced.codelab02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MatcherTest {

    List<String> wordsToMatch = Arrays.asList("Crustaceans", "form", "a", "large", "diverse", "arthropod", "taxon",
            "which", "includes", "such", "animals", "as", "crabs", "lobsters", "crayfish", "shrimps", "prawns", "krill",
            "woodlice", "and", "barnacles");

    @Test
    void allMatches_wordLengthSmallerThanFour() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.length() < 4);
        assertThat(matches).containsExactly("a", "as", "and");
    }

    @Test
    void allMatches_wordsWithB() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.contains("b"));
        assertThat(matches).containsExactly("crabs", "lobsters", "barnacles");
    }

    @Test
    void allMatches_evenLengthWords() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.length() % 2 == 0);
        assertThat(matches).containsExactly("form", "includes", "such", "as", "lobsters",
                                            "crayfish", "prawns", "woodlice");
    }

    @Test
    void allMatches_numbersBiggerThanFiveHundred() {
        var nums = Arrays.asList(1, 10, 100, 1000, 10_000);
        var matches = Matcher.allMatches(nums, n -> n > 500);
        assertThat(matches).containsExactly(1000, 10_000);
    }

    List<String> wordsToTransform = Arrays.asList("this", "is", "exciting");

    @Test
    void transformedWords_addExclamationMark() {
        var transformed = Matcher.transformedList(wordsToTransform, s -> s + "!");
        assertThat(transformed).containsExactly("this!", "is!", "exciting!");
    }

    @Test
    void transformedWords_giveSight() {
        var transformed = Matcher.transformedList(wordsToTransform, s -> s.replaceAll("i", "eye"));
        assertThat(transformed).containsExactly("theyes", "eyes", "exceyeteyeng");
    }

    @Test
    void transformedWords_upperCase() {
        var transformed = Matcher.transformedList(wordsToTransform, String::toUpperCase);
        assertThat(transformed).containsExactly("THIS", "IS", "EXCITING");
    }

    @Test
    void transformedWords_wordLengths() {
        var transformed = Matcher.transformedList(wordsToTransform, String::length);
        assertThat(transformed).containsExactly(4, 2, 8);
    }
}