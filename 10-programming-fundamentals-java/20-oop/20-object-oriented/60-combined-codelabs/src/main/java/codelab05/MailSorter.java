package codelab05;

import codelab05.mails.Mail;
import codelab05.mails.MailAddress;
import codelab05.mails.mailboxes.Mailbox;

import java.util.regex.Pattern;

public class MailSorter {
    public static final String RECRUITMENT_MAILBOX_NAME = "recruitment";
    public static final String RECRUITMENT_CHECK = "CV";
    public static final String SPAM_MAILBOX_NAME = "spam";
    public static final String[] SPAM_CHECKS = new String[]{"promotion", "coupon"};
    public static final String SALES_MAILBOX_NAME = "sales";
    public static final String SALES_CHECK = "proposal";
    public static final String RECEPTION_MAILBOX_NAME = "reception";


    public void sortInbox(MailAddress address) {
        Mailbox inbox = address.getInBox();

        for (Mail mail : inbox.getMails()) {
            if (mailContainsCheck(mail, RECRUITMENT_CHECK)) {
                address.getMailboxByName(RECRUITMENT_MAILBOX_NAME).addMail(mail);
            } else if (mailContainsCheck(mail, SPAM_CHECKS)) {
                address.getMailboxByName(SPAM_MAILBOX_NAME).addMail(mail);
            } else if (mailContainsCheck(mail, SALES_CHECK)) {
                address.getMailboxByName(SALES_MAILBOX_NAME).addMail(mail);
            } else {
                address.getMailboxByName(RECEPTION_MAILBOX_NAME).addMail(mail);
            }
        }
        for (int i = 0; i < inbox.getSize(); i++) {
            inbox.getMails().remove(i);
        }
    }

    private boolean mailContainsCheck(Mail mail, String toCheck) {
        return mailContainsCheck(mail, new String[]{toCheck});
    }

    private boolean mailContainsCheck(Mail mail, String[] toCheck) {
        for (String s : toCheck) {
            if (Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(mail.getSubject()).find()) {
                return true;
            }
            if (Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(mail.getBody()).find()) {
                return true;
            }
        }
        return false;
    }
}
