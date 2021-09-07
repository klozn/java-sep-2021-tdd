package intermediate;

public class LoopsCodelabs03 {

    /**
     * Create a merge function that merges two arrays into one.
     * The merge function must mix the elements like a zipper
     * E.G. merge({1,2,3}{1,2,3}) -> {1,1,2,2,3,3}
     * <p>
     * If both arrays are of a different length return an empty array
     */
    public static int[] merge(int[] array1, int[] array2) {
        if (array1.length < 1 || array2.length < 1) {
            return new int[]{};
        }

        if (array1.length != array2.length) {
            return new int[]{};
        }

        int[] mergedArr = new int[array1.length * 2];
        for (int i = 0; i < mergedArr.length; i++) {
            if (i % 2 == 0) {
                mergedArr[i] = array1[i/2];
            } else {
                mergedArr[i] = array2[i/2];
            }
        }
       return mergedArr;
    }
}
