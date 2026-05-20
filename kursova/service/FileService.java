package bg.tu_varna.sit.f24621686.warehouseproject.service;

import bg.tu_varna.sit.f24621686.warehouseproject.exception.WarehouseFileException;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Location;
import bg.tu_varna.sit.f24621686.warehouseproject.model.Product;
import bg.tu_varna.sit.f24621686.warehouseproject.model.WarehouseItem;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles file operations for warehouse data.
 * It creates, loads and saves warehouse files.
 */
public class FileService {

    private static final String FOLDER = "data/";

    /**
     * Creates the data folder if it does not exist.
     */
    public FileService() {
        File directory = new File(FOLDER);

        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    /**
     * Creates a file in the data folder if it does not exist.
     *
     * @param fileName name of the file
     * @throws WarehouseFileException if file cannot be created
     */
    public void createFile(String fileName) throws WarehouseFileException {

        try {

            File file = new File(FOLDER + fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            throw new WarehouseFileException(
                    "Error while creating file."
            );
        }
    }

    /**
     * Saves all warehouse items to a text file.
     *
     * @param fileName name of the file
     * @param items warehouse items to save
     * @throws WarehouseFileException if saving fails
     */
    public void saveToFile(String fileName,
                           List<WarehouseItem> items)
            throws WarehouseFileException {

        try {

            File file = new File(FOLDER + fileName);

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file)
                    );

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

    /**
     * Loads warehouse items from a text file.
     *
     * @param fileName name of the file
     * @return list of loaded warehouse items
     * @throws WarehouseFileException if loading fails
     */
    public List<WarehouseItem> loadFromFile(String fileName)
            throws WarehouseFileException {

        List<WarehouseItem> items = new ArrayList<>();

        try {

            File file = new File(FOLDER + fileName);

            if (!file.exists()) {
                return items;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                if (data.length != 8) {
                    continue;
                }

                Product product =
                        new Product(
                                data[0],
                                data[1],
                                data[2]
                        );

                double quantity =
                        Double.parseDouble(data[3]);

                LocalDate entryDate =
                        LocalDate.parse(data[4]);

                LocalDate expirationDate =
                        LocalDate.parse(data[5]);

                Location location =
                        new Location(
                                data[6],
                                Integer.parseInt(data[7])
                        );

                WarehouseItem item =
                        new WarehouseItem(
                                product,
                                quantity,
                                entryDate,
                                expirationDate,
                                location
                        );

                items.add(item);
            }

            reader.close();

        } catch (Exception e) {

            throw new WarehouseFileException(
                    "Error while loading file."
            );
        }

        return items;
    }
}