package basic.codelab01;

public class Passenger implements Comparable<Passenger>{

    private final String name;
    private final BoardingPriority boardingPriority;

    Passenger(String name, BoardingPriority boardingPriority) {
        this.name = name;
        this.boardingPriority = boardingPriority;
    }

    String getName() {
        return name;
    }

    BoardingPriority getBoardingPriority() {
        return boardingPriority;
    }

    @Override
    public int compareTo(Passenger otherPassenger) {
        return otherPassenger.getBoardingPriority().getPriorityLevel() - boardingPriority.getPriorityLevel();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passenger{");
        sb.append("name='").append(name).append('\'');
        sb.append(", boardingPriority=").append(boardingPriority);
        sb.append('}');
        return sb.toString();
    }
}
