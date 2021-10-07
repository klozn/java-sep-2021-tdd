package advanced.selfeval.codelab02;

import advanced.selfeval.codelab02.members.FreeMember;
import advanced.selfeval.codelab02.members.Member;
import advanced.selfeval.codelab02.members.Moderator;
import advanced.selfeval.codelab02.members.PayingMember;

public class MainApp {
    public static void main(String[] args) {
        Member moderator = new Moderator("mod");
        moderator.signIn();
        moderator.signIn();
        Member freeMember = new FreeMember("freebie");
        freeMember.signIn();
        freeMember.signIn();
        Member hiddenMod = new Moderator("secretMod", true);
        hiddenMod.signIn();
        hiddenMod.signIn();
        freeMember.signIn();
        Member payingMember = new PayingMember("richie");
        payingMember.signIn();
        payingMember.signIn();
    }
}
