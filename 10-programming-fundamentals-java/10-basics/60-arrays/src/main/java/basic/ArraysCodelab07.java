package basic;

public class ArraysCodelab07 {


    /**
     * Change the following code so that it uses an array instead of a list of variables.
     */
    public static void main(String[] args) {
        boolean sum = true;
        boolean average = false;

        double number1 = 34;
        double number2 = 12;
        double number3 = 24;
        double number4 = 89;
        double number5 = 10;
        double number6 = 96;
        double number7 = 74;
        double number8 = 67;
        double number9 = 46;
        double number10 = 53;

        System.out.println("The sum is: " + calculateSumOrAverage(sum, number1, number2, number3, number4, number5, number6, number7, number8, number9, number10));
        System.out.println("The average is: " + calculateSumOrAverage(average, number1, number2, number3, number4, number5, number6, number7, number8, number9, number10));
    }

    private static double calculateSumOrAverage(boolean isSum, double number1, double number2, double number3, double number4, double number5, double number6, double number7, double number8, double number9, double number10) {
        double sum = number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9 + number10;

        if(isSum) {
            return sum;
        }
        return sum / 10;
    }
}
