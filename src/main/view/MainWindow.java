package view;

import javax.swing.*;
import java.awt.*;

/**
 * MainWindow class for the GUI of the Parcel Processing System.
 */
public class MainWindow extends JFrame {
    private CustomerPanel customerPanel; // Panel to display customers in queue
    private ParcelPanel parcelPanel;     // Panel to display parcels
    private ButtonPanel buttonPanel;     // Panel with control buttons

    /**
     * Constructor initializes the main window and its components.
     */
    public MainWindow() {
        // Set title and window size
        setTitle("Parcel Processing System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Apply Nimbus Look and Feel for modern design
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

        // Initialize Panels
        customerPanel = new CustomerPanel();
        parcelPanel = new ParcelPanel();
        buttonPanel = new ButtonPanel();

        // Set Borders and Background Colors for Panels
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customers in Queue"));
        customerPanel.setBackground(new Color(240, 248, 255)); // Light Blue

        parcelPanel.setBorder(BorderFactory.createTitledBorder("Available Parcels"));
        parcelPanel.setBackground(new Color(255, 250, 205));   // Light Yellow

        buttonPanel.setBackground(new Color(230, 230, 250));   // Light Purple

        // Add Panels to Main Window
        add(customerPanel, BorderLayout.WEST);
        add(parcelPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    /**
     * Getter for the CustomerPanel.
     *
     * @return CustomerPanel instance
     */
    public CustomerPanel getCustomerPanel() {
        return customerPanel;
    }

    /**
     * Getter for the ParcelPanel.
     *
     * @return ParcelPanel instance
     */
    public ParcelPanel getParcelPanel() {
        return parcelPanel;
    }

    /**
     * Getter for the ButtonPanel.
     *
     * @return ButtonPanel instance
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
