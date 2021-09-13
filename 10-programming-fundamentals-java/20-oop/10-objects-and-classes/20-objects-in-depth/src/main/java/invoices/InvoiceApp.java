package invoices;

public class InvoiceApp {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("Invoice for Food");

        Product[] products = new Product[] {
                new Product("apple", 1.5, 4),
                new Product("shampoo", 5.3, 2),
                new Product("cat food", 0.55, 8),
                new Product("skittles", 4.25, 1)
        };

        invoice.addProducts(products);
        System.out.println(invoice);
    }
}
