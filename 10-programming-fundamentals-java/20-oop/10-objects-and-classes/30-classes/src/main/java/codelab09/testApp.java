package codelab09;

public class testApp {

    public static void main(String[] args) {
        BattleShipGameService grid = new BattleShipGameService();

        for (Ship s: grid.getShips()) {
            System.out.println(s);
        }
    }
}
