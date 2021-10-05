package advanced.codelab01;

import advanced.codelab01.sorting.BubbleSort;
import advanced.codelab01.sorting.InsertionSort;
import advanced.codelab01.sorting.SelectionSort;
import advanced.codelab01.sorting.SortingAlgorithm;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingApplication {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        List<Integer> numbersToSortSmall = List.of(5, 4, 8, 9, 1, 2, 8);
        List<Integer> numbersToSortLarge = GenerateRandomListOf(150000);

        SortingAlgorithm insertionSort = new InsertionSort();
        SortingAlgorithm selectionSort = new SelectionSort();
        SortingAlgorithm bubbleSort = new BubbleSort();

        System.out.println("Sort Small");
        System.out.println("\tInsertion sort result:");
        System.out.println("\t\t" + insertionSort.sort(numbersToSortSmall));
        System.out.println("\tSelection sort result:");
        System.out.println("\t\t" + selectionSort.sort(numbersToSortSmall));
        System.out.println("\tBubble sort result:");
        System.out.println("\t\t" + bubbleSort.sort(numbersToSortSmall));

        System.out.println("---------------");
        System.out.println("Sort Large");
        System.out.println("\tInsertion sort result (large):");
        long startTime = System.currentTimeMillis();
        System.out.println("\t\t" + insertionSort.sort(numbersToSortLarge));
        long finishTime = System.currentTimeMillis();
        logger.log(Level.INFO, "insertion sort done in " + (finishTime - startTime) + " milliseconds.");
        System.out.println("\tSelection sort result (large):");
        startTime = System.currentTimeMillis();
        System.out.println("\t\t" + selectionSort.sort(numbersToSortLarge));
        finishTime = System.currentTimeMillis();
        logger.log(Level.INFO, "selection sort done in " + (finishTime - startTime) + " milliseconds.");
        System.out.println("\tBubble sort result (large):");
        startTime = System.currentTimeMillis();
        System.out.println("\t\t" + bubbleSort.sort(numbersToSortLarge));
        finishTime = System.currentTimeMillis();
        logger.log(Level.INFO, "bubble sort done in " + (finishTime - startTime) + " milliseconds.");
    }

    private static List<Integer> GenerateRandomListOf(int amountOfElement)
    {
        var randomNumber = new Random();
        return IntStream.range(0, amountOfElement)
                .map(i -> randomNumber.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}
