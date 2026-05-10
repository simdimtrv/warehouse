package bg.tu_varna.sit.f24621686.warehouseproject.app;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import java.time.LocalDate;

import java.util.Iterator;
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
            else if (input.equalsIgnoreCase("remove")) {
                removeItem();
            }

            else if (input.equalsIgnoreCase("clean")) {
                cleanExpiredItems();
            }

            else if (input.startsWith("log ")) {
                showLog(input);
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
        System.out.println("remove        - removes quantity from a product");
        System.out.println("clean         - removes expired products");
        System.out.println("log <from> <to> - shows products added in period");
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

    private void removeItem() {

        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        if (warehouseService.isEmpty()) {
            System.out.println("Warehouse is empty.");
            return;
        }

        System.out.print("Product name: ");
        String productName = scanner.nextLine();

        System.out.print("Quantity to remove: ");
        double quantityToRemove = Double.parseDouble(scanner.nextLine());

        List<WarehouseItem> matchingItems = new ArrayList<>();

        for (WarehouseItem item : warehouseService.getItems()) {

            if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                matchingItems.add(item);
            }
        }

        if (matchingItems.isEmpty()) {
            System.out.println("Product not found.");
            return;
        }

        Collections.sort(matchingItems, new Comparator<WarehouseItem>() {
            @Override
            public int compare(WarehouseItem o1, WarehouseItem o2) {
                return o1.getExpirationDate().compareTo(o2.getExpirationDate());
            }
        });

        double removed = 0;

        for (WarehouseItem item : matchingItems) {

            if (quantityToRemove <= 0) {
                break;
            }

            if (item.getQuantity() <= quantityToRemove) {

                quantityToRemove -= item.getQuantity();
                removed += item.getQuantity();
                item.setQuantity(0);
            }

            else {

                item.setQuantity(item.getQuantity() - quantityToRemove);
                removed += quantityToRemove;
                quantityToRemove = 0;
            }
        }

        warehouseService.getItems().removeIf(item -> item.getQuantity() <= 0);

        System.out.println("Removed quantity: " + removed);

        if (quantityToRemove > 0) {
            System.out.println("Not enough quantity in warehouse.");
        }

    }

    private void cleanExpiredItems() {

        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        LocalDate today = LocalDate.now();

        int removedCount = 0;

        Iterator<WarehouseItem> iterator = warehouseService.getItems().iterator();

        while (iterator.hasNext()) {

            WarehouseItem item = iterator.next();

            if (item.getExpirationDate().isBefore(today)) {

                System.out.println(
                        "Removed expired product: "
                                + item.getProduct().getName()
                );

                iterator.remove();
                removedCount++;
            }
        }

        if (removedCount == 0) {
            System.out.println("No expired products found.");
        }
    }

    private void showLog(String input) {

        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            System.out.println("Invalid command format.");
            return;
        }

        LocalDate fromDate = LocalDate.parse(parts[1]);
        LocalDate toDate = LocalDate.parse(parts[2]);

        boolean found = false;

        for (WarehouseItem item : warehouseService.getItems()) {

            if ((item.getEntryDate().isEqual(fromDate)
                    || item.getEntryDate().isAfter(fromDate))
                    &&
                    (item.getEntryDate().isEqual(toDate)
                            || item.getEntryDate().isBefore(toDate))) {

                System.out.println(
                        item.getProduct().getName()
                                + " | qty: "
                                + item.getQuantity()
                                + " | entry: "
                                + item.getEntryDate()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in this period.");
        }
    }
}
