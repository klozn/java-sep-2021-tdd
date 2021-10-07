package selfeval.codelab05;

import selfeval.codelab05.mails.EmailAddress;

public interface EmailSortingService {
    void sortInbox(EmailSorter sorter, EmailAddress address);
}
