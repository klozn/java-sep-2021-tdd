package basic.codelab02;

public class Enemy {
    private int health;
    private boolean stunned;

    public Enemy() {
        health = 100;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public boolean isStunned() {
        return stunned;
    }

    private void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void hurt(int amountOfDamage) {
        if (isStunned()) {
            setHealth(getHealth() - (int) (amountOfDamage * 1.5));
            setStunned(false);
        } else {
            setHealth(getHealth() - amountOfDamage);
        }
    }

    public void stun(int amountOfDamage) {
        setStunned(true);
        setHealth(getHealth() - amountOfDamage);
    }

    public void stab(int amountOfDamage) {
        if (isStunned()) {
            setHealth(getHealth() - (int) (amountOfDamage * 1.5));
            setStunned(false);
        } else {
            setHealth(getHealth() - amountOfDamage);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enemy{");
        sb.append("health=").append(health);
        sb.append(", stunned=").append(stunned);
        sb.append('}');
        return sb.toString();
    }
}
