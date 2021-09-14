package advanced.codelab01;

public class BattleSimulatorService {
    public static void main(String[] args) {



    }

    public static Army fight(Army attacking, Army defending) {
        if (attacking.getTotalAmountOfSoldiers() >= 2 * defending.getTotalAmountOfSoldiers()) {
            return attacking;
        }
        if (defending.getTotalAmountOfSoldiers() >= 2 * attacking.getTotalAmountOfSoldiers()) {
            return defending;
        }
        if (attacking.getTotalAttackingPower() >= 1.2 * defending.getTotalDefendingPower()) {
            return attacking;
        }
        return defending;
    }
}
