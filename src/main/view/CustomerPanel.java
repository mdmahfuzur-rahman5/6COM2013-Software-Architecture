package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerPanel extends JPanel {
    private JTextArea customerArea;

    public CustomerPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Customers in Queue"));

        // Text Area for displaying customer list
        customerArea = new JTextArea(20, 20);
        customerArea.setEditable(false);
        customerArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Scroll pane for handling long lists
        JScrollPane scrollPane = new JScrollPane(customerArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Update the customer list dynamically
    public void updateCustomers(List<String> customers) {
        StringBuilder builder = new StringBuilder();
        for (String customer : customers) {
            builder.append(customer).append("\n");
        }
        customerArea.setText(builder.toString());
    }
}
