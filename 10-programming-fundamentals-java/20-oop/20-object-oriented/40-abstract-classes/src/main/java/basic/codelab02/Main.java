package basic.codelab02;

import basic.codelab02.weapons.BallisticWeapon;
import basic.codelab02.weapons.EnergyWeapon;
import basic.codelab02.weapons.MeleeWeapon;
import basic.codelab02.weapons.Weapon;

public class Main {
    public static void main(String[] args) {
        Enemy enemy = new Enemy();

        Weapon[] weapons = new Weapon[] {
                new BallisticWeapon(),
                new EnergyWeapon(),
                new MeleeWeapon()
        };

        while (enemy.isAlive()) {
            for (Weapon weapon: weapons) {
                weapon.dealDamageTo(enemy);
            }
            System.out.println(enemy);
        }
        System.out.println(enemy);
    }
}
