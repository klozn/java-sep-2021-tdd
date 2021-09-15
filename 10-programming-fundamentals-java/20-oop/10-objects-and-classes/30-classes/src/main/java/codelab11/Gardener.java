package codelab11;

public class Gardener {

    public String name;

    public Gardener(String name) {
        this.name = name;
    }

    public void tendTo(Garden garden) {
        System.out.println("Gardener " + name + " will tend to the garden");
        garden.removeWeeds();
        garden.trimHedge();
        garden.mowGrass();
    }
}
