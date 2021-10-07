package selfeval.codelab05.mails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mail {
    private final String subject;
    private final String body;
    private final MailAddress sender;
    private final MailAddress recipient;
    private final List<MailAddress> ccList = new ArrayList<>();
    private final List<MailAddress> bcList = new ArrayList<>();

    public Mail(String subject, String body, MailAddress sender, MailAddress recipient) {
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

    public MailAddress getSender() {
        return sender;
    }

    public MailAddress getRecipient() {
        return recipient;
    }

    public boolean addToCC(MailAddress address) {
        if (address == null || ccList.contains(address)) {
            return false;
        }
        return ccList.add(address);
    }

    public boolean addToBC(MailAddress address) {
        if (address == null || bcList.contains(address)) {
            return false;
        }
        return bcList.add(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(subject, mail.subject) && Objects.equals(body, mail.body) && Objects.equals(sender, mail.sender) && Objects.equals(recipient, mail.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, body, sender, recipient);
    }
}
