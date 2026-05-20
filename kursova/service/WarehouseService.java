package bg.tu_varna.sit.f24621686.warehouseproject.service;

import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores and manages warehouse items during program execution.
 */
public class WarehouseService {

    private List<WarehouseItem> items;

    /**
     * Creates an empty warehouse service.
     */
    public WarehouseService() {
        items = new ArrayList<>();
    }

    /**
     * Adds a new item to the warehouse.
     *
     * @param item warehouse item
     */
    public void addItem(WarehouseItem item) {
        items.add(item);
    }

    /**
     * Gets all warehouse items.
     *
     * @return list of warehouse items
     */
    public List<WarehouseItem> getItems() {
        return items;
    }

    /**
     * Replaces the current warehouse items with a new list.
     *
     * @param items new list of warehouse items
     */
    public void setItems(List<WarehouseItem> items) {
        this.items = items;
    }

    /**
     * Checks if the warehouse is empty.
     *
     * @return true if there are no items
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}