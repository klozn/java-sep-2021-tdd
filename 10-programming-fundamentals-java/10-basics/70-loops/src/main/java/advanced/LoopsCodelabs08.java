package advanced;

public class LoopsCodelabs08 {

    /**
     * Given two arrays of ints sorted in increasing order, outer and inner,
     * return true if all of the numbers in inner appear in outer.
     * The best solution makes only a single "linear" pass of both arrays,
     * taking advantage of the fact that both arrays are already in sorted order.
     * Check the tests to see which edge cases exist and how you should respond to them!
     *      doesOuterContainAllElementsOfInner([1, 2, 4, 6], [2, 4]) → true
     *      doesOuterContainAllElementsOfInner([1, 2, 4, 6], [2, 3, 4]) → false
     *      doesOuterContainAllElementsOfInner([1, 2, 4, 4, 6], [2, 4]) → true
     *      doesOuterContainAllElementsOfInner([1, 2, 8, 800, 1050], [1, 800]) → true
     */
    public static boolean doesOuterContainAllElementsOfInner(int[] outer, int[] inner) {
        if (inner.length < 1) {
            return true;
        }
        if (inner.length > outer.length) {
            throw new IllegalArgumentException("Inner cannot be bigger than outer");
        }

        int nrOfElementsOfInnerInOuter = 0;
        for (int i: inner) {
            boolean found = false;
            for (int j = 0; j < outer.length && !found; j++) {
                if (outer[j] == i) {
                    found = true;
                    nrOfElementsOfInnerInOuter++;
                }
            }
        }
        return nrOfElementsOfInnerInOuter == inner.length;
    }

}
