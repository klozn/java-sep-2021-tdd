package advanced.codelab01.weapons;

import advanced.codelab01.Weapon;

public class Axe extends Weapon {

    public Axe(String name) {
        super(name);
        setAttackingPower(2);
        setTwoHanded(false);
    }
}
