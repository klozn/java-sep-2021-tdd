package selfeval.codelab05.mails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmailAddress {
    private final String address;
    private final List<Email> inbox;

    public EmailAddress(String address) {
        this.address = address;
        inbox = new ArrayList<>();
    }

    public void receiveEmail(Email email) {
        inbox.add(email);
    }

    public String getAddress() {
        return address;
    }

    public List<Email> getInbox() {
        return inbox;
    }

    public int getNrOfEmailsInInbox() {
        return inbox.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
