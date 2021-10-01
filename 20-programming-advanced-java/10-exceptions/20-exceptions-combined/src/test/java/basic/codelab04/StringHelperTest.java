package basic.codelab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    private static final String[] TEST_STRING_ARRAY = new String[]{"a", "b"};

    @Test
    void repeatArrayReturnsExpectedResult() {
        String repeated = StringHelper.repeatArray(TEST_STRING_ARRAY, 3);
        assertEquals("aaabbb", repeated);
    }

    @Test
    void repeatArray_whenNegativeCount_doesNotThrowIllegalArgumentException() {
        assertDoesNotThrow(() -> StringHelper.repeatArray(TEST_STRING_ARRAY, -1));
    }

    @Test
    void repeatArray_whenArrayIsNull_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringHelper.repeatArray(null, 1));
    }

}