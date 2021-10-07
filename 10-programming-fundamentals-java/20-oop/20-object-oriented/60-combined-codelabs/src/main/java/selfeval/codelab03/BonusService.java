package selfeval.codelab03;

import selfeval.codelab03.calculators.BonusCalculatorForBadYear;
import selfeval.codelab03.calculators.BonusCalculatorForExceptionalEmployees;
import selfeval.codelab03.calculators.BonusCalculatorForGoodYear;

import java.util.List;
import java.util.StringJoiner;

/**
 * Read the README.md file
 */
class BonusService {

    public final static BonusCalculator CALC_FOR_BAD_YEAR = new BonusCalculatorForBadYear();
    public final static BonusCalculator CALC_FOR_GOOD_YEAR = new BonusCalculatorForGoodYear();
    public final static BonusCalculator CALC_FOR_EXCEPTIONAL_EMPL = new BonusCalculatorForExceptionalEmployees();

    static void setBonusCalculatorsBasedOnYear(List<Employee> employees, int bonusYear) {
        if (isABadYear(bonusYear)) {
            for (Employee employee : employees) {
                employee.setBonusCalculator(CALC_FOR_BAD_YEAR);
            }
        } else {
            for (Employee employee : employees) {
                employee.setBonusCalculator(CALC_FOR_GOOD_YEAR);
            }
        }
    }

    static String calculateBonuses(List<Employee> employees) {
        StringJoiner joiner = new StringJoiner("\n");
        for(Employee employee: employees) {
            joiner.add("Bonus for " + employee.getName() + " is " + employee.getBonus());
        }
        return joiner.toString();
    }

    private static boolean isABadYear(int bonusYear) {
        return bonusYear == 2014 || bonusYear == 2015 || bonusYear == 2016;
    }

}
