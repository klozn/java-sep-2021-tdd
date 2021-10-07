package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Axe;

public class AxeThrower extends Soldier {

    public AxeThrower(String name, int age) {
        super(name, age, new Axe("Axe"), Armor.STRONG_ARMOR);
    }
}
