package advanced.codelab01.weapons;

import advanced.codelab01.Weapon;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name);
        setAttackingPower(3);
        setTwoHanded(false);
    }
}
