package codelab06;

import java.util.Objects;

public class CoolEmployee {

    private static int numberOfCoolEmployees;

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public CoolEmployee(int id, String firstName, String lastName, int salary) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        numberOfCoolEmployees++;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        if (numberOfCoolEmployees == 0) {
            this.id = 0;
        }
        if (id <= numberOfCoolEmployees) {
            this.id = numberOfCoolEmployees + 1;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public double getAnnualSalary() {
        return salary * 13.9;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void raiseSalary(double percentage) {
        salary = (int) (salary + salary * percentage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoolEmployee that = (CoolEmployee) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "(" + id + ") " + getFullName() + " - " + salary + " EUR/month";
    }
}
