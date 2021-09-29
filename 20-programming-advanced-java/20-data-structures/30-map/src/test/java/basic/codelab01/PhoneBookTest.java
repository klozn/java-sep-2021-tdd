package basic.codelab01;

import org.junit.jupiter.api.Test;

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
        addContentToMap();
        Name kim = new Name("kim", "kimkimkim");
        assertNotNull(phoneBook.getPhoneNumberByName(kim));
        phoneBook.removeTheNumberByGivenTheName(kim);
        assertNull(phoneBook.getPhoneNumberByName(kim));
        assertTrue(phoneBook.getPhoneBookEntries().containsKey(kim));

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
