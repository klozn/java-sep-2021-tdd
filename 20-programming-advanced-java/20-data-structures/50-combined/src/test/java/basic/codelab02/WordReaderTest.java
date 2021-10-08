package basic.codelab02;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class WordReaderTest {
    private static final Collection<String> WORD_COLLECTION = List.of("Never", "Gonna", "Give", "You", "Up");
    private static final Set<String> WORD_SET = Set.of("Never", "Gonna", "Give", "You", "Up");
    private static final List<String> WORD_LIST = List.of("Never", "Gonna", "Give", "You", "Up");
    private static final Queue<String> WORD_QUEUE = new PriorityQueue<>(WORD_LIST);
    private final WordReader wordReader = new WordReader();

    @Test
    void capitalizeAll_whenCollectionTest() {
        List<String> words = wordReader.capitalizeAll(WORD_COLLECTION);
        assertThat(words).containsExactly("NEVER", "GONNA", "GIVE", "YOU", "UP");
    }

    @Test
    void capitalizeAll_whenSetTest() {
        List<String> words = wordReader.capitalizeAll(WORD_SET);
        assertThat(words).containsExactlyInAnyOrder("NEVER", "GONNA", "GIVE", "YOU", "UP");
    }

    @Test
    void capitalizeAll_whenListTest() {
        List<String> words = wordReader.capitalizeAll(WORD_LIST);
        assertThat(words).containsExactly("NEVER", "GONNA", "GIVE", "YOU", "UP");
    }

    @Test
    void capitalizeAll_whenQueueTest() {
        List<String> words = wordReader.capitalizeAll(WORD_QUEUE);
        assertThat(words).containsExactlyInAnyOrder("NEVER", "GONNA", "GIVE", "YOU", "UP");
    }
}