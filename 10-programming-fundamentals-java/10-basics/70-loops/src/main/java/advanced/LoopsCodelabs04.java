package advanced;

public class LoopsCodelabs04 {

    /**
     * Given a array of ints,
     * return a new array containing the elements from the original array that come after the last number 4 in the original array.
     * The original array will contain at least one number 4,
     *      if not: return a new array containing only the element 4.
     * If an empty array is provided
     *      return a new array containing one element, 4.
     * Examples:
     *      getElementsAfter4([2, 4, 1, 2]) → [1, 2]
     *      getElementsAfter4([4, 1, 4, 2]) → [2]
     *      getElementsAfter4([4, 4, 1, 2, 3]) → [1, 2, 3]
     *      getElementsAfter4([2, 1, 1, 2]) → [4]
     *      getElementsAfter4([]) → [4]
     */
    public static int[] getElementsAfter4(int[] numbers) {
        if (numbers.length < 1) {
            return new int[]{4};
        }
        int indexOfLast4 = -1;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 4) {
                indexOfLast4 = i;
            }
        }
        if (indexOfLast4 == -1) {
            return new int[]{4};
        }
        
        int[] elementsAfter4 = new int[numbers.length - (indexOfLast4 + 1)];
        for (int i = 0; i < elementsAfter4.length; i++) {
            elementsAfter4[i] = numbers[i + indexOfLast4 + 1];
        }
        return elementsAfter4;
    }

}
