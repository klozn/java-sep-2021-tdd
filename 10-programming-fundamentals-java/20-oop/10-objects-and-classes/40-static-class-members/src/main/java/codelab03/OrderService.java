package codelab03;

public class OrderService {
    public final static int ORDER_FEE = 5;

    public static double orderSheep(Sheep sheep) {
        return sheep.getPrice() + ORDER_FEE;
    }

    public static String orderFeeAsText() {
        return "The order fee is €" + ORDER_FEE;
    }
}
