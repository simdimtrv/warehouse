package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.time.LocalDate;
import java.util.Scanner;

public class AddCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private Scanner scanner;

    public AddCommand(CommandContext context, WarehouseService warehouseService, Scanner scanner) {
        this.context = context;
        this.warehouseService = warehouseService;
        this.scanner = scanner;
    }

    public void execute() {
        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        System.out.print("Product name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Unit (kg, pcs, etc): ");
        String unit = scanner.nextLine();

        System.out.print("Quantity: ");
        double quantity = Double.parseDouble(scanner.nextLine());

        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        System.out.print("Entry date (yyyy-mm-dd): ");
        LocalDate entryDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Expiration date (yyyy-mm-dd): ");
        LocalDate expirationDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Section: ");
        String section = scanner.nextLine();

        System.out.print("Shelf number: ");
        int shelf = Integer.parseInt(scanner.nextLine());

        Product product = new Product(name, manufacturer, unit);
        Location location = new Location(section, shelf);

        WarehouseItem item = new WarehouseItem(product, quantity, entryDate, expirationDate, location);

        warehouseService.addItem(item);

        System.out.println("Product added successfully.");
    }
}