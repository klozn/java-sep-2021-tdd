package advanced;

import java.util.Arrays;

public class ArraysCodelab06 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(enlarge(new int[]{7, 4})));
    }

    /**
     * Implement this method so that it transforms an array of length 2 to an array of length 10.
     *
     * All elements that were in the initial array need to be also in the new array.
     * If the input array isn't of length 2 do nothing and just return the input array.
     *
     * 1. The happy path is that you assume that all input arrays are of length 2.
     * 2. You check if the length is 2 and return the input array if that is not the case.
     *
     * Visual example:
     * Say you have the following array [12, 24]
     *
     * In the memory this will look like this:
     *   memory address      value in memory
     *      XX0                     12 <- pointer too start of array
     *      XX1                     24
     *
     * And the returned array will look something like this:
     *   memory address      value in memory
     *      XX0                     12 <- pointer too start of array
     *      XX1                     24
     *      XX2                      0
     *      XX3                      0
     *      XX4                      0
     *      XX5                      0
     *      XX6                      0
     *      XX7                      0
     *      XX8                      0
     *      XX9                      0
     *
     */
    public static int[] enlarge(int[] array) {
        if (!isArrayWithLength2(array)) {
            return array;
        }
        return initializeArrayOfSize10(0, 1, array);
    }

    /**
     * Implement this method so that it transforms an array of length 2 to an array of length 10.
     *
     * All elements that were in the initial array need to be also in the new array.
     * This time the old elements need to be put in the back (see the visual example).
     * If the input array isn't of length 2 do nothing and just return the input array.
     *
     * 1. The happy path is that you assume that all input arrays are of length 2.
     * 2. You check if the length is 2 and return the input array if that is not the case.
     *
     * Visual example:
     * Say you have the following array [12, 24]
     *
     * In the memory this will look like this:
     *   memory address      value in memory
     *      XX0                     12 <- pointer too start of the array
     *      XX1                     24
     *
     * And the returned array will look something like this:
     *   memory address      value in memory
     *      XX0                      0 <- pointer too start of the array
     *      XX1                      0
     *      XX2                      0
     *      XX3                      0
     *      XX4                      0
     *      XX5                      0
     *      XX6                      0
     *      XX7                      0
     *      XX8                      12
     *      XX9                      24
     *
     */
    public static int[] enlargeFromTheFront(int[] array) {
        if (!isArrayWithLength2(array)) {
            return array;
        }
        return initializeArrayOfSize10(8, 9, array);
    }

    private static boolean isArrayWithLength2(int[] array) {
        return array.length == 2;
    }

    private static int[] initializeArrayOfSize10(int index1, int index2, int[] arrayOfSize2) {
        int[] largeArr = new int[10];
        largeArr[index1] = arrayOfSize2[0];
        largeArr[index2] = arrayOfSize2[1];
        return largeArr;
    }
}
