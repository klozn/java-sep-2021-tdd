package basic.codelab01;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private static PhoneBook phoneBook;

    @Test
    void addPhoneBookEntry_addsEntry() {
        //given
        phoneBook = new PhoneBook();
        Name name = new Name("TestFirstName", "TestLastName");
        PhoneNumber number = new PhoneNumber("+32", "485945011");
        //when
        phoneBook.addPhoneBookEntry(name, number);
        //then
        assertTrue(phoneBook.getPhoneBookEntries().containsKey(name));
        assertEquals(number, phoneBook.getPhoneBookEntries().get(name));
    }


    @Test
    void getThePhoneNumberByTheName() {
        //given
        addContentToMap();
        //when
        PhoneNumber numberRetrieved = phoneBook.getPhoneNumberByName(new Name("kim", "kimkimkim"));
        //then
        assertEquals(new PhoneNumber("+32", "482334564"), numberRetrieved);
    }


    @Test
    void removeThePhoneNumberFromPhoneBookByTheGivenName() {
        //given
        addContentToMap();
        Name kim = new Name("kim", "kimkimkim");
        assertNotNull(phoneBook.getPhoneNumberByName(kim));
        //when
        phoneBook.removePhoneNumberByName(kim);
        //then
        assertNull(phoneBook.getPhoneNumberByName(kim));
        assertFalse(phoneBook.getPhoneBookEntries().containsKey(kim));
    }

    @Test
    void updatePhoneNumberChangesTheNumberForTheGivenName() {
        //given
        addContentToMap();
        Name kim = new Name("kim", "kimkimkim");
        assertNotNull(phoneBook.getPhoneNumberByName(kim));
        //when
        phoneBook.updatePhoneNumber(kim, new PhoneNumber("+32", "564654658"));
        //then
        assertEquals(new PhoneNumber("+32", "564654658"), phoneBook.getPhoneNumberByName(kim));
    }

    @Test
    void getAllOnlyTheNamesInThePhoneBook() {
        //given
        addContentToMap();
        //when
        Set<Name> names = phoneBook.getAllNamesInPhoneBook();
        //then
        assertTrue(names.containsAll(List.of(
                new Name("kim", "kimkimkim"),
                new Name("sim", "simsimsim"),
                new Name("sim", "simsimsim")
        )));
    }

    @Test
    void getAllPhoneBookContent(){
        //given
        addContentToMap();
        //when
        Set<Entry<Name, PhoneNumber>> allInfo = phoneBook.getThemAll();
        //then
        assertTrue(allInfo.containsAll(Set.of(
                new AbstractMap.SimpleEntry<>(new Name("kim", "kimkimkim"),
                        new PhoneNumber("+32", "482334564")),
                new AbstractMap.SimpleEntry<>(new Name("sim", "simsimsim"),
                        new PhoneNumber("+32", "485456458")),
                new AbstractMap.SimpleEntry<>(new Name("tim", "timtimtim"),
                        new PhoneNumber("+32", "485783488"))
        )));
    }

    private static void addContentToMap() {
        phoneBook = new PhoneBook();
        Name kim = new Name("kim", "kimkimkim");
        PhoneNumber numberKim = new PhoneNumber("+32", "482334564");

        Name sim = new Name("sim", "simsimsim");
        PhoneNumber numberSim = new PhoneNumber("+32", "485456458");

        Name tim = new Name("tim", "timtimtim");
        PhoneNumber numberTim = new PhoneNumber("+32", "485783488");

        phoneBook.addPhoneBookEntry(kim, numberKim);
        phoneBook.addPhoneBookEntry(sim, numberSim);
        phoneBook.addPhoneBookEntry(tim, numberTim);

    }
}
