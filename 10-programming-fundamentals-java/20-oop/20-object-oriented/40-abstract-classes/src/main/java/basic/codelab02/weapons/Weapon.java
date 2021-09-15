package basic.codelab02.weapons;

import basic.codelab02.Enemy;

public abstract class Weapon {
    private final int amountOfDamage;

    public Weapon(int amountOfDamage) {
        this.amountOfDamage = amountOfDamage;
    }

    public int getAmountOfDamage() {
        return amountOfDamage;
    }

    public abstract void dealDamageTo(Enemy enemy);
}
