package codelab03.weapons;

public class ObsidianAxe extends Weapon {
    public final static double DAMAGE = 2 + Axe.DAMAGE;

    public ObsidianAxe() {
        super(DAMAGE);
    }
}
