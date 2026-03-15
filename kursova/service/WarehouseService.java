package bg.tu_varna.sit.f24621686.warehouseproject.service;

import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;

import java.util.ArrayList;
import java.util.List;

public class WarehouseService {

    private List<WarehouseItem> items;

    public WarehouseService() {
        items = new ArrayList<>();
    }

    public void addItem(WarehouseItem item) {
        items.add(item);
    }

    public List<WarehouseItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}