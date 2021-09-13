package invoices;

import java.util.Arrays;

public class Invoice {
    private String title;
    private Product[] products;
    private int nrOfProducts;

    public Invoice(String title) {
        this.title = title;
    }

    public Product[] getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        Product[] temp = products;
        products = new Product[++nrOfProducts];
        for (int i = 0; i < temp.length; i++) {
            products[i] = temp[i];
        }
        products[nrOfProducts] = product;
    }

    public void addProducts(Product[] products) {
        Product[] temp = products;
        nrOfProducts += products.length;
        this.products = new Product[nrOfProducts];
        for (int i = 0; i < temp.length; i++) {
            this.products[i] = temp[i];
        }
        for (int i = temp.length; i < nrOfProducts; i++) {
            this.products[i] = products[i - temp.length];
        }
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product p: products) {
            total += p.getPrice() * p.getAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(title).append('\n');
        sb.append("products:\n");
        sb.append("Name\t\tPrice\t\tAmount\t\tSubTotal\n");
        sb.append(Arrays.toString(products)).append('\n');
        sb.append("total = ").append(getTotalPrice());
        return sb.toString();
    }
}
