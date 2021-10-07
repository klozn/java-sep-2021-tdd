package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Dagger;

public class Slave extends Soldier {

    public Slave(String name, int age) {
        super(name, age, new Dagger("Dagger"), Armor.NO_ARMOR);
    }
}
