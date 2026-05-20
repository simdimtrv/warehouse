package bg.tu_varna.sit.f24621686.warehouseproject.service;

import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public void saveToFile(String fileName, List<WarehouseItem> items) throws WarehouseFileException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (WarehouseItem item : items) {
                writer.write(
                        item.getProduct().getName() + ";" +
                                item.getProduct().getManufacturer() + ";" +
                                item.getProduct().getUnit() + ";" +
                                item.getQuantity() + ";" +
                                item.getEntryDate() + ";" +
                                item.getExpirationDate() + ";" +
                                item.getLocation().getSection() + ";" +
                                item.getLocation().getShelf()
                );
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new WarehouseFileException("Error while saving file.");
        }
    }
    public List<WarehouseItem> loadFromFile(String fileName) throws WarehouseFileException {
        List<WarehouseItem> items = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return items;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if (data.length != 8) {
                    continue;
                }
                Product product = new Product(data[0], data[1], data[2]);
                double quantity = Double.parseDouble(data[3]);
                LocalDate entryDate = LocalDate.parse(data[4]);
                LocalDate expirationDate = LocalDate.parse(data[5]);
                Location location = new Location(data[6], Integer.parseInt(data[7]));

                WarehouseItem item = new WarehouseItem(product, quantity, entryDate, expirationDate, location);
                items.add(item);
            }
            reader.close();

        } catch (Exception e) {
            throw new WarehouseFileException("Error while loading file.");
        }
        return items;
    }
}