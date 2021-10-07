package basic.selfeval.codelab01;

public class RegularEmployee extends Employee {
    public RegularEmployee(String name, int basicAnnualSalary) {
        super(name, basicAnnualSalary);
    }

    @Override
    public double calculateMonthlySalary() {
        return getBasicAnnualSalary() / 12;
    }
}
