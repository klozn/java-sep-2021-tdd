package advanced.codelab01;

import advanced.codelab01.domain.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var cashierHenry = new Cashier("Henry");
        var customerLilly = new Customer("Lilly");
        var customerJane = new Customer("Jane");
        var customerRenard = new Customer("Renard");
        var customerJack = new Customer("Jack");
        var customerScot = new Customer("Scot");

        var pear = new Grocery("Pear");
        pear.setAmount(4);
        pear.setPrice(new Price(2.13, Currency.EURO));
        var apple = new Grocery("Apple");
        apple.setAmount(6);
        apple.setPrice(new Price(0.88, Currency.EURO));
        var bread = new Grocery("Bread");
        bread.setAmount(2);
        bread.setPrice(new Price(2.90, Currency.EURO));
        var turnip = new Grocery("Turnip");
        turnip.setAmount(1);
        turnip.setPrice(new Price(1.6, Currency.EURO));
        var wine = new Grocery("Wine");
        wine.setAmount(4);
        wine.setPrice(new Price(9.65, Currency.EURO));

        customerLilly.addGrocery(pear);
        customerLilly.addGrocery(apple);
        customerJane.addGrocery(pear);
        customerJane.addGrocery(bread);
        customerRenard.addGrocery(bread);
        customerRenard.addGrocery(turnip);
        customerJack.addGrocery(turnip);
        customerScot.addGrocery(wine);
        customerScot.addGrocery(bread);
        customerScot.addGrocery(apple);

        CheckoutCounter counter = new EuroCheckoutCounter();

        try {
            counter.joinCheckoutLine(customerLilly);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        counter.open(cashierHenry);
        List.of(customerJane, customerJack, customerLilly, customerRenard, customerScot)
                        .forEach(counter::joinCheckoutLine);

        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());

        try {
            counter.close();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());
        counter.close();
    }
}
