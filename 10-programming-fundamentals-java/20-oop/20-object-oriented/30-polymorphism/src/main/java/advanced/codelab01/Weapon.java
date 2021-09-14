package advanced.codelab01;

public class Weapon {
    private String name;
    private int attackingPower;
    private boolean twoHanded;

    public Weapon(String name) {
        this.name = name;
    }

    public int getAttackingPower() {
        return attackingPower;
    }

    protected void setAttackingPower(int attackingPower) {
        this.attackingPower = attackingPower;
    }

    public boolean isTwoHanded() {
        return twoHanded;
    }

    protected void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
    }
}
