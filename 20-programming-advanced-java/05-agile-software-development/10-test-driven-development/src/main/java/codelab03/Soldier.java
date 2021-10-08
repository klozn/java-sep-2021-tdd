package codelab03;

import codelab03.weapons.*;

public class Soldier {
    private Weapon weapon;

    public Soldier() {
        this(new BareFists());
    }

    public Soldier(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getWeaponDamage() {
        return weapon.getDamage();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Soldier fight(Soldier opponent) {
        double totalDamage = getWeaponDamage() + getBonusWeaponDamage(opponent);
        double opponentTotalDamage = opponent.getWeaponDamage() + opponent.getBonusWeaponDamage(this);
        if (opponentTotalDamage > totalDamage) {
            return opponent;
        }
        return this;
    }

    public double getBonusWeaponDamage(Soldier opponent) {
        if (weapon instanceof BareFists) {
            return 0;
        }
        if (opponent.weapon instanceof BareFists) {
            return 2.5;
        }
        if (weapon instanceof Axe && opponent.weapon instanceof Spear) {
            return 2;
        }
        if (weapon instanceof Spear && opponent.weapon instanceof Sword) {
            return 1;
        }
        if (weapon instanceof Sword && opponent.weapon instanceof Axe) {
            return 1.5;
        }
        return 0;
    }
}
