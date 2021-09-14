package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.Soldier;
import advanced.codelab01.weapons.Bow;

public class Archer extends Soldier {

    public Archer(String name, int age) {
        super(name, age);
        setWeapon(new Bow("DavidBowie"));
        setArmor(Armor.LOW_ARMOR);
    }
}
