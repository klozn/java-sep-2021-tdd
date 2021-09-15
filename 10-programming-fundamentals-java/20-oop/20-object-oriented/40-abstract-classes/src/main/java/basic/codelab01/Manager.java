package basic.codelab01;

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
        if (bonus >= 100 && bonus <= 150) {
            this.bonus = bonus;
        }
    }

    @Override
    public double calculateMonthlySalary() {
        return getBasicAnnualSalary() / 11 + getBonus();
    }
}
