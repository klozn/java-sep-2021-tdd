package basic.codelab01;

/**
 * Read the README.md.
 * (the current code of this class is NOT OK)
 */
class BattleSimulatorService {

    boolean simBat(Army a1, Army a2) {
        int a1Strength = 0;
        int a2Strength = 0;

        for (Soldier s : a1.getSoldiers()) {
            a1Strength += s.getAttackingStrength();
        }

        for (Soldier s : a2.getSoldiers()) {
            a2Strength += s.getDefendingStrength();
        }

        if(a1Strength > a2Strength * 2) {
            return true;
        } else {
            return false;
        }
    }

}
