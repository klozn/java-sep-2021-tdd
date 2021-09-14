package advanced.codelab01.weapons;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name);
        setAttackingPower(3);
        setTwoHanded(false);
    }
}
