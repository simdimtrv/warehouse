package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

/**
 * Reads product information from the console
 * and adds the product to the warehouse.
 */
public class PrintCommand implements Command{

    private CommandContext context;
    private WarehouseService warehouseService;

    /**
     * Creates PrintCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     */
    public PrintCommand(CommandContext context, WarehouseService warehouseService) {
        this.context = context;
        this.warehouseService = warehouseService;
    }

    /**
     * Prints warehouse information to the console.
     */
    @Override
    public void execute() {
        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        if (warehouseService.isEmpty()) {
            System.out.println("Warehouse is empty.");
            return;
        }

        System.out.println("Warehouse items:");

        for (WarehouseItem item : warehouseService.getItems()) {
            System.out.println(
                    item.getProduct().getName()
                            + " | manufacturer: " + item.getProduct().getManufacturer()
                            + " | unit: " + item.getProduct().getUnit()
                            + " | quantity: " + item.getQuantity()
                            + " | entry date: " + item.getEntryDate()
                            + " | expiration date: " + item.getExpirationDate()
                            + " | location: " + item.getLocation().getSection()
                            + " shelf " + item.getLocation().getShelf()
            );
        }
    }
}