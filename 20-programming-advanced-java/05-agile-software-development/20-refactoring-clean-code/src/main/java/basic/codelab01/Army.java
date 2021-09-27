package basic.codelab01;

/**
 * Read the README.md.
 * (the current code of this class is OK)
 */
class Army {

    private final Soldier[] soldiers;

    Army(Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    Soldier[] getSoldiers() {
        return soldiers;
    }

    int getAttackingStrength() {
        int attackingStrength = 0;
        for (Soldier s : soldiers) {
            attackingStrength += s.getAttackingStrength();
        }
        return attackingStrength;
    }

    int getDefendingStrength() {
        int defendingStrength = 0;
        for (Soldier s : soldiers) {
            defendingStrength += s.getDefendingStrength();
        }
        return defendingStrength;
    }
}
