package advanced.selfeval.codelab01.weapons;

public enum AttackingPower {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    VERY_HIGH(4);

    private final int attackingPowerValue;

    AttackingPower(int attackingPowerValue) {
        this.attackingPowerValue = attackingPowerValue;
    }

    public int getAttackingPowerValue() {
        return attackingPowerValue;
    }
}
