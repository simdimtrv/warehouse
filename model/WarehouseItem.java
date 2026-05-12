package bg.tu_varna.sit.f24621686.warehouseproject.model;

import java.time.LocalDate;

public class WarehouseItem {

    private Product product;
    private double quantity;
    private LocalDate entryDate;
    private LocalDate expirationDate;
    private Location location;

    public WarehouseItem() {
    }

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

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}