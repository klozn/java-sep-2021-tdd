package basic.codelab01;

public class Main {
    public static void main(String[] args) {
        Employee reg = new RegularEmployee("Kurt", 24000);
        Manager man = new Manager("Bert", 50000, 100);
        man.setBonus(450);

        System.out.println(reg.calculateMonthlySalary());
        System.out.println(man.calculateMonthlySalary());
    }
}
