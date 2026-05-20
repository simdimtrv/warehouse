package bg.tu_varna.sit.f24621686.warehouseproject.core;




/**
 * Keeps the current state of the application.
 * It stores information about the opened file and whether the program is running.
 */
public class CommandContext {

    private boolean fileOpened;
    private String currentFileName;
    private boolean running;
    private boolean fileModified;


    /**
     * Creates a new command context with default values.
     */
    public CommandContext() {
        fileOpened = false;
        currentFileName = null;
        running = true;
        fileModified = false;
    }


    /**
     * Checks if a file is currently opened.
     *
     * @return true if a file is opened
     */
    public boolean isFileOpened() {
        return fileOpened;
    }


    /**
     * Changes file opened state.
     *
     * @param fileOpened file state
     */
    public void setFileOpened(boolean fileOpened) {
        this.fileOpened = fileOpened;
    }

    /**
     * Returns current file name.
     *
     * @return file name
     */
    public String getCurrentFileName() {
        return currentFileName;
    }

    /**
     * Sets current file name.
     *
     * @param currentFileName file name
     */
    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }

    /**
     * Checks if application is running.
     *
     * @return true if running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Changes application running state.
     *
     * @param running running state
     */
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