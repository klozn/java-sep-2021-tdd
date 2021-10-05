package lambdas.advanced.codelab02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatcherTest {

    List<String> wordsToMatch = Arrays.asList("Crustaceans", "form", "a", "large", "diverse", "arthropod", "taxon",
            "which", "includes", "such", "animals", "as", "crabs", "lobsters", "crayfish", "shrimps", "prawns", "krill",
            "woodlice", "and", "barnacles");

    @Test
    void allMatches_wordLengthSmallerThanFour() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.length() < 4);
        assertTrue(matches.containsAll(List.of("a", "as", "and")));
        assertEquals(3, matches.size());
    }

    @Test
    void allMatches_wordsWithB() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.contains("b"));
        assertTrue(matches.containsAll(List.of("crabs", "lobsters", "barnacles")));
        assertEquals(3, matches.size());
    }

    @Test
    void allMatches_evenLengthWords() {
        var matches = Matcher.allMatches(wordsToMatch, s -> s.length() % 2 == 0);
        assertTrue(matches.containsAll(List.of("form", "includes", "such", "as", "lobsters", "crayfish",
                "prawns", "woodlice")));
        assertEquals(8, matches.size());
    }

    @Test
    void allMatches_numbersBiggerThanFiveHundred() {
        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10_000);
        var matches = Matcher.allMatches(nums, n -> n > 500);
        assertTrue(matches.containsAll(List.of(1000, 10_000)));
        assertEquals(2, matches.size());
    }

    List<String> wordsToTransform = Arrays.asList("this", "is", "exciting");
    @Test
    void transformedWords_addExclamationMark() {
        var transformed = Matcher.transformedList(wordsToTransform, s -> s + "!");
        for (String word : transformed) {
            assertTrue(word.contains("!"));
        }
        assertEquals(3, transformed.size());
    }

    @Test
    void transformedWords_giveSight() {
        var transformed = Matcher.transformedList(wordsToTransform, s -> s.replaceAll("i", "eye"));
        assertEquals("theyes", transformed.get(0));
        assertEquals("eyes", transformed.get(1));
        assertEquals("exceyeteyeng", transformed.get(2));
    }

    @Test
    void transformedWords_upperCase() {
        var transformed = Matcher.transformedList(wordsToTransform, String::toUpperCase);
        assertEquals("THIS", transformed.get(0));
        assertEquals("IS", transformed.get(1));
        assertEquals("EXCITING", transformed.get(2));
    }

    @Test
    void transformedWords_wordLengths() {
        var transformed = Matcher.transformedList(wordsToTransform, String::length);
        assertEquals(4, transformed.get(0));
        assertEquals(2, transformed.get(1));
        assertEquals(8, transformed.get(2));
    }
}