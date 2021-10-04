package basic.codelab02;

public class MainApp {
    public static void main(String[] args) {
        FruitTree<Apple> appleTree = new FruitTree<>(3);
        appleTree.add(new Apple());
        appleTree.add(new Apple());
        appleTree.add(new Apple());
        FruitTree<Orange> orangeTree = new FruitTree<>(5);
        orangeTree.add(new Orange());
        orangeTree.add(new Orange());
        // FruitTree<String> wordTree = new FruitTree<String>();  -> not possible :)

    }
}
