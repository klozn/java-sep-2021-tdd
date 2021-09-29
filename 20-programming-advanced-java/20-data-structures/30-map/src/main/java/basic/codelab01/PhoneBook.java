package basic.codelab01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public void removePhoneNumberByName(Name name) {
        phoneBookEntries.remove(name);
    }

    public void updatePhoneNumber(Name name, PhoneNumber phoneNumber) {
        phoneBookEntries.replace(name, phoneNumber);
    }

    public Set<Name> getAllNamesInPhoneBook() {
        return phoneBookEntries.keySet();
    }

    public Set<Map.Entry<Name, PhoneNumber>> getThemAll() {
        return phoneBookEntries.entrySet();
    }
}
