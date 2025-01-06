package view;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton processButton;
    private JButton addButton;
    private JButton exitButton;

    public ButtonPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Create buttons
        processButton = createButton("Process Next Customer");
        addButton = createButton("Add New Customer");
        exitButton = createButton("Exit");

        // Add buttons to the panel
        add(processButton);
        add(addButton);
        add(exitButton);
    }

    // Helper method to create styled buttons
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); // Steel Blue
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button.setPreferredSize(new Dimension(200, 40));
        return button;
    }

    // Getters for buttons
    public JButton getProcessButton() {
        return processButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
