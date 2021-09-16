package codelab02;

import codelab02.trees.*;

public class MainApp {
    public static void main(String[] args) {
        Forest forest = new Forest(
                new Tree[] {
                        new BulaYakaTree(5, new Height(5, HeightUnit.METER)),
                        new Fir(70, new Height(25, HeightUnit.METER)),
                        new AppleTree(16, new Height(7, HeightUnit.METER)),
                        new Oak(80, new Height(12, HeightUnit.METER)),
                        new OrangeTree(50, new Height(3, HeightUnit.METER)),
                        new WeepingWillow(99, new Height(20, HeightUnit.METER)),
                        new BulaYakaTree(5, new Height(5, HeightUnit.FOOT)),
                        new Fir(70, new Height(25, HeightUnit.FOOT)),
                        new AppleTree(16, new Height(7, HeightUnit.FOOT)),
                        new Oak(80, new Height(12, HeightUnit.FOOT)),
                        new OrangeTree(50, new Height(3, HeightUnit.FOOT)),
                        new WeepingWillow(99, new Height(20, HeightUnit.FOOT))
                }
        );

        System.out.println(Height.convertMetersToHeightInFoot(15));

        for (Tree tree : forest.getTrees()) {
            if (tree instanceof BulaYakaTree) {
                for (int i = 0; i < 5; i++) {
                    ((FruitTree) tree).addFruitItem(FruitItem.BULA);
                    ((BulaYakaTree) tree).addFruitItem(FruitItem.YAKA);
                }
            }
            if (tree instanceof AppleTree) {
                for (int i = 0; i < 7; i++) {
                    ((AppleTree) tree).addFruitItem(FruitItem.APPLE);
                }
            }
            if (tree instanceof OrangeTree) {
                for (int i = 0; i < 10; i++) {
                    ((OrangeTree) tree).addFruitItem(FruitItem.ORANGE);
                }
            }
        }

        forest.displayTrees();
        forest.forestFire();
        forest.displayTrees();


    }
}
