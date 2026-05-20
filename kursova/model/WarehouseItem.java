package bg.tu_varna.sit.f24621686.warehouseproject.model;

import java.time.LocalDate;


/**
 * Represents one product batch stored in the warehouse.
 */
public class WarehouseItem {

    private Product product;
    private double quantity;
    private LocalDate entryDate;
    private LocalDate expirationDate;
    private Location location;

    /**
     * Creates an empty warehouse item.
     */
    public WarehouseItem() {
    }


    /**
     * Creates a warehouse item with all needed information.
     *
     * @param product product information
     * @param quantity product quantity
     * @param entryDate date when product entered the warehouse
     * @param expirationDate product expiration date
     * @param location warehouse location
     */
    public WarehouseItem(Product product, double quantity,
                         LocalDate entryDate,
                         LocalDate expirationDate,
                         Location location) {

        this.product = product;
        this.quantity = quantity;
        this.entryDate = entryDate;
        this.expirationDate = expirationDate;
        this.location = location;
    }

    /**
     * Gets product information.
     *
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Gets product quantity.
     *
     * @return quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Gets product entry date.
     *
     * @return entry date
     */
    public LocalDate getEntryDate() {
        return entryDate;
    }

    /**
     * Gets product expiration date.
     *
     * @return expiration date
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Gets product warehouse location.
     *
     * @return location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets product information.
     *
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets product quantity.
     *
     * @param quantity quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    /**
     * Sets product entry date.
     *
     * @param entryDate entry date
     */
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * Sets product expiration date.
     *
     * @param expirationDate expiration date
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    /**
     * Sets product location.
     *
     * @param location warehouse location
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}