package basic.codelab01;

import java.util.PriorityQueue;
import java.util.Queue;

class Gate {

    private final Queue<Passenger> passengersToBoard;

    Gate() {
        this.passengersToBoard = new PriorityQueue<>();
    }

    void goStandInLineToBoard(Passenger passenger) {
        if (passenger != null) {
            passengersToBoard.offer(passenger);
        }
    }

    Passenger letNextPassengerBoard() {
        return passengersToBoard.poll();
    }
}
