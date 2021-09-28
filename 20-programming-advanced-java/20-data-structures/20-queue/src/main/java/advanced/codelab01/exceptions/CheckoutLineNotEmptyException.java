package advanced.codelab01.exceptions;

public class CheckoutLineNotEmptyException extends RuntimeException {
    public CheckoutLineNotEmptyException() {
    }

    public CheckoutLineNotEmptyException(String message) {
        super(message);
    }

    public CheckoutLineNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckoutLineNotEmptyException(Throwable cause) {
        super(cause);
    }
}
