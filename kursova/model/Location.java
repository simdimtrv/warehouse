package bg.tu_varna.sit.f24621686.warehouseproject.model;

/**
 * Represents product location in the warehouse.
 */
public class Location {

    private String section;
    private int shelf;


    /**
     * Creates an empty location.
     */
    public Location() {
    }


    /**
     * Creates a location with section and shelf.
     *
     * @param section warehouse section
     * @param shelf shelf number
     */
    public Location(String section, int shelf) {
        this.section = section;
        this.shelf = shelf;
    }

    /**
     * Gets warehouse section.
     *
     * @return section name
     */

    public String getSection() {
        return section;
    }

    /**
     * Gets shelf number.
     *
     * @return shelf number
     */
    public int getShelf() {
        return shelf;
    }

    /**
     * Sets warehouse section.
     *
     * @param section section name
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Sets shelf number.
     *
     * @param shelf shelf number
     */
    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
}
