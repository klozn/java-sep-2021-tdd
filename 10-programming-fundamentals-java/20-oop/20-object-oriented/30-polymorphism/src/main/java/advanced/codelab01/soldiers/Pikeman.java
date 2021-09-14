package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.weapons.Pike;

public class Pikeman extends Soldier {

    public Pikeman(String name, int age) {
        super(name, age);
        setWeapon(new Pike("Prick"));
        setArmor(Armor.MEDIUM_ARMOR);
    }
}
