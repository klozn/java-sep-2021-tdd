package codelab03;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Soldier> soldiers = new ArrayList<>();
    private Soldier frontMan;

    public void enlist(Soldier soldier) {
        if (getNumberOfSoldiers() == 0) {
            frontMan = soldier;
        }
        soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public int getNumberOfSoldiers() {
        return soldiers.size();
    }

    public Soldier getFrontMan() {
        return frontMan;
    }

    private void killAndSwapFrontMan() {
        getSoldiers().remove(frontMan);
        if (getSoldiers().size() > 0) {
            frontMan = getSoldiers().get(0);
        } else {
            frontMan = null;
        }
    }

    public Army battle(Army armyToBattle) {
        if (armyToBattle.getNumberOfSoldiers() == 0) {
            return this;
        }
        if (getNumberOfSoldiers() == 0) {
            return armyToBattle;
        }
        Soldier winner = frontMan.fight(armyToBattle.frontMan);
        if (winner != frontMan) {
            killAndSwapFrontMan();
            return battle(armyToBattle);
        } else {
            armyToBattle.killAndSwapFrontMan();
            return armyToBattle.battle(this);
        }
    }
}
