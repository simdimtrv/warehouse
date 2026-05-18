package bg.tu_varna.sit.f24621686.warehouseproject.app;

import bg.tu_varna.sit.f24621686.warehouseproject.command.*;
import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.util.Scanner;

public class Application {
    private CommandContext context;
    private Scanner scanner;

    private WarehouseService warehouseService;
    private FileService fileService;

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

    public Application() {
        context = new CommandContext();
        scanner = new Scanner(System.in);

        warehouseService = new WarehouseService();
        fileService = new FileService();

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

    public void start() {
        System.out.println("Warehouse Management System");
        System.out.println("Type 'help' to see available commands.");
        while (context.isRunning()) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("help")) {
                helpCommand.execute();
            } else if (input.equalsIgnoreCase("exit")) {
                exitCommand.execute();
            } else if (input.startsWith("open ")) {
                openCommand.execute(input);
            } else if (input.equalsIgnoreCase("close")) {
                closeCommand.execute();
            } else if (input.equalsIgnoreCase("save")) {
                saveCommand.execute();
            } else if (input.startsWith("saveas ")) {
                saveAsCommand.execute(input);
            } else if (input.equalsIgnoreCase("add")) {
                addCommand.execute();
            } else if (input.equalsIgnoreCase("print")) {
                printCommand.execute();
            } else if (input.equalsIgnoreCase("remove")) {
                removeCommand.execute();
            } else if (input.equalsIgnoreCase("clean")) {
                cleanCommand.execute();
            } else if (input.startsWith("log ")) {
                logCommand.execute(input);
            } else if (input.isEmpty()) {
                System.out.println("Please enter a command.");
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}