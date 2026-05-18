package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RemoveCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private Scanner scanner;

    public RemoveCommand(CommandContext context, WarehouseService warehouseService, Scanner scanner) {
        this.context = context;
        this.warehouseService = warehouseService;
        this.scanner = scanner;
    }

    public void execute() {
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

        if (quantityToRemove <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

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
            public int compare(WarehouseItem first, WarehouseItem second) {
                return first.getExpirationDate().compareTo(second.getExpirationDate());
            }
        });

        double removedQuantity = 0;

        for (WarehouseItem item : matchingItems) {
            if (quantityToRemove <= 0) {
                break;
            }

            if (item.getQuantity() <= quantityToRemove) {
                quantityToRemove = quantityToRemove - item.getQuantity();
                removedQuantity = removedQuantity + item.getQuantity();
                item.setQuantity(0);
            } else {
                item.setQuantity(item.getQuantity() - quantityToRemove);
                removedQuantity = removedQuantity + quantityToRemove;
                quantityToRemove = 0;
            }
        }

        removeEmptyItems();

        System.out.println("Removed quantity: " + removedQuantity);

        if (quantityToRemove > 0) {
            System.out.println("Not enough quantity in warehouse.");
        }
    }

    private void removeEmptyItems() {
        for (int i = warehouseService.getItems().size() - 1; i >= 0; i--) {
            if (warehouseService.getItems().get(i).getQuantity() <= 0) {
                warehouseService.getItems().remove(i);
            }
        }
    }
}