package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.weapons.Axe;

public class Axethrower extends Soldier {

    public Axethrower(String name, int age) {
        super(name, age);
        setWeapon(new Axe("Axle"));
        setArmor(Armor.STRONG_ARMOR);
    }
}
