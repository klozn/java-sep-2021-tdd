package basic.codelab05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private static final double VALID_STARTING_AMOUNT = 251;
    private static final double INVALID_STARTING_AMOUNT = 250;

    @Test
    @DisplayName("When owner is not an adult: throw exception")
    void createBankAccount_whenPersonNotAdult_throwsCorrectException() {
        Person person = new Person("firstName", "lastName", nonAdultBirthday(), testAddress());
        assertThrows(InvalidBankAccountOwnerException.class,
                () -> BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT));
        try {
            BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT);
        } catch (InvalidBankAccountOwnerException exception) {
            assertEquals("Not a valid bank account owner: The owner can't be a minor.",
                    exception.getMessage());
        }
    }

    @Test
    @DisplayName("When owner is missing a first name: throw exception")
    void createBankAccount_whenPersonNotHasFirstName_throwsCorrectException() {
        Person person = new Person("firstName", "", adultBirthDay(), testAddress());
        assertThrows(InvalidBankAccountOwnerException.class,
                () -> BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT));

        try {
            BankAccount.createBankAccount(person,VALID_STARTING_AMOUNT);
        } catch (InvalidBankAccountOwnerException exception) {
            assertEquals("Not a valid bank account owner: The owners full name is not registered.",
                    exception.getMessage());
        }
    }

    @Test
    @DisplayName("When owner is missing a last name: throw exception")
    void createBankAccount_whenPersonNotHasLastName_throwsCorrectException() {
        Person person = new Person("", "lastName", adultBirthDay(), testAddress());
        assertThrows(InvalidBankAccountOwnerException.class,
                () -> BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT));
        try {
            BankAccount.createBankAccount(person,VALID_STARTING_AMOUNT);
        } catch (InvalidBankAccountOwnerException exception) {
            assertEquals("Not a valid bank account owner: The owners full name is not registered.",
                    exception.getMessage());
        }
    }

    @Test
    @DisplayName("When owner is missing an address: throw exception")
    void createBankAccount_whenPersonNotHasAddress_throwsCorrectException() {
        Person person = new Person("firstName", "lastName", adultBirthDay(), null);
        assertThrows(InvalidBankAccountOwnerException.class,
                () -> BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT));
        try {
            BankAccount.createBankAccount(person, VALID_STARTING_AMOUNT);
        } catch (InvalidBankAccountOwnerException exception) {
            assertEquals("Not a valid bank account owner: The owners address is not registered.",
                    exception.getMessage());
        }
    }

    @Test
    @DisplayName("When starting amount is 250 or lower: throw exception")
    void createBankAccount_whenStartingAmountNotHigherThan250_throwsCorrectException() {
        Person person = new Person("firstName", "lastname", adultBirthDay(), testAddress());
        assertThrows(IllegalArgumentException.class,
                () -> BankAccount.createBankAccount(person, INVALID_STARTING_AMOUNT));
        try {
            BankAccount.createBankAccount(person, INVALID_STARTING_AMOUNT);
        } catch (IllegalArgumentException exception) {
            assertEquals("Starting amount must be higher than 250.",
                    exception.getMessage());
        }
    }

    private static LocalDate nonAdultBirthday() {
        return LocalDate.now().minusYears(17);
    }

    private static LocalDate adultBirthDay() {
        return LocalDate.now().minusYears(18);
    }

    private static Address testAddress() {
        return new Address("testStreet", "1A", "testCity", "testCountry");
    }
}