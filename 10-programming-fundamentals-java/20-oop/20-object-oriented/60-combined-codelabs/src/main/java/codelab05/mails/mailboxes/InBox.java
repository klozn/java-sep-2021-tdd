package codelab05.mails.mailboxes;

import codelab05.mails.MailAddress;

public class InBox extends Mailbox {
    public final static String NAME = "Inbox";

    public InBox(MailAddress owner) {
        super(owner, NAME);
    }
}
