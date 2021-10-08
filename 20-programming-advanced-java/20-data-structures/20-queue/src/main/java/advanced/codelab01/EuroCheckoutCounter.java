package advanced.codelab01;

import advanced.codelab01.domain.*;

import java.util.LinkedList;
import java.util.Queue;

public class EuroCheckoutCounter implements CheckoutCounter {

    private Cashier cashier;
    private boolean open;
    private final Queue<Customer> checkoutLine = new LinkedList<>();

    private void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public boolean isOpen() {
        return open;
    }

    private void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public void open(Cashier cashier) {
        setOpen(true);
        setCashier(cashier);
    }

    @Override
    public void close() {
        if (!checkoutLine.isEmpty()) {
            throw new IllegalStateException("The checkout line is not empty.");
        }
        setOpen(false);
        setCashier(null);
    }

    @Override
    public void joinCheckoutLine(Customer customer) {
        if (!isOpen()) {
            throw new IllegalStateException("The checkout counter is closed.");
        }
        checkoutLine.offer(customer);
    }

    @Override
    public Price processNextCustomerInLine() {
        if (!isOpen()) {
            throw new IllegalStateException("The checkout counter is closed.");
        }
        if (checkoutLine.isEmpty()) {
            throw new IllegalStateException("The checkout line is empty.");
        }
        Customer nextCustomer = checkoutLine.poll();
        double totalAllGroceries = 0;

        for (Grocery grocery: nextCustomer.getGroceries()) {
            totalAllGroceries += grocery.getPrice().getDecimal() * grocery.getAmount();
        }

        return new Price(totalAllGroceries, Currency.EURO);
    }
}
