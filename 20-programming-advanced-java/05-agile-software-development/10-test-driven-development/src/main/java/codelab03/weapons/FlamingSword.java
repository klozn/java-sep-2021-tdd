package codelab03.weapons;

public class FlamingSword extends Sword {
    public final static double DAMAGE = 2 * Sword.DAMAGE;

    public FlamingSword() {
        super(DAMAGE);
    }
}
