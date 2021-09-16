package codelab03.calculators;

import codelab03.BonusCalculator;

public class BonusCalculatorForGoodYear implements BonusCalculator {
    @Override
    public double calculate(double yearlySalary) {
        return yearlySalary / 12 * 1.4;
    }
}
