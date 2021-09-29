package basic.codelab01;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<Name, PhoneNumber> phoneBookEntries = new HashMap<>();

    public void addPhoneBookEntry(Name name, PhoneNumber phoneNumber) {
        phoneBookEntries.put(name, phoneNumber);
    }

    public Map<Name, PhoneNumber> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public PhoneNumber getPhoneNumberByName(Name name) {
        return phoneBookEntries.get(name);
    }

    public void removeTheNumberByGivenTheName(Name name) {
        phoneBookEntries.replace(name, null);
    }
}
