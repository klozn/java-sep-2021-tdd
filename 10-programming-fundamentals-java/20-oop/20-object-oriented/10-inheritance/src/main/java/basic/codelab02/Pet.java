package basic.codelab02;

public class Pet {
    private String name;
    private double priceInEUR;
    private boolean healthy;

    public Pet(String name, double priceInEUR, boolean healthy) {
        this.name = name;
        this.priceInEUR = priceInEUR;
        this.healthy = healthy;
    }

    public String getName() {
        return name;
    }

    public double getPriceInEUR() {
        return priceInEUR;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public boolean buy(double offeredMoney) {
        if (!isHealthy()) {
            return false;
        }
        return !(offeredMoney < priceInEUR);
    }
}
