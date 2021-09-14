package advanced.codelab01;

public enum Armor {
    STRONG_ARMOR(3, "Strong Armor"),
    MEDIUM_ARMOR(2, "Medium Armor"),
    LOW_ARMOR(1, "Low Armor"),
    NO_ARMOR(0, "No Armor");

    private final int defendingPower;
    private final String name;

    Armor(int defendingPower, String name) {
        this.defendingPower = defendingPower;
        this.name = name;
    }

    public int getDefendingPower() {
        return defendingPower;
    }

    public String getName() {
        return name;
    }
}
