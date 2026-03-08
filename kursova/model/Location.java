package bg.tu_varna.sit.f24621686.warehouseproject.model;

public class Location {

    private String section;
    private int shelf;

    public Location() {
    }

    public Location(String section, int shelf) {
        this.section = section;
        this.shelf = shelf;
    }

    public String getSection() {
        return section;
    }

    public int getShelf() {
        return shelf;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
}