package basic.codelab03;

/**
 * Read the README.md file
 */
public class StrictCalculator {

    public static int multiplyBy2(int operator, Filter filter) {
        if (!filter.isValid(operator)) {
            return operator;
        }
        return operator * 2;
    }

    public static void main(String[] args) {
        int result1 = StrictCalculator.multiplyBy2(5, new Filter() {
            @Override
            public boolean isValid(int number) {
                return number >= 0 && number <= 5;
            }
        });
        int result2 = StrictCalculator.multiplyBy2(-2, new Filter() {
            @Override
            public boolean isValid(int number) {
                return number < 0 && number > -4;
            }
        });
        int result3 = StrictCalculator.multiplyBy2(8, new Filter() {
            @Override
            public boolean isValid(int number) {
                return number > 7 && number < 14;
            }
        });

        System.out.println("Should be equal to 10: " + result1);
        System.out.println("Should be equal to -4: " + result2);
        System.out.println("Should be equal to 16: " + result3);
    }

}
