package solutions.codelab11.staff;

import solutions.codelab11.house.Garden;

public class Gardener {

    private final String name;

    public Gardener(String name) {
        this.name = name;
    }

    void tendTo(Garden garden) {
        System.out.println("Gardener " + name + " will tend to the garden");
        garden.removeWeeds();
        garden.trimHedge();
        garden.mowGrass();
    }
}
