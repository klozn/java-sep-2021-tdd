package advanced.selfeval.codelab01;

import advanced.selfeval.codelab01.soldiers.*;

import java.util.List;

public class BattleSimulatorService {
    public static void main(String[] args) {

        Army switchFullyArmy = new Army("SwitchFully Army",
                List.of(
                        new Archer("Legolas", 34),
                        new Archer("Thorgal", 42),
                        new AxeThrower("Gimli", 125),
                        new Pikeman("Pierre", 21),
                        new Slave("Rupert", 19),
                        new Swordsman("Aragorn", 215),
                        new Swordsman("Beatrijs", 27)
                ));

        Army otherArmy = new Army("Another Army",
                List.of(
                        new Pikeman("Pico", 34),
                        new Archer("Thorgal", 42),
                        new AxeThrower("Gimli", 125),
                        new Pikeman("Pierre", 21),
                        new Slave("Rupert", 19),
                        new Swordsman("Aragorn", 215),
                        new Swordsman("Beatrijs", 27),
                        new Slave("unknown", 14)
                ));

        Army combinedArmy = Army.mergeArmies(switchFullyArmy, otherArmy, "Combined");

        Army smallArmy = new Army("Small Army",
                List.of(
                        new Archer("Legolas", 34),
                        new Pikeman("Pierre", 21),
                        new Slave("Rupert", 19),
                        new Swordsman("Beatrijs", 27)
                ));

        System.out.println(fight(combinedArmy, smallArmy));
        System.out.println(fight(switchFullyArmy, otherArmy));
        System.out.println(fight(otherArmy, switchFullyArmy));
        System.out.println(fight(smallArmy, combinedArmy));

        System.out.println(switchFullyArmy.statusReport());
        System.out.println(otherArmy.statusReport());
        System.out.println(combinedArmy.statusReport());
        System.out.println(smallArmy.statusReport());

        Soldier archer = new Archer("Legolas", 31);
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
        archer.promote();
        System.out.println(archer);
    }

    public static Army fight(Army attacking, Army defending) {
        if (attacking.getTotalAmountOfSoldiers() >= 2 * defending.getTotalAmountOfSoldiers()) {
            return attacking;
        }
        if (defending.getTotalAmountOfSoldiers() >= 2 * attacking.getTotalAmountOfSoldiers()) {
            return defending;
        }
        if (attacking.getTotalAttackingPower() >= 1.2 * defending.getTotalDefendingPower()) {
            return attacking;
        }
        return defending;
    }
}
