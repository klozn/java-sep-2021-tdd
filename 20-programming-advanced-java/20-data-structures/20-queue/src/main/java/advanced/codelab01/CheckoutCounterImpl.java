package advanced.codelab01;

import advanced.codelab01.exceptions.CheckoutCounterClosedException;
import advanced.codelab01.exceptions.CheckoutLineNotEmptyException;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounterImpl implements CheckoutCounter {
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
            throw new CheckoutLineNotEmptyException("You are trying to close but there are still customers in the checkout line.");
        }
        setCashier(null);
        setOpen(false);
    }

    @Override
    public void joinCheckoutLine(Customer customer) {
        if (!isOpen()) {
            throw new CheckoutCounterClosedException("You are trying to join the line of a closed checkout counter.");
        }
        checkoutLine.offer(customer);
    }

    @Override
    public Price processNextCustomerInLine() {
        if (!isOpen()) {
            throw new CheckoutCounterClosedException("You are trying to process customers when closed");
        }
        if (checkoutLine.isEmpty()) {
            return null;
        }
        Customer nextCustomer = checkoutLine.poll();
        double totalAllGroceries = 0;
        for (Grocery grocery: nextCustomer.getGroceries()) {
            totalAllGroceries += grocery.getPrice().getDecimal() * grocery.getAmount();
        }

        return new Price(totalAllGroceries, Currency.EURO);
    }
}
