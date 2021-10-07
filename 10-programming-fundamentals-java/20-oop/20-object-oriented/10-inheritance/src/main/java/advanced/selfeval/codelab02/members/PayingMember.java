package advanced.selfeval.codelab02.members;

public class PayingMember extends Member {
    private final static String WELCOME_MESSAGE = "Dear honorary %s, welcome! The last time you signed in was %s\n";
    public PayingMember(String userName) {
        super(userName, WELCOME_MESSAGE);
    }
}
