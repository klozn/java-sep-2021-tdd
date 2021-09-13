package advanced.codelab02;

import java.time.LocalDate;

public class Member {

    private String userName;
    private LocalDate lastSignedInOn;

    public Member(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getLastSignedInOn() {
        return lastSignedInOn;
    }

    public void signIn() {
        System.out.printf("Welcome %s, the last time you signed in was %s\n", getUserName(),
                getLastSignedInOn() == null? "never": getLastSignedInOn());
        resetLastSignIn();
    }

    protected void resetLastSignIn() {
        lastSignedInOn = LocalDate.now();
    }
}
