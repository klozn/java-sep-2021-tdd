package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.weapons.Dagger;

public class Slave extends Soldier {

    public Slave(String name, int age) {
        super(name, age);
        setWeapon(new Dagger("Shiv"));
        setArmor(Armor.NO_ARMOR);
    }
}
