package advanced;

public class LoopsCodelabs05 {

    /**
     * Given an array length of ints,
     * return the difference between the largest and smallest values in the array.
     * If the array contains less than 2 elements, return 0
     *      minMaxDifference([10, 3, 5, 6]) → 7
     *      minMaxDifference([7, 2, 10, 9]) → 8
     *      minMaxDifference([2, 10, 7, 2]) → 8
     * Tip: go take a look at the Math.min and .max methods.
     */
    public static int minMaxDifference(int[] numbers) {
        if (numbers.length < 2) {
            return 0;
        }
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        return max - min;
    }

}
