package basic.codelab02;

import java.util.List;

public class FruitTree<T extends Fruit> {
    private List<T> fruits;
    private int age;

    public FruitTree(int age) {
        this.age = age;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getAllFruits() {
        return fruits;
    }
}
