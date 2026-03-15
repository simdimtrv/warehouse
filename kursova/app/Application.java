package bg.tu_varna.sit.f24621686.warehouseproject.app;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;

import java.time.LocalDate;

import java.util.Scanner;

public class Application {

    private CommandContext context;
    private Scanner scanner;

    public Application() {
        context = new CommandContext();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("Warehouse Management System");
        System.out.println("Type 'help' to see available commands.");

        while (context.isRunning()) {

            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("help")) {
                printHelp();
            }

            else if (input.equalsIgnoreCase("exit")) {
                context.setRunning(false);
                System.out.println("Program closed.");
            }

            else if (input.startsWith("open ")) {
                openFile(input);
            }

            else if (input.equalsIgnoreCase("close")) {
                closeFile();
            }

            else if (input.equalsIgnoreCase("save")) {
                saveFile();
            }

            else if (input.startsWith("saveas ")) {
                saveAsFile(input);
            }

            else if (input.isEmpty()) {
                System.out.println("Please enter a command.");
            }

            else {
                System.out.println("Unknown command.");
            }
        }
    }

    private void printHelp() {

        System.out.println("Supported commands:");
        System.out.println("open <file>   - opens a file");
        System.out.println("close         - closes the current file");
        System.out.println("save          - saves the current file");
        System.out.println("saveas <file> - saves the file under a new name");
        System.out.println("help          - shows this information");
        System.out.println("exit          - exits the program");
    }

    private void openFile(String input) {

        if (context.isFileOpened()) {
            System.out.println("A file is already opened. Please close it first.");
            return;
        }

        String fileName = input.substring(5);

        context.setFileOpened(true);
        context.setCurrentFileName(fileName);

        System.out.println("File " + fileName + " opened successfully.");
    }

    private void closeFile() {

        if (!context.isFileOpened()) {
            System.out.println("No file is currently opened.");
            return;
        }

        context.setFileOpened(false);
        context.setCurrentFileName(null);

        System.out.println("File closed.");
    }

    private void saveFile() {

        if (!context.isFileOpened()) {
            System.out.println("No file is opened.");
            return;
        }

        System.out.println("File saved: " + context.getCurrentFileName());
    }

    private void saveAsFile(String input) {

        if (!context.isFileOpened()) {
            System.out.println("No file is opened.");
            return;
        }

        String newFileName = input.substring(7);

        context.setCurrentFileName(newFileName);

        System.out.println("File saved as: " + newFileName);
    }
}