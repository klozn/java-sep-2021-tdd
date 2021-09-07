package basic;

public class LoopsCodelabs02 {

    public static void main(String[] args) {
        int numberOfPeople = 10;
        giveTicket(numberOfPeople);
        giveCoke(numberOfPeople);
        increaseTemperature(0);
    }

    /*
     * We're going to write a little application for a cinema. Implement the following methods
     */

    /**
     * Every person needs to get a ticket.
     * print out 'Ticket' once for every person
     */
    private static void giveTicket(int numberOfPeople) {
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Ticket");
        }
    }

    /**
     * Every two people need to get a coke.
     * Print out 'Giving a coke' for every two people
     */
    private static void giveCoke(int numberOfPeople) {
        for (int i = 0; i < numberOfPeople; i += 2) {
            System.out.println("Giving a coke");
        }
    }

    /**
     * The temperature of the room is way too cold.
     * Print out 'increase temperature by one. The new temperature is now <new_temperature>' until the temperature is 22 degrees.
     */
    private static void increaseTemperature(int currentTemperature) {
        for (int i = currentTemperature; i <= 22; i++) {
            System.out.println("increase temperature by one. The new temperature is now " + i);
        }
    }

}
