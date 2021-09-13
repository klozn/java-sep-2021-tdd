package basic.codelab02;

public class PetMarket {

    public static void main(String[] args) {
        Cat marcel = new Cat("Marcel", 75.0, true, false);
        Cat theofiel = new Cat("Theofiel", 20, true, true);
        Cat norbert = new Cat("Norbert", 50, false, false);
        Dog cezar = new Dog("Cezar", 100, true);
        Dog tony = new Dog("Tony", 254, true);
        Dog kamiel = new Dog("Kamiel", 4.99, false);

        System.out.println(kamiel.buy(4.99));
        System.out.println(tony.buy(253));
        System.out.println(cezar.buy(102));
        System.out.println(norbert.buy(500));
        System.out.println(theofiel.buy(25));
        System.out.println(marcel.buy(75));
    }
}
