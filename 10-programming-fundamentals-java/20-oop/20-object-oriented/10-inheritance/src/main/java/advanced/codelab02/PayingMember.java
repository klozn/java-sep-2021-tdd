package advanced.codelab02;

public class PayingMember extends Member {
    public PayingMember(String userName) {
        super(userName);
    }

    @Override
    public void signIn() {
        System.out.printf("Dear honorary %s, welcome! The last time you signed in was %s\n",
                getUserName(), getLastSignedInOn());
        resetLastSignIn();
    }
}
