package advanced.codelab01.sorting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    SortingAlgorithm bubbleSort = new BubbleSort();

    @Test
    void sort_returnsIntegersSorted_SmallestToHighest() {
        List<Integer> integerList = GenerateRandomListOf(10);

        List<Integer> sorted = bubbleSort.sort(integerList);

        for (int i = 0; i < sorted.size() - 1; i++) {
            assertTrue(sorted.get(i) <= sorted.get(i + 1));
        }
    }

    private static List<Integer> GenerateRandomListOf(int amountOfElement)
    {
        var randomNumber = new Random();
        return IntStream.range(0, amountOfElement)
                .map(i -> randomNumber.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}