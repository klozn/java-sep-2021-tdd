package advanced.selfeval.codelab02.members;

public class Moderator extends Member {
    private final static String TRUSTED_MOD_WELCOME_MESSAGE = "Sup mod %s!? The last time you signed in was %s\n";
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
        if (isTrusted() && getLastSignedInOn() != null) {
            System.out.printf(TRUSTED_MOD_WELCOME_MESSAGE, getUserName(), getLastSignedInOn());
            updateLastSignIn();
        } else {
            super.signIn();
        }
    }
}
