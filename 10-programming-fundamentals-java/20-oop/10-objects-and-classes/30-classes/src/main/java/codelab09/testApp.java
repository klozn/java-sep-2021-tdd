package codelab09;

public class testApp {

    public static void main(String[] args) {
        Grid grid = new Grid();

        for (Ship s: grid.getShips()) {
            System.out.println(s);
        }
    }
}
