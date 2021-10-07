package selfeval.codelab05;

import selfeval.codelab05.mails.Email;
import selfeval.codelab05.mails.EmailAddress;

import java.util.List;
import java.util.regex.Pattern;

public class ABCEmailSorter implements EmailSorter {
    public static final String RECRUITMENT_MAILBOX_ADDRESS = "recruitment@abc.com";
    public static final String SPAM_MAILBOX_ADDRESS = "spam@abc.com";
    public static final String SALES_MAILBOX_ADDRESS = "sales@abc.com";
    public static final String RECEPTION_MAILBOX_ADDRESS = "reception@abc.com";
    public static final String RECRUITMENT_CHECK = "CV";
    public static final String[] SPAM_CHECKS = new String[]{"promotion", "coupon"};
    public static final String SALES_CHECK = "proposal";

    @Override
    public void sortInbox(EmailAddress address) {
        List<Email> inbox = address.getInbox();

        for (Email mail : inbox) {
            if (mailContainsCheck(mail, RECRUITMENT_CHECK)) {
                sendEmailTo(mail, RECRUITMENT_MAILBOX_ADDRESS);
            } else if (mailContainsCheck(mail, SPAM_CHECKS)) {
                sendEmailTo(mail, SPAM_MAILBOX_ADDRESS);
            } else if (mailContainsCheck(mail, SALES_CHECK)) {
                sendEmailTo(mail, SALES_MAILBOX_ADDRESS);
            } else {
                sendEmailTo(mail, RECEPTION_MAILBOX_ADDRESS);
            }
        }

        for (int i = inbox.size() - 1; i >= 0; i--) {
            inbox.remove(i);
        }
    }

    private void sendEmailTo(Email email, String address) {
        ABCEmailAddressDB.getByAddress(address).receiveEmail(email);
    }

    private boolean mailContainsCheck(Email mail, String toCheck) {
        return mailContainsCheck(mail, new String[]{toCheck});
    }

    private boolean mailContainsCheck(Email mail, String[] toCheck) {
        for (String word : toCheck) {
            if (Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE).matcher(mail.getSubject()).find()) {
                return true;
            }
            if (Pattern.compile(Pattern.quote(word), Pattern.CASE_INSENSITIVE).matcher(mail.getBody()).find()) {
                return true;
            }
        }
        return false;
    }
}
