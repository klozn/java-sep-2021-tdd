package advanced;

public class DecisionMakingCodelab02 {

    public static void main(String[] args) {
        printOutSport("Hockey");
        System.out.println("*******************");
        printOutSport("Football");
        System.out.println("*******************");
        printOutSport("Tennis");
        System.out.println("*******************");
    }

    /**
     * Convert and split this one switch statement into multiple switch expressions. Put the new switch expressions in separate methods.
     * Run the tests often to see that you haven't broken anything
     * Is the code more readably after the conversion?
     * What do you think?
     * What are the advantages/disadvantages?
     */
    public static void printOutSport(String sport) {
        int popularity;
        String description;
        boolean hasBall;
        boolean teamSport;
        switch (sport) {
            case "Football":
                System.out.println("You have selected Football");
                popularity = 1;
                description = "You kick a ball away and then run after it.";
                hasBall = true;
                teamSport = true;
                break;
            case "Hockey":
                System.out.println("You have selected Hockey");
                popularity = 2;
                description = "You kick a ball away with a stick and then run after it.";
                hasBall = true;
                teamSport = true;
                break;
            case "Rugby":
                System.out.println("You have selected Rugby");
                popularity = 3;
                description = "You run away with a ball and other people try to stop you by ramming you.";
                hasBall = true;
                teamSport = true;
                break;
            case "Archery":
                System.out.println("You have selected Archery");
                popularity = 4;
                description = "You try to hit a target with an arrow shot from a bow.";
                hasBall = false;
                teamSport = false;
                break;
            case "Tennis":
                System.out.println("You have selected Tennis");
                popularity = 2;
                description = "You hit a ball with a racket over a net, in the hope that the guy on the other side of the net can't do the same.";
                hasBall = false;
                teamSport = false;
                break;
            case "Handball":
                System.out.println("You have selected Handball");
                popularity = 4;
                description = "You throw a ball away and then run after it.";
                hasBall = false;
                teamSport = true;
                break;
            default:
                System.out.println("You have selected " + sport);
                description = "Unknown sport";
                popularity = 3;
                hasBall = false;
                teamSport = true;
        }
        System.out.println("Description: " + description);
        System.out.println("Popularity: " + popularity);
        System.out.println("This sport is " + (hasBall? "" : "not ") + "played with a ball");
        System.out.println("This sport is " + (teamSport? "" : "not ") + "a team sport");
    }
}
