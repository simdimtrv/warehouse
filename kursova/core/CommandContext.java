package bg.tu_varna.sit.f24621686.warehouseproject.core;

public class CommandContext {

    private boolean fileOpened;
    private String currentFileName;
    private boolean running;
    private boolean fileModified;

    public CommandContext() {
        fileOpened = false;
        currentFileName = null;
        running = true;
        fileModified = false;
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

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isFileModified() {
        return fileModified;
    }

    public void setFileModified(boolean fileModified) {
        this.fileModified = fileModified;
    }
}