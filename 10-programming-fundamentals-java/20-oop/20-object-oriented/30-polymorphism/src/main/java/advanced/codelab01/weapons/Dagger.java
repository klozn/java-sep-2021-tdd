package advanced.codelab01.weapons;

public class Dagger extends Weapon {

    public Dagger(String name) {
        super(name);
        setAttackingPower(1);
        setTwoHanded(false);
    }
}
