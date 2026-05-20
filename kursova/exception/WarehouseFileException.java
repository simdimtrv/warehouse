package bg.tu_varna.sit.f24621686.warehouseproject.exception;

/**
 * Thrown when file operations fail.
 */
public class WarehouseFileException extends Exception {

    /**
     * Creates an exception with a custom message.
     *
     * @param message error message
     */
    public WarehouseFileException(String message) {
        super(message);
    }
}