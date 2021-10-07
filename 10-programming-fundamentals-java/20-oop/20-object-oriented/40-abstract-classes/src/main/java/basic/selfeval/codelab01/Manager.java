package basic.selfeval.codelab01;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int basicAnnualSalary, int bonus) {
        super(name, basicAnnualSalary);
        setBonus(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if (bonus < 100 || bonus > 250) {
            throw new IllegalArgumentException("Bonus can't be lower than 100 or higher than 250.");
        }
        this.bonus = bonus;
    }

    @Override
    public double calculateMonthlySalary() {
        return getBasicAnnualSalary() / 11 + getBonus();
    }
}
