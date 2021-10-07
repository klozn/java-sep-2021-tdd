package advanced.selfeval.codelab01.weapons;

public abstract class Weapon {
    private String name;
    private final AttackingPower attackingPower;
    private final boolean twoHanded;

    protected Weapon(String name, AttackingPower attackingPower, boolean twoHanded) {
        this.name = name;
        this.attackingPower = attackingPower;
        this.twoHanded = twoHanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackingPowerValue() {
        return attackingPower.getAttackingPowerValue();
    }

    public boolean isTwoHanded() {
        return twoHanded;
    }
}
