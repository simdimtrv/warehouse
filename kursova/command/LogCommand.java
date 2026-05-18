package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

import java.time.LocalDate;

public class LogCommand {

    private CommandContext context;
    private WarehouseService warehouseService;

    public LogCommand(CommandContext context, WarehouseService warehouseService) {
        this.context = context;
        this.warehouseService = warehouseService;
    }

    public void execute(String input) {
        if (!context.isFileOpened()) {
            System.out.println("Please open a file first.");
            return;
        }

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            System.out.println("Invalid command format. Use: log <from> <to>");
            return;
        }

        LocalDate fromDate = LocalDate.parse(parts[1]);
        LocalDate toDate = LocalDate.parse(parts[2]);

        boolean found = false;

        for (WarehouseItem item : warehouseService.getItems()) {
            boolean afterOrEqualFrom = item.getEntryDate().isEqual(fromDate)
                    || item.getEntryDate().isAfter(fromDate);

            boolean beforeOrEqualTo = item.getEntryDate().isEqual(toDate)
                    || item.getEntryDate().isBefore(toDate);

            if (afterOrEqualFrom && beforeOrEqualTo) {
                System.out.println(
                        item.getProduct().getName()
                                + " | quantity: " + item.getQuantity()
                                + " | entry date: " + item.getEntryDate()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in this period.");
        }
    }
}