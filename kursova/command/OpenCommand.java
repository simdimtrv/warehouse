package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

/**
 * Opens a warehouse file and loads its content.
 */
public class OpenCommand implements CommandWithInput{

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;


    /**
     * Creates OpenCommand object.
     *
     * @param context current application state
     * @param warehouseService warehouse manager
     * @param fileService file manager
     */
    public OpenCommand(CommandContext context,
                       WarehouseService warehouseService,
                       FileService fileService) {

        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }


    /**
     * Opens selected file and loads data.
     *
     * @param input user command input
     */
    @Override
    public void execute(String input) {

        try {

            if (context.isFileOpened()) {
                System.out.println("A file is already opened.");
                return;
            }

            String fileName =
                    input.substring(5).trim();

            if (fileName.isEmpty()) {
                System.out.println("Please enter file name.");
                return;
            }

            fileService.createFile(fileName);

            warehouseService.setItems(
                    fileService.loadFromFile(fileName)
            );

            context.setFileOpened(true);
            context.setCurrentFileName(fileName);

            System.out.println(
                    "File opened successfully."
            );

        }

        catch (WarehouseFileException e) {
            System.out.println(e.getMessage());
        }
    }
}
