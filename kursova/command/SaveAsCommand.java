package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.FileNotOpenedException;
import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

public class SaveAsCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;

    public SaveAsCommand(CommandContext context,
                         WarehouseService warehouseService,
                         FileService fileService) {

        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }

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