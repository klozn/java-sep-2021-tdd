package basic.selfeval.codelab01;

public abstract class Employee {

    private final String name;
    private final double basicAnnualSalary;

    public Employee(String name, int basicAnnualSalary) {
        this.name = name;
        this.basicAnnualSalary = basicAnnualSalary;
    }

    public double getBasicAnnualSalary() {
        return basicAnnualSalary;
    }

    public abstract double calculateMonthlySalary();
}
