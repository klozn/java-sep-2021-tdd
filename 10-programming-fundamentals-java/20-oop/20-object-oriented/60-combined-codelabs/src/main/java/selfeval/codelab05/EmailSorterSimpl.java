package selfeval.codelab05;

import selfeval.codelab05.mails.Email;
import selfeval.codelab05.mails.EmailAddress;

import java.util.List;

public class EmailSorterSimpl implements EmailSorter {
    public static final String SPAM_MAILBOX_ADDRESS = "spam@abc.com";
    public static final String RECEPTION_MAILBOX_ADDRESS = "reception@abc.com";

    @Override
    public void sortInbox(EmailAddress address) {
        List<Email> inbox = address.getInbox();
        for (Email email : inbox) {
            if (email.getSender().getAddress().contains("@abc.com")) {
                sendEmailTo(email, RECEPTION_MAILBOX_ADDRESS);
            } else {
                sendEmailTo(email, SPAM_MAILBOX_ADDRESS);
            }
        }

        for (int i = inbox.size() - 1; i >= 0; i--) {
            inbox.remove(i);
        }
    }

    private void sendEmailTo(Email email, String address) {
        ABCEmailAddressDB.getByAddress(address).receiveEmail(email);
    }
}
