package bg.tu_varna.sit.f24621686.warehouseproject.model;

public class Product {

    private String name;
    private String manufacturer;
    private String unit;

    public Product() {
    }

    public Product(String name, String manufacturer, String unit) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}