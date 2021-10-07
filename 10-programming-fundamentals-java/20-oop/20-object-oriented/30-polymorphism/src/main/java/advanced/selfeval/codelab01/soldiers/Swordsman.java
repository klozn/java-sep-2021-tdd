package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Sword;

public class Swordsman extends Soldier {

    public Swordsman(String name, int age) {
        super(name, age, new Sword("Sword"), Armor.MEDIUM_ARMOR);
    }
}
