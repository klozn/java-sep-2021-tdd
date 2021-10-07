package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Bow;

public class Archer extends Soldier {

    public Archer(String name, int age) {
        super(name, age, new Bow("Bow"), Armor.LOW_ARMOR);
    }
}
