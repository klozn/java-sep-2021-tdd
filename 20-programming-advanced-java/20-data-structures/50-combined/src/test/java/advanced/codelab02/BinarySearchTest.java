package advanced.codelab02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    List<String> words = Arrays.asList("Never", "gonna", "give", "you", "up", "never", "gonna", "let", "you", "down");
    BinarySearch searchMachine = new BinarySearch();

    @Test
    void isElementInListTest() {
        String inList = "you";
        String notInList = "me";

        Collections.sort(words);
        boolean foundInList = searchMachine.isElementInList(inList, words);
        boolean foundNotInList = searchMachine.isElementInList(notInList, words);

        assertTrue(foundInList);
        assertFalse(foundNotInList);
    }
}