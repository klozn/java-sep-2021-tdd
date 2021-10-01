package basic.codelab05;

public class BankAccount {
    private final Person owner;
    private final double startingAmount;

    private BankAccount(Person owner, double startingAmount) {
        this.owner = owner;
        this.startingAmount = startingAmount;
    }

    public static BankAccount createBankAccount(Person person, double startingAmount) {
        if (!isValidStartingAmount(startingAmount)) {
            throw new IllegalArgumentException("Starting amount must be higher than 250.");
        }
        assertValidAccountOwner(person);
        return new BankAccount(person, startingAmount);
    }

    private static boolean isValidStartingAmount(double startingAmount) {
        return startingAmount > 250;
    }

    private static void assertValidAccountOwner(Person person) {
        if (person.getAge() < 18) {
            throw new InvalidBankAccountOwnerException("The owner can't be a minor.");
        }
        if (person.getFirstName().isBlank() || person.getLastName().isBlank()) {
            throw new InvalidBankAccountOwnerException("The owners full name is not registered.");
        }
        if (person.getAddress() == null) {
            throw new InvalidBankAccountOwnerException("The owners address is not registered.");
        }
    }

}
