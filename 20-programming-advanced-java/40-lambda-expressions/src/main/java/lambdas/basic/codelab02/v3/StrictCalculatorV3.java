package lambdas.basic.codelab02.v3;

import java.util.function.Predicate;

/**
 * Read the README.md file
 */
public class StrictCalculatorV3 {

    public static int multiplyBy2(int operator, Predicate<Integer> validator) {
        if (!validator.test(operator)) {
            return operator;
        }
        return operator * 2;
    }

    public static void main(String[] args) {
        int result1 = StrictCalculatorV3.multiplyBy2(5, n -> n >= 0 && n <= 5);
        int result2 = StrictCalculatorV3.multiplyBy2(-2, n -> n < 0 && n > -4);
        int result3 = StrictCalculatorV3.multiplyBy2(8, n -> n > 7 && n < 14);

        System.out.println("Should be equal to 10: " + result1);
        System.out.println("Should be equal to -4: " + result2);
        System.out.println("Should be equal to 16: " + result3);
    }

}
