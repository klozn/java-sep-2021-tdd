package selfeval.codelab05;

import selfeval.codelab05.mails.EmailAddress;

import java.util.Set;

public class ABCEmailAddressDB {
    private final static Set<EmailAddress> ADDRESSES = Set.of(
            new EmailAddress("info@abc.com"), new EmailAddress("recruitment@abc.com"),
            new EmailAddress("spam@abc.com"), new EmailAddress("sales@abc.com"),
            new EmailAddress("reception@abc.com")
    );

    public static EmailAddress getByAddress(String address) {
        return ADDRESSES.stream()
                .filter(email -> email.getAddress().equals(address))
                .findAny().orElseThrow();
    }

}
