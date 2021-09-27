package codelab03;

import codelab03.weapons.Axe;
import codelab03.weapons.Spear;
import codelab03.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {

    @Test
    @DisplayName("Default soldier has bare fists equipped.")
    void defaultSoldierHasBareFists() {
        //given
        Soldier soldier = new Soldier();
        //when
        double weaponDamage = soldier.getWeaponDamage();
        //then
        assertEquals(1, weaponDamage);
    }

    @Nested
    @DisplayName("Method fight:")
    class Fighting {
        private Soldier attacker;
        private Soldier defender;

        @BeforeEach
        void init() {
            attacker = new Soldier();
            defender = new Soldier();
        }

        @Test
        @DisplayName("returns soldier with highest weapon damage")
        void fight_whenSwordVsSpear_returnsSoldierWithSpear() {
            //given
            attacker.setWeapon(new Sword());
            defender.setWeapon(new Spear());
            //when
            Soldier winner = attacker.fight(defender);
            //then
            assertEquals(defender, winner);
        }

        @Test
        @DisplayName("returns soldier with axe when vs spear")
        void fight_whenSpearVsAxe_returnsSoldierWithSpear() {
            //given
            attacker.setWeapon(new Spear());
            defender.setWeapon(new Axe());
            //when
            Soldier winner = attacker.fight(defender);
            //then
            assertEquals(attacker, winner);
        }

        @Test
        @DisplayName("returns attacker when weapon damage is equal")
        void fight_whenSwordVsSword_returnsAttacker() {
            //given
            attacker.setWeapon(new Sword());
            defender.setWeapon(new Sword());
            //when
            Soldier winner = attacker.fight(defender);
            //then
            assertEquals(attacker, winner);
        }
    }
}