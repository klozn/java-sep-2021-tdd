package basic.codelab03;

public class MonsterMayhem {
    public static void main(String[] args) {
        Monster giant = new GiantMonster("Godzilla");
        Monster kind = new KindMonster("JigglyPuff");
        Monster scary = new ScaryMonster("Alien", 5);

        scary.fight(giant);
        kind.fight(giant);
        giant.fight(scary);

        System.out.printf("giant alive: %s\nkind alive: %s\nscary alive: %s\n",
                giant.isAlive(), kind.isAlive(), scary.isAlive());

        scary.fight(giant);
        kind.fight(scary);
        scary.fight(giant);

        System.out.printf("giant alive: %s\nkind alive: %s\nscary alive: %s\n",
                giant.isAlive(), kind.isAlive(), scary.isAlive());

        giant.fight(kind);
        kind.fight(giant);
        scary.fight(giant);

        System.out.printf("giant alive: %s\nkind alive: %s\nscary alive: %s\n",
                giant.isAlive(), kind.isAlive(), scary.isAlive());
    }
}
