package codelab05;

import codelab05.mails.MailAddress;
import codelab05.mails.mailboxes.CustomMailbox;
import codelab05.mails.mailboxes.Mailbox;

import static codelab05.MailSorter.*;

public class MailSortingService {
    private final MailSorter mailSorter;
    private final MailAddress address;

    public MailSortingService(MailAddress address) {
        this.mailSorter = new MailSorter();
        this.address = address;
    }

    public void sortInbox() {
        int inboxSize = address.getInBox().getSize();
        addMailboxesIfNotExisting(address);

        int recruitmentSizePreSort = getMailboxByName(RECRUITMENT_MAILBOX_NAME).getSize();
        int spamSizePreSort = getMailboxByName(SPAM_MAILBOX_NAME).getSize();
        int salesSizePreSort = getMailboxByName(SALES_MAILBOX_NAME).getSize();
        int receptionSizePreSort = getMailboxByName(RECEPTION_MAILBOX_NAME).getSize();

        mailSorter.sortInbox(address);

        System.out.println("Total amount of mails sorted: " + inboxSize);
        printAmountSentTo(RECRUITMENT_MAILBOX_NAME, recruitmentSizePreSort);
        printAmountSentTo(SPAM_MAILBOX_NAME, spamSizePreSort);
        printAmountSentTo(SALES_MAILBOX_NAME, salesSizePreSort);
        printAmountSentTo(RECRUITMENT_MAILBOX_NAME, receptionSizePreSort);
    }

    private void addMailboxesIfNotExisting(MailAddress address) {
        address.addMailBox(new CustomMailbox(address, RECRUITMENT_MAILBOX_NAME));
        address.addMailBox(new CustomMailbox(address, SPAM_MAILBOX_NAME));
        address.addMailBox(new CustomMailbox(address, SALES_MAILBOX_NAME));
        address.addMailBox(new CustomMailbox(address, RECEPTION_MAILBOX_NAME));
    }

    private Mailbox getMailboxByName(String name) {
        return address.getMailboxByName(name);
    }

    private int getSizeDifference(Mailbox mailbox, int sizeBefore) {
        return mailbox.getSize() - sizeBefore;
    }

    private void printAmountSentTo(String name, int sizeBefore) {
        System.out.printf("Amount sent to %s: %d\n", name,
                getSizeDifference(getMailboxByName(name), sizeBefore));
    }
}
