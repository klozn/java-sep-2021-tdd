package basic.codelab02;

public class Cat extends Pet {
    private boolean aggressive;

    public Cat(String name, double priceInEUR, boolean healthy) {
        this(name, priceInEUR, healthy, false);
    }

    public Cat(String name, double priceInEUR, boolean healthy, boolean aggressive) {
        super(name, priceInEUR, healthy);
        this.aggressive = aggressive;
    }

    @Override
    public boolean buy(double offeredMoney) {
        if (aggressive) {
            return false;
        }
        return super.buy(offeredMoney);
    }
}
