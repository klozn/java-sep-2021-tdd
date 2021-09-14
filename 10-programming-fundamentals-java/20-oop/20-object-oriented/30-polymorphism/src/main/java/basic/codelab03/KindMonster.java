package basic.codelab03;

public class KindMonster extends Monster {
    public KindMonster(String name) {
        super(name);
        setAttackPower(1);
    }

    @Override
    public void fight(Monster opponent) {
        if (this.isAlive()) {
            opponent.setHealth(opponent.getHealth() + this.getAttackPower());
        }
    }
}
