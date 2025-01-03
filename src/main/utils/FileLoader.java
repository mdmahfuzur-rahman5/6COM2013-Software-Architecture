package utils;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileLoader {

    /**
     * Loads customers from the specified file path.
     *
     * @param filePath       Relative file path within resources
     * @param customerQueue  Customer queue model
     * @param log            Log instance
     */
    public static void loadCustomers(String filePath, CustomerQueue customerQueue, Log log) {
        try (InputStream input = FileLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("File not found: " + filePath);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove extra spaces or tabs

                // Skip empty or invalid lines
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] parts = line.split("\\s+"); // Split by spaces or tabs

                // Ensure at least 3 parts are present
                if (parts.length < 3) {
                    log.addEntry("Invalid customer data: " + line);
                    System.err.println("Invalid customer data: " + line);
                    continue; // Skip invalid lines
                }

                // Process valid data
                String name = parts[0] + " " + parts[1]; // Combine first and last name
                String parcelId = parts[2];              // Parcel ID

                // Add customer to the queue
                customerQueue.addCustomer(new Customer(name, parcelId));
            }

            log.addEntry("Customer data loaded successfully.");
        } catch (IOException e) {
            log.addEntry("Error reading customers file: " + e.getMessage());
            System.err.println("Error reading customers file: " + e.getMessage());
        }
    }

    /**
     * Loads parcels from the specified file path.
     *
     * @param filePath       Relative file path within resources
     * @param parcelStorage  Parcel storage model
     * @param log            Log instance
     */
    public static void loadParcels(String filePath, ParcelStorage parcelStorage, Log log) {
        try (InputStream input = FileLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("File not found: " + filePath);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove extra spaces or tabs

                // Skip empty or invalid lines
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] parts = line.split("\\s+");

                // Ensure at least 2 parts are present
                if (parts.length < 2) {
                    log.addEntry("Invalid parcel data: " + line);
                    System.err.println("Invalid parcel data: " + line);
                    continue; // Skip invalid lines
                }

                // Process valid data
                String id = parts[0];
                double weight = Double.parseDouble(parts[1]);
                parcelStorage.addParcel(new Parcel(id, weight));
            }

            log.addEntry("Parcel data loaded successfully.");
        } catch (IOException e) {
            log.addEntry("Error reading parcels file: " + e.getMessage());
            System.err.println("Error reading parcels file: " + e.getMessage());
        }
    }
}
