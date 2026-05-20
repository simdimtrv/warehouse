package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

public class OpenCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;

    public OpenCommand(CommandContext context,
                       WarehouseService warehouseService,
                       FileService fileService) {

        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }

    public void execute(String input) {

        try {

            if (context.isFileOpened()) {
                System.out.println("A file is already opened.");
                return;
            }

            String fileName = input.substring(5).trim();

            if (fileName.isEmpty()) {
                System.out.println("Please enter file name.");
                return;
            }

            warehouseService.setItems(
                    fileService.loadFromFile(fileName)
            );

            context.setFileOpened(true);
            context.setCurrentFileName(fileName);

            System.out.println("File opened successfully.");

        } catch (WarehouseFileException e) {
            System.out.println(e.getMessage());
        }
    }
}