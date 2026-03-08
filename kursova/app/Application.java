package bg.tu_varna.sit.f24621686.warehouseproject.app;

import bg.tu_varna.sit.f24621686.warehouseproject.core.CommandContext;

public class Application {

    private CommandContext context;

    public Application() {
        context = new CommandContext();
    }

    public void start() {
        System.out.println("Warehouse Management System");
        System.out.println("Program started.");
    }

}