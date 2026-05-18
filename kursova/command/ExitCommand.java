package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;

public class ExitCommand {

    private CommandContext context;

    public ExitCommand(CommandContext context) {
        this.context = context;
    }

    public void execute() {
        context.setRunning(false);

        System.out.println("Program closed.");
    }
}