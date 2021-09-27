package codelab03;

import codelab03.weapons.Axe;
import codelab03.weapons.Spear;
import codelab03.weapons.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    private Army army;

    @BeforeEach
    void init() {
        army = new Army();
    }

    @Test
    @DisplayName("Enlist adds soldier to army")
    void enlist_Soldier_thenSoldierAddedToArmy() {
        //given
        Soldier soldier = new Soldier();
        //when
        army.enlist(soldier);
        //then
        assertEquals(soldier, army.getSoldiers().get(0));
    }

    @Test
    @DisplayName("First enlisted is front-man of the army")
    void enlist_whenFirstEnlisted_thenSoldierIsFrontMan() {
        //given
        Soldier soldier = new Soldier();
        //when
        army.enlist(soldier);
        //then
        assertEquals(soldier, army.getFrontMan());
    }

    @Nested
    @DisplayName("Method battle:")
    class Battling {
        private Army attacking;
        private Army defending;

        @BeforeEach
        void init() {
            attacking = new Army();
            defending = new Army();
        }

        @Test
        @DisplayName("losing army has no more soldiers")
        void battle_whenDone_thenLosingArmyHasZeroSoldiers() {
            //given
            attacking.enlist(new Soldier(new Sword()));
            attacking.enlist(new Soldier(new Sword()));
            defending.enlist(new Soldier(new Axe()));
            //when
            attacking.battle(defending);
            //then
            assertEquals(0, attacking.getNumberOfSoldiers());
            assertEquals(1, defending.getNumberOfSoldiers());
        }

        @Test
        @DisplayName("equal armies both lose soldiers")
        void battle_whenArmiesEqual_thenBothLoseSoldiers() {
            //given
            attacking.enlist(new Soldier(new Sword()));
            attacking.enlist(new Soldier(new Sword()));
            attacking.enlist(new Soldier(new Sword()));
            defending.enlist(new Soldier(new Sword()));
            defending.enlist(new Soldier(new Sword()));
            defending.enlist(new Soldier(new Sword()));
            //when
            attacking.battle(defending);
            //then
            assertEquals(1, attacking.getNumberOfSoldiers());
            assertEquals(0, defending.getNumberOfSoldiers());
        }

        @Test
        @DisplayName("attacking army wins when armies are identical")
        void battle_whenArmiesEqual_attackingArmyWins() {
            //given
            attacking.enlist(new Soldier(new Sword()));
            attacking.enlist(new Soldier(new Axe()));
            attacking.enlist(new Soldier(new Spear()));
            defending.enlist(new Soldier(new Sword()));
            defending.enlist(new Soldier(new Axe()));
            defending.enlist(new Soldier(new Spear()));
            //when
            Army winner = attacking.battle(defending);
            //then
            assertEquals(attacking, winner);
        }

        @Test
        @DisplayName("defending army without soldiers, attacking wins")
        void battle_whenDefendingArmyHasNoSoldiers_thenAttackingWins() {
            //given
            attacking.enlist(new Soldier());
            //when
            Army winner = attacking.battle(defending);
            //then
            assertEquals(attacking, winner);
        }

        @Test
        @DisplayName("attacking army without soldiers, defending wins")
        void battle_whenAttackingArmyHasNoSoldiers_thenDefendingWins() {
            //given
            defending.enlist(new Soldier());
            //when
            Army winner = attacking.battle(defending);
            //then
            assertEquals(defending, winner);
        }
    }
}