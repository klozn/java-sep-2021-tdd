package advanced.codelab01;

public class Army {
    private String name;
    private Soldier[] soldiers;

    public Army(String name, Soldier[] soldiers) {
        this.name = name;
        this.soldiers = soldiers;
    }

    public String getName() {
        return name;
    }

    public Soldier[] getSoldiers() {
        return soldiers;
    }

    public int getTotalAttackingPower() {
        int result = 0;
        for (Soldier soldier: soldiers) {
            result += soldier.getWeapon().getAttackingPower();
        }
        return result;
    }

    public int getTotalDefendingPower() {
        int result = 0;
        for (Soldier soldier: soldiers) {
            result += soldier.getArmor().getDefendingPower();
        }
        return result;
    }

    public int getTotalAmountOfSoldiers() {
        return soldiers.length;
    }

    public Army mergeArmies(Army toMerge) {
        int numberOfSoldiers = this.getTotalAmountOfSoldiers() + toMerge.getTotalAmountOfSoldiers();
        Soldier[] mergedSoldiers = new Soldier[numberOfSoldiers];
        for (int i = 0; i < this.getTotalAmountOfSoldiers(); i++) {
            mergedSoldiers[i] = getSoldiers()[i];
        }
        for (int i = this.getTotalAmountOfSoldiers(); i < numberOfSoldiers; i++) {
            mergedSoldiers[i] = toMerge.getSoldiers()[i - this.getTotalAmountOfSoldiers()];
        }
        return new Army(this.getName(), mergedSoldiers);
    }


}
