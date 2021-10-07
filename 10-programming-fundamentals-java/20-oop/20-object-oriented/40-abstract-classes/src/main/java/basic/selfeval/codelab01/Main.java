package basic.selfeval.codelab01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Employee reg = new RegularEmployee("Kurt", 24000);
        Manager man = new Manager("Bert", 50000, 100);
        try {
            man.setBonus(450);
        } catch (IllegalArgumentException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
        }

        System.out.println(reg.calculateMonthlySalary());
        System.out.println(man.calculateMonthlySalary());
    }
}
