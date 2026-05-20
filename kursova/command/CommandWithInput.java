package bg.tu_varna.sit.f24621686.warehouseproject.command;

/**
 * Represents command with input parameters.
 */
public interface CommandWithInput {

    /**
     * Executes command.
     *
     * @param input user command input
     */
    void execute(String input);

}