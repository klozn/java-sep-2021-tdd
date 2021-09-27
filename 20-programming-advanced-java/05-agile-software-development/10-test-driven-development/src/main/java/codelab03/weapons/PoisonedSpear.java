package codelab03.weapons;

public class PoisonedSpear extends Weapon {
    public final static double DAMAGE = 3 * Spear.DAMAGE;

    public PoisonedSpear() {
        super(DAMAGE);
    }
}
