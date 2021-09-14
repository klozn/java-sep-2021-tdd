package advanced.codelab01.weapons;

import advanced.codelab01.Weapon;

public class Dagger extends Weapon {

    public Dagger(String name) {
        super(name);
        setAttackingPower(1);
        setTwoHanded(false);
    }
}
