package advanced.selfeval.codelab01.soldiers;

import advanced.selfeval.codelab01.weapons.Pike;

public class Pikeman extends Soldier {

    public Pikeman(String name, int age) {
        super(name, age, new Pike("Pike"), Armor.MEDIUM_ARMOR);
    }
}
