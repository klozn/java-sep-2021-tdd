package advanced.codelab01;

import advanced.codelab01.soldiers.*;

import java.util.Arrays;

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

    public String statusReport() {
        Soldier[] archers = Arrays.stream(getSoldiers())
                .filter(s -> s instanceof Archer)
                .toArray(Soldier[]::new);
        Soldier[] axethrowers = Arrays.stream(getSoldiers())
                .filter(s -> s instanceof Axethrower)
                .toArray(Soldier[]::new);
        Soldier[] pikemen = Arrays.stream(getSoldiers())
                .filter(s -> s instanceof Pikeman)
                .toArray(Soldier[]::new);
        Soldier[] slaves = Arrays.stream(getSoldiers())
                .filter(s -> s instanceof Slave)
                .toArray(Soldier[]::new);
        Soldier[] swordsmen = Arrays.stream(getSoldiers())
                .filter(s -> s instanceof Swordsman)
                .toArray(Soldier[]::new);

        Soldier[][] soldiersByType = new Soldier[][] {archers, axethrowers, pikemen, slaves, swordsmen};

        StringBuilder sb = new StringBuilder();
        sb.append("Types of soldiers:\n");
        for (int i = 0; i < 5; i++) {
            if (soldiersByType[i].length > 0) {
                sb.append(soldiersByType[i][0].getClass().getSimpleName()).append('\n');
            }
        }
        sb.append("***************************************************\n");
        sb.append("Amount of soldiers per type:\n");
        for (int i = 0; i < 5; i++) {
            if (soldiersByType[i].length > 0) {
                sb.append(soldiersByType[i][0].getClass().getSimpleName());
                sb.append(": ").append(soldiersByType[i].length).append('\n');
            }
        }
        sb.append("***************************************************\n");
        for (int i = 0; i < 5; i++) {
            if (soldiersByType[i].length > 0) {
                int combinedAttackingPower = 0;
                int combinedDefendingPower = 0;
                for (int j = 0; j < soldiersByType[i].length; j++) {
                    combinedAttackingPower += soldiersByType[i][j].getWeapon().getAttackingPower();
                    combinedDefendingPower += soldiersByType[i][j].getArmor().getDefendingPower();
                }
                sb.append(soldiersByType[i][0].getClass().getSimpleName()).append(":\n");
                sb.append("Combined attacking power: ");
                sb.append(combinedAttackingPower).append('\n');
                sb.append("Combined defending power: ");
                sb.append(combinedDefendingPower).append('\n');
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Army{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
