package basic.codelab05;

public class InvalidBankAccountOwnerException extends RuntimeException {
    public InvalidBankAccountOwnerException(String message) {
        super("Not a valid bank account owner: " + message);
    }
}
