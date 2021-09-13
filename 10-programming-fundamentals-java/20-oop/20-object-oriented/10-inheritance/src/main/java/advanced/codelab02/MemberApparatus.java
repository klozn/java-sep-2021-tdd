package advanced.codelab02;

public class MemberApparatus {
    public static void main(String[] args) {
        Moderator moderator = new Moderator("mod");
        moderator.signIn();
        FreeMember freeMember = new FreeMember("freebie");
        freeMember.signIn();
        Member hiddenMod = new Moderator("secretMod", true);
        hiddenMod.signIn();
        hiddenMod.signIn();
        freeMember.signIn();
        PayingMember payingMember = new PayingMember("richie");
        payingMember.signIn();
        payingMember.signIn();
    }
}
