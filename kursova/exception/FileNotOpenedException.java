package bg.tu_varna.sit.f24621686.warehouseproject.exception;

/**
 * Thrown when an operation requires
 * an opened file but no file is currently opened.
 */
public class FileNotOpenedException extends Exception {

    /**
     * Creates an exception with a custom message.
     *
     * @param message error message
     */
    public FileNotOpenedException(String message) {
        super(message);
    }
}