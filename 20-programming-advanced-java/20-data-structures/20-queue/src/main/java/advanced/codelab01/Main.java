package advanced.codelab01;

public class Main {
    public static void main(String[] args) {
        Cashier cashier = new Cashier("Henry");
        Customer customer1 = new Customer("Lilly");
        Customer customer2 = new Customer("Jane");
        Customer customer3 = new Customer("Renard");
        Customer customer4 = new Customer("Jack");
        Customer customer5 = new Customer("Scot");
        Grocery grocery1 = new Grocery("Pear");
        grocery1.setAmount(4);
        grocery1.setPrice(new Price(2.13, Currency.EURO));
        Grocery grocery2 = new Grocery("Apple");
        grocery2.setAmount(6);
        grocery2.setPrice(new Price(0.88, Currency.EURO));
        Grocery grocery3 = new Grocery("Bread");
        grocery3.setAmount(2);
        grocery3.setPrice(new Price(2.90, Currency.EURO));
        Grocery grocery4 = new Grocery("Turnip");
        grocery4.setAmount(1);
        grocery4.setPrice(new Price(1.6, Currency.EURO));
        Grocery grocery5 = new Grocery("Wine");
        grocery5.setAmount(4);
        grocery5.setPrice(new Price(9.65, Currency.EURO));
        customer1.addGrocery(grocery1);
        customer1.addGrocery(grocery2);
        customer2.addGrocery(grocery1);
        customer2.addGrocery(grocery3);
        customer3.addGrocery(grocery3);
        customer3.addGrocery(grocery4);
        customer4.addGrocery(grocery4);
        customer5.addGrocery(grocery5);
        customer5.addGrocery(grocery3);

        CheckoutCounter counter = new CheckoutCounterImpl();
        try {
            counter.joinCheckoutLine(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        counter.open(cashier);
        counter.joinCheckoutLine(customer1);
        counter.joinCheckoutLine(customer2);
        counter.joinCheckoutLine(customer3);
        counter.joinCheckoutLine(customer4);
        counter.joinCheckoutLine(customer5);
        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());
        try {
            counter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(counter.processNextCustomerInLine());
        System.out.println(counter.processNextCustomerInLine());
        counter.close();
    }
}
