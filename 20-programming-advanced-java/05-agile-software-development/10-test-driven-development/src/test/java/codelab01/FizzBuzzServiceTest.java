package codelab01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FizzBuzz:")
class FizzBuzzServiceTest {
    final FizzBuzzService service = new FizzBuzzService();

    @Test
    @DisplayName("Given X returns array of strings with size X")
    void fizzBuzz_whenGiven6_thenReturnsArrayWithSize6() {
        //given
        int testArgument = 6;
        //when
        String[] resultArray = service.fizzBuzz(testArgument);
        //then
        assertEquals(testArgument, resultArray.length);
    }

    @Test
    @DisplayName("Given number smaller than 1 throws IllegalArgumentException")
    void fizzBuzz_whenGivenArgumentSmallerThanOne_thenThrowsIllegalArgumentException() {
        //given
        int testArgument = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> service.fizzBuzz(testArgument));
    }

    @Test
    @DisplayName("Given 1 throws IllegalArgumentException")
    void fizzBuzz_whenGivenOne_thenThrowsIllegalArgumentException() {
        //given
        int testArgument = 1;
        //then
        assertThrows(IllegalArgumentException.class, () -> service.fizzBuzz(testArgument));
    }

    @Test
    @DisplayName("IllegalArgumentException has custom message")
    void fizzBuzz_illegalArgumentExceptionHasCustomMessage() {
        //given
        int testArgument = 1;
        String expectedMessage = "'X' can't be smaller than 2";
        //when
        try {
            service.fizzBuzz(testArgument);
        } catch (IllegalArgumentException exception) {
            //then
            assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    @DisplayName("All numbers divisible by 3 are returned as 'Fizz'")
    void fizzBuzz_whenNumberIsDivisibleByThree_thenReturnFizz() {
        //given
        int testArgument = 8;
        int index = 2;
        //when
        String[] resultArray = service.fizzBuzz(testArgument);
        //then
        while (index < testArgument) {
            assertEquals("Fizz", resultArray[index]);
            index += 3;
        }
    }

    @Test
    @DisplayName("All numbers divisible by 5 are returned as 'Buzz'")
    void fizzBuzz_whenNumberIsDivisibleByFive_thenReturnBuzz() {
        //given
        int testArgument = 11;
        int index = 4;
        //when
        String[] resultArray = service.fizzBuzz(testArgument);
        //then
        while (index < testArgument) {
            assertEquals("Buzz", resultArray[index]);
            index += 5;
        }
    }

    @Test
    @DisplayName("All numbers divisible by both 5 and 3 are returned as 'FizzBuzz'")
    void fizzBuzz_whenNumberIsDivisibleByThreeAndFive_thenReturnFizzBuzz() {
        //given
        int testArgument = 31;
        //when
        String[] resultArray = service.fizzBuzz(testArgument);
        //then
        for (int i = 0; i < testArgument; i++) {
            if ((i + 1) % 5 == 0 && (i + 1) % 3 == 0) {
                assertEquals("FizzBuzz", resultArray[i]);
            }
        }
    }

}