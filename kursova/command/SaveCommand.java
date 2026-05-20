package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.FileNotOpenedException;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;


/**
 * Saves current warehouse data.
 */
public class SaveCommand implements Command {

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;

    /**
     * Creates SaveCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     * @param fileService file manager
     */
    public SaveCommand(CommandContext context,
                       WarehouseService warehouseService,
                       FileService fileService) {

        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }

    /**
     * Saves current warehouse file.
     */
    @Override
    public void execute() {

        try {

            if (!context.isFileOpened()) {
                throw new FileNotOpenedException("No file is opened.");
            }

            fileService.saveToFile(
                    context.getCurrentFileName(),
                    warehouseService.getItems()
            );

            System.out.println("File saved successfully.");

        } catch (FileNotOpenedException e) {
            System.out.println(e.getMessage());

        } catch (WarehouseFileException e) {
            System.out.println(e.getMessage());
        }
    }
}