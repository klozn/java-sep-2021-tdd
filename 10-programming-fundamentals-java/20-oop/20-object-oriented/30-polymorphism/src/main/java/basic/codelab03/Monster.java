package basic.codelab03;

public class Monster {
    private String name;
    private int attackPower;
    private int health;

    public Monster(String name) {
        this.name = name;
        health = 10;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 11 && health >= 0) {
            this.health = health;
        }
    }

    public boolean isAlive() {
        return getHealth() != 0;
    }

    public void fight(Monster opponent) {
        if (this.isAlive()) {
            if (opponent.getHealth() < this.getAttackPower()) {
                opponent.setHealth(0);
            } else {
                opponent.setHealth(opponent.getHealth() - this.getAttackPower());
            }
        }
    }
}
