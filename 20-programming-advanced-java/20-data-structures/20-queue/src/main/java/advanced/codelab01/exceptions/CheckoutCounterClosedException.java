package advanced.codelab01.exceptions;

public class CheckoutCounterClosedException extends RuntimeException {
    public CheckoutCounterClosedException() {
    }

    public CheckoutCounterClosedException(String message) {
        super(message);
    }

    public CheckoutCounterClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckoutCounterClosedException(Throwable cause) {
        super(cause);
    }
}
