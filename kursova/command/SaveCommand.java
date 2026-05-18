package bg.tu_varna.sit.f24621686.warehouseproject.command;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;
import bg.tu_varna.sit.f24621686.warehouseproject.service.FileService;
import bg.tu_varna.sit.f24621686.warehouseproject.service.WarehouseService;

public class SaveCommand {

    private CommandContext context;
    private WarehouseService warehouseService;
    private FileService fileService;

    public SaveCommand(CommandContext context, WarehouseService warehouseService, FileService fileService) {
        this.context = context;
        this.warehouseService = warehouseService;
        this.fileService = fileService;
    }

    public void execute() {
        if (!context.isFileOpened()) {
            System.out.println("No file is opened.");
            return;
        }

        fileService.saveToFile(context.getCurrentFileName(), warehouseService.getItems());

        System.out.println("File saved successfully.");
    }
}