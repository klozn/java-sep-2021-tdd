package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.Soldier;
import advanced.codelab01.weapons.Sword;

public class Swordsman extends Soldier {

    public Swordsman(String name, int age) {
        super(name, age);
        setWeapon(new Sword("Swerd"));
        setArmor(Armor.MEDIUM_ARMOR);
    }
}
