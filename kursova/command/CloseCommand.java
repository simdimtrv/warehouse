package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

/**
 * Closes currently opened file.
 */
public class CloseCommand implements Command {

    private CommandContext context;
    private WarehouseService warehouseService;

    /**
     * Creates CloseCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     */
    public CloseCommand(CommandContext context, WarehouseService warehouseService) {
        this.context = context;
        this.warehouseService = warehouseService;
    }

    /**
     * Closes currently opened file.
     */
    @Override
    public void execute() {
        if (!context.isFileOpened()) {
            System.out.println("No file is currently opened.");
            return;
        }

        warehouseService.getItems().clear();

        context.setFileOpened(false);
        context.setCurrentFileName(null);

        System.out.println("File closed.");
    }
}