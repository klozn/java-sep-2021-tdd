package codelab03;

public class SheepOrderApp {
    public static void main(String[] args) {
        Sheep maggy = new Sheep("Maggy", 50, true);
        Sheep notDolly = new Sheep("not Dolly", 60, false);
        Sheep fancy = new Sheep("Fancy", 99.99, true);
        Sheep rupert = new Sheep("Rupert", 42, false);

        System.out.println(Sheep.amountOfActiveSheep());
        System.out.println(maggy);
        System.out.println(notDolly);
        System.out.println(fancy);
        System.out.println(rupert);

        System.out.println(OrderService.orderFeeAsText());

        System.out.println(OrderService.orderSheep(maggy));
        System.out.println(OrderService.orderSheep(notDolly));
        System.out.println(OrderService.orderSheep(fancy));
        System.out.println(OrderService.orderSheep(rupert));

    }
}
