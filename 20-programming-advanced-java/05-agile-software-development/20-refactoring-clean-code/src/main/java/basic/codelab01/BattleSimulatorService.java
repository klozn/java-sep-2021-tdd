package basic.codelab01;

/**
 * Read the README.md.
 * (the current code of this class is NOT OK)
 */
class BattleSimulatorService {

    boolean simBat(Army attackingArmy, Army defendingArmy) {
        int attackingStrength = attackingArmy.getAttackingStrength();
        int defendingStrength = defendingArmy.getDefendingStrength();
        return attackingStrength > defendingStrength * 2;
    }

}
