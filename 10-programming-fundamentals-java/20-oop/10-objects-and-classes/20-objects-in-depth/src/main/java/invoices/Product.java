package invoices;

public class Product {
    private String name;
    private double price;
    private int amount;
    private double subtotal;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public double getSubtotal() {
        return getPrice() * getAmount();
    }

    @Override
    public String toString() {
        return String.format("\n%s\t\t%.2f\t\t%d\t\t%.2f", name, price, amount, getSubtotal());
    }
}
