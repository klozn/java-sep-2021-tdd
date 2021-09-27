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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Soldier fight(Soldier soldier) {
        double totalDamage = getWeaponDamage() + getBonusWeaponDamage(soldier);
        double opponentTotalDamage = soldier.getWeaponDamage() + soldier.getBonusWeaponDamage(this);
        if (totalDamage > opponentTotalDamage) {
            return soldier;
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
