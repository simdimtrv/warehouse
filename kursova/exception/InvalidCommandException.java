package bg.tu_varna.sit.f24621686.warehouseproject.exception;

/**
 * Thrown when an unknown command is entered.
 */
public class InvalidCommandException extends Exception {

    /**
     * Creates an exception with a custom message.
     *
     * @param message error message
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}