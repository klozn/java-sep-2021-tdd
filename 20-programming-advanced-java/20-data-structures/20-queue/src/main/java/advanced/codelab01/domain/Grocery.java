package advanced.codelab01.domain;

public class Grocery {
    private final String name;
    private Price price;
    private int amount;

    public Grocery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
