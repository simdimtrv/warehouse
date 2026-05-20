package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.exception.InvalidCommandException;

/**
 * Represents all supported commands.
 */
public enum CommandType {
    OPEN,
    CLOSE,
    SAVE,
    SAVE_AS,
    HELP,
    EXIT,
    ADD,
    PRINT,
    REMOVE,
    CLEAN,
    LOG;

    /**
     * Converts user input into command type.
     *
     * @param input command input
     * @return command type
     * @throws InvalidCommandException if command is unknown
     */
    public static CommandType fromInput(String input) throws InvalidCommandException {
        if (input.equalsIgnoreCase("help")) {
            return HELP;
        }

        if (input.equalsIgnoreCase("exit")) {
            return EXIT;
        }

        if (input.startsWith("open ")) {
            return OPEN;
        }

        if (input.equalsIgnoreCase("close")) {
            return CLOSE;
        }

        if (input.equalsIgnoreCase("save")) {
            return SAVE;
        }

        if (input.startsWith("saveas ")) {
            return SAVE_AS;
        }

        if (input.equalsIgnoreCase("add")) {
            return ADD;
        }

        if (input.equalsIgnoreCase("print")) {
            return PRINT;
        }

        if (input.equalsIgnoreCase("remove")) {
            return REMOVE;
        }

        if (input.equalsIgnoreCase("clean")) {
            return CLEAN;
        }

        if (input.startsWith("log ")) {
            return LOG;
        }

        throw new InvalidCommandException("Unknown command.");
    }
}