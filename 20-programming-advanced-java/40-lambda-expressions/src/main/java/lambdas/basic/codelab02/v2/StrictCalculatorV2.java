package lambdas.basic.codelab02.v2;

import java.util.function.Predicate;

/**
 * Read the README.md file
 */
public class StrictCalculatorV2 {

    public static int multiplyBy2(int operator, Predicate<Integer> validator) {
        if (!validator.test(operator)) {
            return operator;
        }
        return operator * 2;
    }

    public static void main(String[] args) {
        int result1 = StrictCalculatorV2.multiplyBy2(5, new Predicate<Integer>() {
            @Override
            public boolean test(Integer operator) {
                return operator >= 0 && operator <= 5;
            }
        });
        int result2 = StrictCalculatorV2.multiplyBy2(-2, new Predicate<Integer>() {
            @Override
            public boolean test(Integer operator) {
                return operator < 0 && operator > - 4;
            }
        });
        int result3 = StrictCalculatorV2.multiplyBy2(8, new Predicate<Integer>() {
            @Override
            public boolean test(Integer operator) {
                return operator > 7 && operator < 14;
            }
        });

        System.out.println("Should be equal to 10: " + result1);
        System.out.println("Should be equal to -4: " + result2);
        System.out.println("Should be equal to 16: " + result3);
    }

}
