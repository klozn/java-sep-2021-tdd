package codelab05.mails;

import codelab05.mails.mailboxes.InBox;
import codelab05.mails.mailboxes.Mailbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MailAddress {
    private final String address;
    private final List<Mailbox> mailboxes = new ArrayList<>();

    public MailAddress(String address) {
        this.address = address;
        addMailBox(new InBox(this));
    }

    public String getAddress() {
        return address;
    }

    public Mailbox getInBox() {
        return mailboxes.stream()
                .filter(mailbox -> mailbox instanceof InBox)
                .findAny().orElse(null);
    }

    public Mailbox getMailboxByName(String name) {
        return mailboxes.stream()
                .filter(mailbox -> name.equals(mailbox.getName()))
                .findAny().orElse(null);
    }

    public boolean addMailBox(Mailbox mailbox) {
        if (mailbox == null || mailboxes.contains(mailbox)) {
            return false;
        }
        return mailboxes.add(mailbox);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress that = (MailAddress) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
