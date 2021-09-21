package codelab05;

import codelab05.mails.Mail;
import codelab05.mails.MailAddress;

public class Main {
    public static void main(String[] args) {
        MailAddress address = new MailAddress("info@abc.com");
        MailAddress me = new MailAddress("klaas.devits@gmail.com");
        MailAddress colleague = new MailAddress("kurt@abc.com");

        Mail recruitmentMail = new Mail("I want to work for ABC",
                "You can find my cv in the attachments.", me, address);
        Mail firstSpamMail = new Mail("Have you heard of our promotions?",
                "Click this shady link!", me, address);
        Mail secondSpamMail = new Mail("This is not Spam!!1!!1! Don't DELETE",
                "We have amazing and free COUPON codes, send us your credit card info and we'll send these " +
                        "coupons for free!", me, address);
        Mail salesMail = new Mail("Do I have a proposal for you??",
                "Silly Question! I have all the proposals!", me, address);
        Mail receptionMail = new Mail("c v cou pon pro posal",
                "pro mo tion. ", me, address);

        Mail[] mails = new Mail[] {recruitmentMail, firstSpamMail, secondSpamMail, salesMail, receptionMail};

        for (Mail mail : mails) {
            address.getInBox().addMail(mail);
        }

        MailSortingService service = new MailSortingService(address);
        service.sortInbox();

    }
}
