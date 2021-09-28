package basic.codelab01;

public class Airport {

    public static void main(String[] args) {
        Gate gate = new Gate();

        gate.goStandInLineToBoard(new Passenger("Rick", BoardingPriority.ECONOMY));
        gate.goStandInLineToBoard(new Passenger("Rock", BoardingPriority.BUSINESS));
        gate.goStandInLineToBoard(new Passenger("Rack", BoardingPriority.ECONOMY));
        gate.goStandInLineToBoard(new Passenger("Ruck", BoardingPriority.FIRST_CLASS));
        gate.goStandInLineToBoard(new Passenger("Ryck", BoardingPriority.BUSINESS));
        gate.goStandInLineToBoard(new Passenger("Reck", BoardingPriority.ECONOMY));
        gate.goStandInLineToBoard(new Passenger("Reyck", BoardingPriority.FIRST_CLASS));

        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
        System.out.println(gate.letNextPassengerBoard());
    }

}
