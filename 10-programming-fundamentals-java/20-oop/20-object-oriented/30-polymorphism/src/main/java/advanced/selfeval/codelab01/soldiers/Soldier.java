package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Weapon;

public abstract class Soldier {
    private final String name;
    private final int age;
    private final Weapon weapon;
    private final Armor armor;
    private Rank rank;

    protected Soldier(String name, int age, Weapon weapon, Armor armor) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
        this.armor = armor;
        rank = Rank.PRIVATE_FIRST_CLASS;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Rank getRank() {
        return rank;
    }

    private void setRank(Rank rank) {
        this.rank = rank;
    }

    public void promote() {
        setRank(rank.next());
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
