package lambdas.basic.codelab02.v1;

/**
 * Read the README.md file
 */
public class StrictCalculatorV1 {

    public static int multiplyBy2(int operator, OperatorValidator validator) {
        if (!validator.isValid(operator)) {
            return operator;
        }
        return operator * 2;
    }

    public static void main(String[] args) {
        int result1 = StrictCalculatorV1.multiplyBy2(5, new PositiveAndSmallerThanSix());
        int result2 = StrictCalculatorV1.multiplyBy2(-2, new NegativeAndBiggerThanFour());
        int result3 = StrictCalculatorV1.multiplyBy2(8, new BiggerThanSevenSmallerThanFourteen());

        System.out.println("Should be equal to 10: " + result1);
        System.out.println("Should be equal to -4: " + result2);
        System.out.println("Should be equal to 16: " + result3);
    }

}
