package codelab03.weapons;

public abstract class Weapon {
    private final double damage;

    public Weapon(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }
}
