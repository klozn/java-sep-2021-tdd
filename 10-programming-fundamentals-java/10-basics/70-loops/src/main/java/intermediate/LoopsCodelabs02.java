package intermediate;

public class LoopsCodelabs02 {

    /**
     * Create a method that will return an array that contains all the numbers from 1 to n.
     * With n being the argument.
     * If n is smaller than one return an empty array
     * E.g. createRange(10) will return {1,2,3,4,5,6,7,8,9,10}
     */
    public static int[] createRange(int range) {
        if (range < 1) {
            return new int[]{};
        }

        int[] intArr = new int[range];
        for (int i = 0; i < range; i++) {
            intArr[i] = i + 1;
        }
        return intArr;
    }
}
