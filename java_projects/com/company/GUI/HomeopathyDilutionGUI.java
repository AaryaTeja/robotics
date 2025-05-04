package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class HomeopathyDilutionGUI extends JFrame {
    private JTextField initialAmountField;
    private JTextField potencyField;
    private JLabel resultLabel;

    public HomeopathyDilutionGUI() {
        // Set up the frame
        setTitle("Homeopathic Dilution Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Create main panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Initial amount input
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Initial Amount (mL):"), gbc);

        gbc.gridx = 1;
        initialAmountField = new JTextField(10);
        panel.add(initialAmountField, gbc);

        // Potency input (e.g., 6C, 30C)
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Potency (e.g., 6C, 30C):"), gbc);

        gbc.gridx = 1;
        potencyField = new JTextField(10);
        panel.add(potencyField, gbc);

        // Calculate button
        JButton calculateButton = new JButton("Calculate Dilution");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        // Result display
        resultLabel = new JLabel("Enter values and click Calculate.");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        // Add panel to frame
        add(panel);

        // Button action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateDilution();
            }
        });
    }

    private void calculateDilution() {
        try {
            // Get inputs
            double initialAmount = Double.parseDouble(initialAmountField.getText());
            String potencyInput = potencyField.getText().toUpperCase().replace("C", "").trim();
            int potency = Integer.parseInt(potencyInput);

            // Homeopathic dilution: 1 part in 100, repeated 'potency' times
            double dilutionFactor = Math.pow(100, potency); // 100^potency
            double finalConcentration = initialAmount / dilutionFactor;

            // Format result
            DecimalFormat df = new DecimalFormat("#.##E0"); // Scientific notation
            String result = "Final concentration: " + df.format(finalConcentration) + " mL of original substance";

            // Check if it's beyond Avogadro's limit (roughly 12C-24C)
            if (potency > 12) {
                result += " (Likely no molecules remain)";
            }

            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Use numbers (e.g., 10 for amount, 6C for potency).");
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeopathyDilutionGUI().setVisible(true);
            }
        });
    }
}
