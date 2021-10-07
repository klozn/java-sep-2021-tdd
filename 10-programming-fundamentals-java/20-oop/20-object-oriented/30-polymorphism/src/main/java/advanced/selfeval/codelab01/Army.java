package advanced.selfeval.codelab01;

import advanced.selfeval.codelab01.soldiers.*;
import advanced.selfeval.codelab01.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Army {
    private final String name;
    private final List<Soldier> soldiers;

    public Army(String name, List<Soldier> soldiers) {
        this.name = name;
        this.soldiers = soldiers;
    }

    public String getName() {
        return name;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public int getTotalAttackingPower() {
        return soldiers.stream()
                .map(Soldier::getWeapon)
                .map(Weapon::getAttackingPowerValue)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getTotalDefendingPower() {
        return soldiers.stream()
                .map(Soldier::getArmor)
                .map(Armor::getDefendingPower)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getTotalAmountOfSoldiers() {
        return soldiers.size();
    }

    public static Army mergeArmies(Army firstArmy, Army secondArmy, String mergedArmyName) {
        List<Soldier> soldiers = new ArrayList<>(firstArmy.soldiers);
        soldiers.addAll(secondArmy.soldiers);
        return new Army(mergedArmyName, soldiers);
    }

    public String statusReport() {
        StringBuilder sb = new StringBuilder("Status Report for " + name + "\n\n");
        sb.append("Different types of soldiers in this army:\n");
        Map<String, List<Soldier>> soldiersPerType = soldiers.stream()
                .collect(Collectors.groupingBy(s -> s.getClass().getSimpleName(), Collectors.toList()));
        soldiersPerType.keySet()
                .forEach(key -> sb.append(key)
                        .append(": amount = ")
                        .append(soldiersPerType.get(key).size())
                        .append("\n"));
        soldiersPerType.keySet()
                .forEach(key -> sb.append(key)
                        .append(" combined Attacking Power: ")
                        .append(soldiersPerType.get(key).stream()
                                .map(Soldier::getWeapon)
                                .map(Weapon::getAttackingPowerValue)
                                .reduce(Integer::sum).orElse(0))
                        .append("\n")
                        .append(key).append(" combined Defending Power: ")
                        .append(soldiersPerType.get(key).stream()
                                .map(Soldier::getArmor)
                                .map(Armor::getDefendingPower)
                                .reduce(Integer::sum).orElse(0))
                        .append("\n"));

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
