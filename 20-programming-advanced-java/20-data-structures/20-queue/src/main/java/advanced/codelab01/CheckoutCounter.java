package advanced.codelab01;

public interface CheckoutCounter {
    void open(Cashier cashier);
    void close();
    void joinCheckoutLine(Customer customer);
    Price processNextCustomerInLine();
}
