package basic.codelab01;

public abstract class Employee {

    private String name;
    private double basicAnnualSalary;

    public Employee(String name, int basicAnnualSalary) {
        this.name = name;
        this.basicAnnualSalary = basicAnnualSalary;
    }

    public String getName() {
        return name;
    }

    public double getBasicAnnualSalary() {
        return basicAnnualSalary;
    }

    public abstract double calculateMonthlySalary();
}
