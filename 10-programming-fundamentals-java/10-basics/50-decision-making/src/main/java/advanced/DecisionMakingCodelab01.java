package advanced;

public class DecisionMakingCodelab01 {

    public static void main(String[] args) {
        System.out.println("Your tax rate is: " + calculateTaxRate(52000, 3000, true, 4));
    }

    /**
     * This program has very ugly nested if's. Can you make the code more readable by removing the nesting?
     * Run the test afterwards to see if everything still works.
     */
    public static double calculateTaxRate(int earnings, int fringeBenefits, boolean dependentChildren, int vacationDays) {
        if (earnings <= 40000) {
            return 0.2;
        }
        if (fringeBenefits < 2000) {
            return 0.3;
        }
        if (dependentChildren && vacationDays > 5) {
            return 0.35;
        }
        if (dependentChildren && fringeBenefits < 5000) {
            return 0.33;
        }
        if (dependentChildren) {
            return 0.34;
        } else {
            return 0.4;
        }

    }
}
