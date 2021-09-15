package basic.codelab02.weapons;

import basic.codelab02.Enemy;

public class BallisticWeapon extends Weapon {
    public BallisticWeapon() {
        super(10);
    }

    @Override
    public void dealDamageTo(Enemy enemy) {
        enemy.hurt(getAmountOfDamage());
    }
}
