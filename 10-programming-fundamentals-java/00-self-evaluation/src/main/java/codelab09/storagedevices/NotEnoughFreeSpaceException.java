package codelab09.storagedevices;

public class NotEnoughFreeSpaceException extends RuntimeException {
    public NotEnoughFreeSpaceException() {
    }

    public NotEnoughFreeSpaceException(String message) {
        super(message);
    }

    public NotEnoughFreeSpaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughFreeSpaceException(Throwable cause) {
        super(cause);
    }
}
