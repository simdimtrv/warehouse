package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.FileNotOpenedException;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;


/**
 * Saves warehouse data with another file name.
 */
public class SaveAsCommand implements CommandWithInput {

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;

    /**
     * Creates SaveAsCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     * @param fileService file manager
     */
    public SaveAsCommand(CommandContext context,
                         WarehouseService warehouseService,
                         FileService fileService) {

        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }

    /**
     * Saves file with another name.
     *
     * @param input user command input
     */
    @Override
    public void execute(String input) {

        try {

            if (!context.isFileOpened()) {
                throw new FileNotOpenedException("No file is opened.");
            }

            String newFileName = input.substring(7).trim();

            if (newFileName.isEmpty()) {
                System.out.println("Please enter file name.");
                return;
            }

            fileService.saveToFile(
                    newFileName,
                    warehouseService.getItems()
            );

            context.setCurrentFileName(newFileName);

            System.out.println("File saved successfully.");

        } catch (FileNotOpenedException e) {
            System.out.println(e.getMessage());

        } catch (WarehouseFileException e) {
            System.out.println(e.getMessage());
        }
    }
}