package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.FileNotOpenedException;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.InvalidInputException;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 * Adds a new product batch to the warehouse.
 */
public class AddCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private Scanner scanner;

    /**
     * Creates AddCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     * @param scanner console scanner
     */
    public AddCommand(CommandContext context, WarehouseService warehouseService, Scanner scanner) {
        this.context = context;
        this.warehouseService = warehouseService;
        this.scanner = scanner;
    }

    /**
     * Reads product information from the console
     * and adds the product to the warehouse.
     */
    public void execute() {
        try {
            if (!context.isFileOpened()) {
                throw new FileNotOpenedException("Please open a file first.");
            }

            System.out.print("Product name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                throw new InvalidInputException("Product name cannot be empty.");
            }

            System.out.print("Manufacturer: ");
            String manufacturer = scanner.nextLine().trim();

            System.out.print("Unit (kg, pcs, etc): ");
            String unit = scanner.nextLine().trim();

            if (unit.isEmpty()) {
                throw new InvalidInputException("Unit cannot be empty.");
            }

            System.out.print("Quantity: ");
            double quantity = Double.parseDouble(scanner.nextLine());

            if (quantity <= 0) {
                throw new InvalidInputException("Quantity must be positive.");
            }

            System.out.print("Entry date (yyyy-mm-dd): ");
            LocalDate entryDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Expiration date (yyyy-mm-dd): ");
            LocalDate expirationDate = LocalDate.parse(scanner.nextLine());

            if (expirationDate.isBefore(entryDate)) {
                throw new InvalidInputException("Expiration date cannot be before entry date.");
            }

            System.out.print("Section: ");
            String section = scanner.nextLine().trim();

            if (section.isEmpty()) {
                throw new InvalidInputException("Section cannot be empty.");
            }

            System.out.print("Shelf number: ");
            int shelf = Integer.parseInt(scanner.nextLine());

            if (shelf <= 0) {
                throw new InvalidInputException("Shelf number must be positive.");
            }

            Product product = new Product(name, manufacturer, unit);
            Location location = new Location(section, shelf);
            WarehouseItem item = new WarehouseItem(product, quantity, entryDate, expirationDate, location);

            warehouseService.addItem(item);

            System.out.println("Product added successfully.");

        } catch (FileNotOpenedException | InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use yyyy-mm-dd.");
        }
    }
}