package bg.tu_varna.sit.f24621686.warehouseproject.core;

public class CommandContext {

    private boolean fileOpened;
    private String currentFileName;

    public CommandContext() {
        fileOpened = false;
        currentFileName = null;
    }

    public boolean isFileOpened() {
        return fileOpened;
    }

    public void setFileOpened(boolean fileOpened) {
        this.fileOpened = fileOpened;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }
}