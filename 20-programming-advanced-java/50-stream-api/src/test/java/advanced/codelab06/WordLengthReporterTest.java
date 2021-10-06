package advanced.codelab06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordLengthReporterTest {
    WordLengthReporter reporter = new WordLengthReporter();
    @Test
    void reportAmountOfWordsPerWordLengthTest() {
        assertEquals("2:1, 4:1", reporter.reportAmountOfWordsPerWordLength("test ok"));
        assertEquals("2:3, 4:1", reporter.reportAmountOfWordsPerWordLength("uk ok gold go"));
        assertEquals("3:2, 4:1, 5:1, 14:1",
                reporter.reportAmountOfWordsPerWordLength("blue black red transformation bed"));
    }

}