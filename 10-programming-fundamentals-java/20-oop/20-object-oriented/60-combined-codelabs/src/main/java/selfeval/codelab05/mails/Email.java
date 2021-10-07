package selfeval.codelab05.mails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Email {
    private final String subject;
    private final String body;
    private final EmailAddress sender;
    private final EmailAddress recipient;
    private final List<EmailAddress> ccList = new ArrayList<>();
    private final List<EmailAddress> bcList = new ArrayList<>();

    public Email(String subject, String body, EmailAddress sender, EmailAddress recipient) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public EmailAddress getSender() {
        return sender;
    }

    public EmailAddress getRecipient() {
        return recipient;
    }

    public boolean addToCC(EmailAddress address) {
        if (address == null || ccList.contains(address)) {
            return false;
        }
        return ccList.add(address);
    }

    public boolean addToBC(EmailAddress address) {
        if (address == null || bcList.contains(address)) {
            return false;
        }
        return bcList.add(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email mail = (Email) o;
        return Objects.equals(subject, mail.subject) && Objects.equals(body, mail.body) && Objects.equals(sender, mail.sender) && Objects.equals(recipient, mail.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, body, sender, recipient);
    }
}
