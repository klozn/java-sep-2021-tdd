package basic.codelab01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private static Phonebook phonebook;

    @Test
    void addPhoneBookEntry() {
        //given
        phonebook = new Phonebook();
        Name name = new Name("TestFirstName", "TestLastName");
        PhoneNumber number = new PhoneNumber("+32", "485945011");
        //when
        phonebook.addPhonebookEntry(name, number);
        //then
        assertTrue(phonebook.getPhonebookEntries().containsKey(name));
        assertEquals(number, phonebook.getPhonebookEntries().get(name));
    }


    @Test
    void getPhoneNumberByName() {
        //given
        populatePhonebook();
        //when
        PhoneNumber numberRetrieved = phonebook.getPhoneNumberByName(new Name("kim", "kimkimkim"));
        //then
        assertEquals(new PhoneNumber("+32", "482334564"), numberRetrieved);
    }


    @Test
    void removePhoneNumberFromPhoneBookByName() {
        //given
        populatePhonebook();
        Name kim = new Name("kim", "kimkimkim");
        assertNotNull(phonebook.getPhoneNumberByName(kim));
        //when
        phonebook.removePhoneNumberByName(kim);
        //then
        assertNull(phonebook.getPhoneNumberByName(kim));
        assertFalse(phonebook.getPhonebookEntries().containsKey(kim));
    }

    @Test
    void updatePhoneNumberForName() {
        //given
        populatePhonebook();
        Name kim = new Name("kim", "kimkimkim");
        assertNotNull(phonebook.getPhoneNumberByName(kim));
        //when
        phonebook.updatePhoneNumber(kim, new PhoneNumber("+32", "564654658"));
        //then
        assertEquals(new PhoneNumber("+32", "564654658"), phonebook.getPhoneNumberByName(kim));
    }

    @Test
    void getAllNames() {
        //given
        populatePhonebook();
        //when
        Set<Name> names = phonebook.getAllNamesInPhoneBook();
        //then
        assertTrue(names.containsAll(List.of(
                new Name("kim", "kimkimkim"),
                new Name("sim", "simsimsim"),
                new Name("sim", "simsimsim")
        )));
    }

    @Test
    void getAllPhoneBookContent() {
        //given
        populatePhonebook();
        //when
        Set<Entry<Name, PhoneNumber>> allInfo = phonebook.getThemAll();
        //then
        assertTrue(allInfo.containsAll(Set.of(
                new AbstractMap.SimpleEntry<>(
                        new Name("kim", "kimkimkim"),
                        new PhoneNumber("+32", "482334564")),
                new AbstractMap.SimpleEntry<>(
                        new Name("sim", "simsimsim"),
                        new PhoneNumber("+32", "485456458")),
                new AbstractMap.SimpleEntry<>(
                        new Name("tim", "timtimtim"),
                        new PhoneNumber("+32", "485783488"))
        )));
    }

    private static void populatePhonebook() {
        phonebook = new Phonebook();
        Name kim = new Name("kim", "kimkimkim");
        PhoneNumber numberKim = new PhoneNumber("+32", "482334564");

        Name sim = new Name("sim", "simsimsim");
        PhoneNumber numberSim = new PhoneNumber("+32", "485456458");

        Name tim = new Name("tim", "timtimtim");
        PhoneNumber numberTim = new PhoneNumber("+32", "485783488");

        phonebook.addPhonebookEntry(kim, numberKim);
        phonebook.addPhonebookEntry(sim, numberSim);
        phonebook.addPhonebookEntry(tim, numberTim);

    }
}
