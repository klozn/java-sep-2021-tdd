package advanced;

public class ArraysCodelab07 {

    /**
     * We're developing an app for a shop.
     * <p>
     * The shop has a system whereby a customer can earn points when he buys products in the shop.
     * <p>
     * You need to develop this points system.
     * <p>
     * The database is an int array.
     * Every customer has a number starting from 1 to 10 (there are only 10 customers for the shop).
     * 1. Implement a method that will allow you to increase the points of a customer
     * 2. Implement a method that will return the points a customer has
     * 3. Make sure that all edge cases are checked!
     * <p>
     *                      ----------- part 2 -------------
     * <p>
     * The shopping brand has a second shop, that also wants to use this points system.
     * However there isn't enough money for a second database.
     * <p>
     * 1. Reuse the same database to develop the point system for the second shop.
     * 2. Make sure to check all the edge cases here as well.
     * <p>
     * Rules for the database are:
     * - Elements 1 to 10 in the database are reserved for the first shop
     * - Elements 11 to 20 in the database are reserved for the second shop
     * <p>
     * !The numbers of the customers in the second shop also start from 1 to 10.
     */
    public static void main(String[] args) {
        int[] customerDatabase = new int[20];
        increasePointsFromCustomerInFirstShop(3, 5, customerDatabase);
        increasePointsFromCustomerInFirstShop(3, 5, customerDatabase);
        System.out.println(getPointsFromCustomerInFirstShop(3, customerDatabase));

        increasePointsFromCustomerInSecondShop(5, 5, customerDatabase);
        increasePointsFromCustomerInSecondShop(5, 5, customerDatabase);
        System.out.println(getPointsFromCustomerInSecondShop(5, customerDatabase));
    }

    public static void increasePointsFromCustomerInFirstShop(int customerNumber, int points, int[] database) {

    }

    public static int getPointsFromCustomerInFirstShop(int customerNumber, int[] database) {
        return 0;
    }

    public static void increasePointsFromCustomerInSecondShop(int customerNumber, int points, int[] database) {

    }

    public static int getPointsFromCustomerInSecondShop(int customerNumber, int[] database) {
        return 0;
    }
}
