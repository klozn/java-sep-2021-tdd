package advanced.selfeval.codelab02.members;

import java.time.LocalDate;

public class Member {
    private final static String FIRST_SIGN_IN_WELCOME_MESSAGE = "Welcome %s, nice of you to join!\n";
    private final static String MEMBER_WELCOME_MESSAGE = "Welcome %s, the last time you signed in was %s.\n";
    private final String userName;
    private final String welcomeMessage;
    private LocalDate lastSignedInOn;

    public Member(String userName) {
        this(userName, MEMBER_WELCOME_MESSAGE);
    }

    protected Member(String userName, String welcomeMessage) {
        this.userName = userName;
        this.welcomeMessage = welcomeMessage;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getLastSignedInOn() {
        return lastSignedInOn;
    }

    public void signIn() {
        if (lastSignedInOn == null) {
            System.out.printf(FIRST_SIGN_IN_WELCOME_MESSAGE, userName);
        } else {
            System.out.printf(welcomeMessage, userName, lastSignedInOn);
        }
        updateLastSignIn();
    }

    protected void updateLastSignIn() {
        lastSignedInOn = LocalDate.now();
    }
}
