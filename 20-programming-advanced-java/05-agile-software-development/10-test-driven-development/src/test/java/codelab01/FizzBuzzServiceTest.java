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
        String[] resultArray = fizzBuzz(testArgument);
        //then
        assertEquals(testArgument, resultArray.length);
    }

    @Test
    @DisplayName("Given number smaller than 1 throws IllegalArgumentException")
    void fizzBuzz_whenGivenArgumentSmallerThanOne_thenThrowsIllegalArgumentException() {
        //given
        int testArgument = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz(testArgument));
    }

    @Test
    @DisplayName("Given 1 throws IllegalArgumentException")
    void fizzBuzz_whenGivenOne_thenThrowsIllegalArgumentException() {
        //given
        int testArgument = 1;
        //then
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz(testArgument));
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
        int testArgument = 4;
        //when
        String[] resultArray = fizzBuzz(testArgument);
        //then
        assertEquals("Fizz", resultArray[2]);
    }

    @Test
    @DisplayName("All numbers divisible by 5 are returned as 'Buzz'")
    void fizzBuzz_whenNumberIsDivisibleByFive_thenReturnBuzz() {
        //given
        int testArgument = 11;
        //when
        String[] resultArray = fizzBuzz(testArgument);
        //then
        assertEquals("Buzz", resultArray[4]);
    }

    @Test
    @DisplayName("All numbers divisible by both 5 and 3 are returned as 'FizzBuzz'")
    void fizzBuzz_whenNumberIsDivisibleByThreeAndFive_thenReturnFizzBuzz() {
        //given
        int testArgument = 16;
        //when
        String[] resultArray = fizzBuzz(testArgument);
        //then
        assertArrayEquals(new String[] {"1","2","Fizz","4","Buzz", "Fizz", "7", "8",
        "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16"}, resultArray);
    }

    private String[] fizzBuzz(int argument) {
        return service.fizzBuzz(argument);
    }

}