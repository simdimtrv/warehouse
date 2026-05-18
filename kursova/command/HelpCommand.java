package bg.tu_varna.sit.f24621686.warehouseproject.command;

public class HelpCommand {

    public void execute() {

        System.out.println("Supported commands:");
        System.out.println("open <file>");
        System.out.println("close");
        System.out.println("save");
        System.out.println("saveas <file>");
        System.out.println("add");
        System.out.println("print");
        System.out.println("remove");
        System.out.println("clean");
        System.out.println("log <from> <to>");
        System.out.println("help");
        System.out.println("exit");
    }
}