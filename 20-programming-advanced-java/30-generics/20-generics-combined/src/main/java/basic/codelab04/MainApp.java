package basic.codelab04;

public class MainApp {
    public static void main(String[] args) {
        var fish = new Fish();
        var camel = new Camel();
        var desert = new Desert();
        var ocean = new Ocean();
        desert.addInhabitant(camel);
        ocean.addInhabitant(fish);
        ocean.addInhabitant(new Fish());

        System.out.println(ocean.getInhabitants());
        System.out.println(desert.getInhabitants());
    }
}
