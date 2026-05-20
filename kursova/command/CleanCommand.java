package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.time.LocalDate;


/**
 * Removes expired products from the warehouse.
 */
public class CleanCommand implements Command {

    private CommandContext context;
    private WarehouseService warehouseService;

    /**
     * Creates CleanCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     */
    public CleanCommand(CommandContext context, WarehouseService warehouseService) {
        this.context = context;
        this.warehouseService = warehouseService;
    }

    /**
     * Removes all expired products.
     */
    @Override
    public void execute() {
        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        LocalDate today = LocalDate.now();
        int removedCount = 0;

        for (int i = warehouseService.getItems().size() - 1; i >= 0; i--) {
            WarehouseItem item = warehouseService.getItems().get(i);

            if (item.getExpirationDate().isBefore(today)) {
                System.out.println("Removed expired product: " + item.getProduct().getName());
                warehouseService.getItems().remove(i);
                removedCount++;
            }
        }

        if (removedCount == 0) {
            System.out.println("No expired products found.");
        }
    }
}