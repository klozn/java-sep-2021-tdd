package basic;

public class ArraysCodelab07 {


    /**
     * Change the following code so that it uses an array instead of a list of variables.
     */
    public static void main(String[] args) {
        boolean sum = true;
        boolean average = false;

        double[] numberArr = new double[] {34, 12, 24, 89, 10, 96, 74, 67, 46, 53};

        System.out.println("The sum is: " + calculateSumOrAverage(sum, numberArr));
        System.out.println("The average is: " + calculateSumOrAverage(average, numberArr));
    }

    private static double calculateSumOrAverage(boolean isSum, double[] numbers) {
        double sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4] + numbers[5] + numbers[6]
                + numbers[7] + numbers[8] + numbers[9];

        if(isSum) {
            return sum;
        }
        return sum / numbers.length;
    }
}
