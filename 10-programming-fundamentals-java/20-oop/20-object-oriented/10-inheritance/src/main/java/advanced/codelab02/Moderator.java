package advanced.codelab02;

public class Moderator extends Member {

    private boolean trusted;

    public Moderator(String userName) {
        this(userName, false);
    }

    public Moderator(String userName, boolean trusted) {
        super(userName);
        this.trusted = trusted;
    }

    public boolean isTrusted() {
        return trusted;
    }

    @Override
    public void signIn() {
        if (isTrusted()) {
            System.out.printf("Sup mod %s!? The last time you signed in was %s\n", getUserName(), getLastSignedInOn());
            resetLastSignIn();
        } else {
            super.signIn();
        }
    }
}
