package advanced.codelab01.weapons;

import advanced.codelab01.Weapon;

public class Pike extends Weapon {

    public Pike(String name) {
        super(name);
        setAttackingPower(4);
        setTwoHanded(true);
    }
}
