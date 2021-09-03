package basic;

public class MethodsCodelab03 {

    public static void main(String[] args) {
        double result = 0;
        // Call the calculatePercentageValue(...) method 3 times
        //      1. Using value 100 and 80%
        result = calculatePercentageValue(100, .8f);
        System.out.println(result);
        //      2. Using value 250 and 5%
        result = calculatePercentageValue(250, .05f);
        System.out.println(result);
        //      3. Using 625 and 25%
        result = calculatePercentageValue(625, .25f);
        System.out.println(result);
        // Make sure to print (write to the console) each result.
    }

    /**
     * Calculates the percentage value of the given value using the given percentage.
     *      E.g. Given value 50 and 0.25 (percentage), returns value 12.5.
     * @param originalValue - the value for which we will calculate the percentage value
     * @param percentage - the percentage to use, range [0, 1]
     * @return the calculated percentage value
     */
    // (don't change this method)
    private static float calculatePercentageValue(int originalValue, float percentage) {
        return originalValue * percentage;
    }

}
