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
        System.out.println("You have selected " + sport);
        System.out.println("Description: " + getDescription(sport));
        System.out.println("Popularity: " + getPopularity(sport));
        System.out.println("This sport is " + (hasBall(sport)? "" : "not ") + "played with a ball");
        System.out.println("This sport is " + (isTeamSport(sport)? "" : "not ") + "a team sport");
    }

    private static int getPopularity(String sport) {
        switch (sport) {
            case "Football" : return 1;
            case "Hockey":
            case "Tennis": return 2;
            case "Archery":
            case "Handball": return 4;
            case "Rugby":
            default: return 3;
        }
    }

    private static String getDescription(String sport) {
        switch (sport) {
            case "Football" : return "You kick a ball away and then run after it.";
            case "Hockey": return "You kick a ball away with a stick and then run after it.";
            case "Tennis": return "You hit a ball with a racket over a net, in the hope that the guy on the other side of the net can't do the same.";
            case "Archery": return "You try to hit a target with an arrow shot from a bow.";
            case "Handball": return "You throw a ball away and then run after it.";
            case "Rugby": return "You run away with a ball and other people try to stop you by ramming you.";
            default: return "Unknown sport";
        }
    }

    private static boolean hasBall(String sport) {
        switch (sport) {
            case "Hockey":
            case "Football":
            case "Rugby": return true;
            default: return false;
        }
    }

    private static boolean isTeamSport(String sport) {
        switch (sport) {
            case "Archery":
            case "Tennis": return false;
            default: return true;
        }
    }
}
