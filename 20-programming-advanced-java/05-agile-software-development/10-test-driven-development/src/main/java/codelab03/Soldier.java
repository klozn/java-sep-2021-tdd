package codelab03;

import codelab03.weapons.BareFists;
import codelab03.weapons.Weapon;

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
        if (soldier.getWeaponDamage() > getWeaponDamage()) {
            return soldier;
        }
        return this;
    }
}
