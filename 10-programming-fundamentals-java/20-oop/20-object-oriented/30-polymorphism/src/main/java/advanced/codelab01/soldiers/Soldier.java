package advanced.codelab01.soldiers;

import advanced.codelab01.Armor;
import advanced.codelab01.weapons.Weapon;

public class Soldier {
    private String name;
    private int age;
    private Weapon weapon;
    private Armor armor;
    private Rank rank;

    public Soldier(String name, int age) {
        this.name = name;
        this.age = age;
        rank = Rank.PRIVATE_FIRST_CLASS;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    protected void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    protected void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Rank getRank() {
        return rank;
    }

    private void setRank(Rank rank) {
        this.rank = rank;
    }

    public void promote() {
        int currentRankValue = getRank().getValue();
        if (currentRankValue < Rank.values().length - 1) {
            setRank(Rank.values()[currentRankValue + 1]);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Soldier{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", weapon=").append(weapon);
        sb.append(", armor=").append(armor);
        sb.append(", rank=").append(rank.getReadFriendlyLabel());
        sb.append('}');
        return sb.toString();
    }
}
