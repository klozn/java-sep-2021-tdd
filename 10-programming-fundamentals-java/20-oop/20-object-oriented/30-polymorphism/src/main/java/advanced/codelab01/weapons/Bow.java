package advanced.codelab01.weapons;

public class Bow extends Weapon {

    public Bow(String name) {
        super(name);
        setAttackingPower(2);
        setTwoHanded(true);
    }
}
