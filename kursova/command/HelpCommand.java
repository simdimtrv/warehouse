package bg.tu_varna.sit.f24621686.warehouseproject.command;

/**
 * Displays all available commands.
 */
public class HelpCommand implements Command{

    /**
     * Displays command information.
     */
    @Override
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