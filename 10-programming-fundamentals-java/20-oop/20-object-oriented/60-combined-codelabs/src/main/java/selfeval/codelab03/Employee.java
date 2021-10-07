package selfeval.codelab03;

/**
 * Read the README.md file
 */
public class Employee {

    private final double yearlySalary;
    private final String name;
    private BonusCalculator bonusCalculator;

    public Employee(String name, double yearlySalary) {
        this.name = name;
        this.yearlySalary = yearlySalary;
    }

    public String getName() {
        return name;
    }

    void setBonusCalculator(BonusCalculator bonusCalculator) {
        this.bonusCalculator = bonusCalculator;
    }

    double getBonus() {
        if(bonusCalculator == null) {
            throw new IllegalStateException("Impossible to calculate a bonus when no bonusCalculator is set");
        }
        return bonusCalculator.calculate(yearlySalary);
    }

    @Override
    public String toString() {
        return String.format("%s with yearly salary %.2f", name, yearlySalary);
    }
}
