package advanced.codelab01;

import advanced.codelab01.domain.Cashier;
import advanced.codelab01.domain.Customer;
import advanced.codelab01.domain.Price;

public interface CheckoutCounter {
    void open(Cashier cashier);
    void close();
    void joinCheckoutLine(Customer customer);
    Price processNextCustomerInLine();
}
