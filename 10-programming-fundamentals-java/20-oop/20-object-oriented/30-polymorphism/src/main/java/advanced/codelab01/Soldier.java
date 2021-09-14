package advanced.codelab01;

public class Soldier {
    private String name;
    private int age;
    private Weapon weapon;
    private Armor armor;

    public Soldier(String name, int age) {
        this.name = name;
        this.age = age;
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
}
