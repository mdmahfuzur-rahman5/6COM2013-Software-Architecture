package model;

import controller.ParcelController;
import utils.FileLoader;
import view.MainWindow;

import javax.swing.*;

public class Manager {
    private CustomerQueue customerQueue;
    private ParcelStorage parcelStorage;
    private Worker worker;
    private Log log;

    public Manager() {
        // Initialize models
        customerQueue = new CustomerQueue();
        parcelStorage = new ParcelStorage();
        worker = new Worker();
        log = Log.getInstance();

        // Load data using the updated file loader with ClassLoader
        loadCustomerData("data/customers.txt");
        loadParcelData("data/parcels.txt");

        // Launch GUI
        initializeGUI();
    }

    // Updated to use resource path loading
    private void loadCustomerData(String filePath) {
        FileLoader.loadCustomers(filePath, customerQueue, log);
    }

    private void loadParcelData(String filePath) {
        FileLoader.loadParcels(filePath, parcelStorage, log);
    }

    // GUI Initialization
    private void initializeGUI() {
        SwingUtilities.invokeLater(() -> {
            MainWindow view = new MainWindow();
            new ParcelController(view, customerQueue, parcelStorage, worker, log);
            view.setVisible(true);
        });
    }

    public static void main(String[] args) {
        // Apply Nimbus Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Nimbus Look and Feel not available.");
        }

        // Start application
        new Manager();
    }
}
