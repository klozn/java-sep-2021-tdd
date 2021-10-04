package basic.codelab04;

public class MainApp {
    public static void main(String[] args) {
        Fish fish = new Fish();
        Camel camel = new Camel();
        Desert desert = new Desert();
        Ocean ocean = new Ocean();
        desert.addInhabitant(camel);
        ocean.addInhabitant(fish);
        ocean.addInhabitant(new Fish());

        System.out.println(ocean.getInhabitants());
        System.out.println(desert.getInhabitants());
    }
}
