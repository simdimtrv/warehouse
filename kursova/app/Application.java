package bg.tu_varna.sit.f24621686.warehouseproject.app;

import bg.tu_varna.sit.f24621686.warehouseproject.command.CommandProcessor;
import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.util.Scanner;


/**
 * Main application class.
 * It starts the console loop and sends user input to the command processor.
 */
public class Application {

    private CommandContext context;
    private Scanner scanner;
    private CommandProcessor commandProcessor;


    /**
     * Creates the application and initializes the needed services.
     */
    public Application() {
        context = new CommandContext();
        scanner = new Scanner(System.in);

        WarehouseService warehouseService = new WarehouseService();
        FileService fileService = new FileService();

        commandProcessor = new CommandProcessor(
                context,
                warehouseService,
                fileService,
                scanner
        );
    }


    /**
     * Starts the console application.
     * The method reads commands until the user exits the program.
     */
    public void start() {
        System.out.println("Warehouse Management System");
        System.out.println("Type 'help' to see available commands.");

        while (context.isRunning()) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            commandProcessor.process(input);
        }
    }
}