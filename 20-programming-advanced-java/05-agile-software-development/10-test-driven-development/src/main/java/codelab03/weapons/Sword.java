package codelab03.weapons;

public class Sword extends Weapon {
    public final static double DAMAGE = 2;

    public Sword() {
        super(DAMAGE);
    }

    public Sword(double damage) {
        super(damage);
    }
}
