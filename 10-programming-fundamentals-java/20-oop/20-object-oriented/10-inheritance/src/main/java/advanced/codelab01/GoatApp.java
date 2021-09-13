package advanced.codelab01;

public class GoatApp {
    public static void main(String[] args) {
        Goat goat = new Goat(20, Health.GOATERRIBLE);
        MountainGoat mountainGoat = new MountainGoat(8, Health.GOATASTIC);
        Goat ok = new Goat(10, Health.GOATKAY);
        Goat mGoat = new MountainGoat(9, Health.GOATERRIBLE);

        System.out.println(goat.getAge());

        mountainGoat.climb();
        System.out.println(mountainGoat.getAge());
        System.out.println(mGoat.getAge());

        System.out.println(ok.getAge());

    }
}
