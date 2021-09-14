package advanced.codelab01.weapons;

import advanced.codelab01.Weapon;

public class Bow extends Weapon {

    public Bow(String name) {
        super(name);
        setAttackingPower(2);
        setTwoHanded(true);
    }
}
