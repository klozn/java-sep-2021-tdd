package selfeval.codelab05;

import selfeval.codelab05.mails.Email;
import selfeval.codelab05.mails.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class ABCEmailSortingService implements EmailSortingService {
    @Override
    public void sortInbox(EmailSorter emailSorter, EmailAddress address) {
        int nrOfEmailsInInbox = address.getNrOfEmailsInInbox();
        List<Email> emailsToSort = new ArrayList<>(address.getInbox());
        emailSorter.sortInbox(address);

        System.out.println("Amount of mails sorted: " + nrOfEmailsInInbox);
        var recruitment = ABCEmailAddressDB.getByAddress("recruitment@abc.com");
        var spam = ABCEmailAddressDB.getByAddress("spam@abc.com");
        var sales = ABCEmailAddressDB.getByAddress("sales@abc.com");
        var reception = ABCEmailAddressDB.getByAddress("reception@abc.com");

        List.of(recruitment, spam, sales, reception).forEach(
                emailAddress -> System.out.printf("Nr of emails sent to %s = %d\n",
                        emailAddress.getAddress(), countEmailsSortedTo(emailAddress, emailsToSort))
        );
    }

    private static int countEmailsSortedTo(EmailAddress emailAddress, List<Email> sorted) {
        return (int) emailAddress.getInbox().stream()
                .filter(sorted::contains)
                .distinct()
                .count();
    }
}
