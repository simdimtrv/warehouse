package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;

/**
 * Stops the application.
 */
public class ExitCommand implements Command {

    private CommandContext context;

    /**
     * Creates ExitCommand object.
     *
     * @param context application state
     */
    public ExitCommand(CommandContext context) {
        this.context = context;
    }

    /**
     * Stops program execution.
     */
    @Override
    public void execute() {
        context.setRunning(false);

        System.out.println("Program closed.");
    }
}