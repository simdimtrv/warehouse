package bg.tu_varna.sit.f24621686.warehouseproject.model;

/**
 * Represents basic information about a product.
 */
public class Product {

    private String name;
    private String manufacturer;
    private String unit;

    /**
     * Creates an empty product.
     */
    public Product() {
    }

    /**
     * Creates a product with name, manufacturer and unit.
     *
     * @param name product name
     * @param manufacturer product manufacturer
     * @param unit measurement unit
     */
    public Product(String name, String manufacturer, String unit) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
    }

    /**
     * Gets product name.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets product manufacturer.
     *
     * @return manufacturer name
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets product unit.
     *
     * @return measurement unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets product name.
     *
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets product manufacturer.
     *
     * @param manufacturer manufacturer name
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Sets product unit.
     *
     * @param unit measurement unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}