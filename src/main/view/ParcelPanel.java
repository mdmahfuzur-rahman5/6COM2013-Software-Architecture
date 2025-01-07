package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ParcelPanel extends JPanel {
    private JTextArea parcelArea;

    public ParcelPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Available Parcels"));

        // Text Area for displaying parcel list
        parcelArea = new JTextArea(20, 30);
        parcelArea.setEditable(false);
        parcelArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Scroll pane for handling long lists
        JScrollPane scrollPane = new JScrollPane(parcelArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Update the parcel list dynamically
    public void updateParcels(List<String> parcels) {
        StringBuilder builder = new StringBuilder();
        for (String parcel : parcels) {
            builder.append(parcel).append("\n");
        }
        parcelArea.setText(builder.toString());
    }
}
