package selfeval.codelab05;

import selfeval.codelab05.mails.Email;
import selfeval.codelab05.mails.EmailAddress;

public class Main {
    public static void main(String[] args) {
        EmailAddress infoAddress = ABCEmailAddressDB.getByAddress("info@abc.com");
        EmailAddress me = new EmailAddress("klaas.devits@gmail.com");
        EmailAddress colleague = new EmailAddress("kurt@abc.com");

        Email recruitmentMail = new Email("I want to work for ABC",
                "You can find my cv in the attachments.", me, infoAddress);
        Email firstSpamMail = new Email("Have you heard of our promotions?",
                "Click this shady link!", me, infoAddress);
        Email secondSpamMail = new Email("This is not Spam!!1!!1! Don't DELETE",
                "We have amazing and free COUPON codes, send us your credit card info and we'll send these " +
                        "coupons for free!", me, infoAddress);
        Email salesMail = new Email("Do I have a proposal for you??",
                "Silly Question! I have all the proposals!", me, infoAddress);
        Email receptionMail = new Email("c v cou pon pro posal",
                "pro mo tion. ", me, infoAddress);
        Email colleagueMail = new Email("Payslips", "When???", colleague, infoAddress);

        Email[] mails = new Email[] {recruitmentMail, firstSpamMail, secondSpamMail,
                salesMail, receptionMail, colleagueMail};

        for (Email mail : mails) {
            infoAddress.receiveEmail(mail);
        }

        EmailSortingService service = new ABCEmailSortingService();
        service.sortInbox(new ABCEmailSorter(), infoAddress);

        for (Email mail : mails) {
            infoAddress.receiveEmail(mail);
        }
        service.sortInbox(new EmailSorterSimpl(), infoAddress);
    }
}
