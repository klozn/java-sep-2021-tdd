package codelab05.mails.mailboxes;

import codelab05.mails.Mail;
import codelab05.mails.MailAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Mailbox {
    private final MailAddress owner;
    private final String name;
    private final List<Mail> mails = new ArrayList<>();

    public Mailbox(MailAddress owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public int getSize() {
        return mails.size();
    }

    public List<Mail> getMails() {
        return mails;
    }

    public String getName() {
        return name;
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public void removeMail(Mail mail) {
        mails.remove(mail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mailbox mailbox = (Mailbox) o;
        return Objects.equals(owner, mailbox.owner) && Objects.equals(name, mailbox.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name);
    }
}
