package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.InvalidCommandException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.util.Scanner;

/**
 * Processes user commands and executes the correct command object.
 */
public class CommandProcessor {

    private HelpCommand helpCommand;
    private ExitCommand exitCommand;
    private OpenCommand openCommand;
    private CloseCommand closeCommand;
    private SaveCommand saveCommand;
    private SaveAsCommand saveAsCommand;
    private AddCommand addCommand;
    private PrintCommand printCommand;
    private RemoveCommand removeCommand;
    private CleanCommand cleanCommand;
    private LogCommand logCommand;

    /**
     * Creates command processor and initializes all commands.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     * @param fileService file manager
     * @param scanner console scanner
     */
    public CommandProcessor(CommandContext context,
                            WarehouseService warehouseService,
                            FileService fileService,
                            Scanner scanner) {

        helpCommand = new HelpCommand();
        exitCommand = new ExitCommand(context);
        openCommand = new OpenCommand(context, warehouseService, fileService);
        closeCommand = new CloseCommand(context, warehouseService);
        saveCommand = new SaveCommand(context, warehouseService, fileService);
        saveAsCommand = new SaveAsCommand(context, warehouseService, fileService);
        addCommand = new AddCommand(context, warehouseService, scanner);
        printCommand = new PrintCommand(context, warehouseService);
        removeCommand = new RemoveCommand(context, warehouseService, scanner);
        cleanCommand = new CleanCommand(context, warehouseService);
        logCommand = new LogCommand(context, warehouseService);
    }

    /**
     * Processes user input and executes a command.
     *
     * @param input user input command
     */
    public void process(String input) {

        try {

            if (input.isEmpty()) {
                System.out.println("Please enter a command.");
                return;
            }

            CommandType commandType = CommandType.fromInput(input);

            if (commandType == CommandType.HELP) {
                helpCommand.execute();
            }

            else if (commandType == CommandType.EXIT) {
                exitCommand.execute();
            }

            else if (commandType == CommandType.OPEN) {
                openCommand.execute(input);
            }

            else if (commandType == CommandType.CLOSE) {
                closeCommand.execute();
            }

            else if (commandType == CommandType.SAVE) {
                saveCommand.execute();
            }

            else if (commandType == CommandType.SAVE_AS) {
                saveAsCommand.execute(input);
            }

            else if (commandType == CommandType.ADD) {
                addCommand.execute();
            }

            else if (commandType == CommandType.PRINT) {
                printCommand.execute();
            }

            else if (commandType == CommandType.REMOVE) {
                removeCommand.execute();
            }

            else if (commandType == CommandType.CLEAN) {
                cleanCommand.execute();
            }

            else if (commandType == CommandType.LOG) {
                logCommand.execute(input);
            }

        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}