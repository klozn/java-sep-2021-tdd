package codelab03;

import codelab03.weapons.*;
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
        void fight_whenSpearVsAxe_returnsSoldierWithAxe() {
            //given
            attacker.setWeapon(new Spear());
            defender.setWeapon(new Axe());
            //when
            Soldier winner = attacker.fight(defender);
            //then
            assertEquals(defender, winner);
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

        @Test
        @DisplayName("bonusWeaponDamage axe vs spear returns 2")
        void getBonusWeaponDamage_whenAxeVsSpear_Returns2() {
            //given
            attacker.setWeapon(new Axe());
            defender.setWeapon(new Spear());
            //when
            double bonus = attacker.getBonusWeaponDamage(defender);
            //then
            assertEquals(2, bonus);
        }

        @Test
        @DisplayName("bonusWeaponDamage spear vs sword returns 1")
        void getBonusWeaponDamage_whenSpearVsSword_Returns1() {
            //given
            attacker.setWeapon(new Spear());
            defender.setWeapon(new Sword());
            //when
            double bonus = attacker.getBonusWeaponDamage(defender);
            //then
            assertEquals(1, bonus);
        }

        @Test
        @DisplayName("flamingSword has 1.5 bonus damage vs obsidianAxe")
        void getBonusWeaponDamage_whenFlamingSwordVsObsidianAxe_thenReturns1Point5() {
            //given
            attacker.setWeapon(new FlamingSword());
            defender.setWeapon(new ObsidianAxe());
            //when
            double bonus = attacker.getBonusWeaponDamage(defender);
            //then
            assertEquals(1.5, bonus);
        }
    }
}