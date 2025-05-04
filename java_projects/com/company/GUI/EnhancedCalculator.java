package com.company.GUI;

import javax.swing.*;         // For GUI components
import java.awt.*;            // For layouts and colors
import java.awt.event.*;      // For button clicks and events

public class EnhancedCalculator {

    public static void main(String[] args) {
        // Create a new window (JFrame) with the title
        JFrame frame = new JFrame("Enhanced Calculator");

        // Set the size of the window
        frame.setSize(400, 300);

        // Close the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel to hold everything
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // 6 rows, 2 columns with spacing
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        // Create labels and text fields for input
        JLabel label1 = new JLabel("Number 1:");
        JTextField text1 = new JTextField();

        JLabel label2 = new JLabel("Number 2:");
        JTextField text2 = new JTextField();

        // Set color of text fields and labels for better appearance
        label1.setForeground(Color.RED);
        label2.setForeground(Color.DARK_GRAY);
        text1.setBackground(Color.WHITE);
        text2.setBackground(Color.WHITE);

        // Create radio buttons for operations
        JRadioButton addButton = new JRadioButton("Add");
        JRadioButton subButton = new JRadioButton("Subtract");
        JRadioButton mulButton = new JRadioButton("Multiply");
        JRadioButton divButton = new JRadioButton("Divide");

        // Group the radio buttons so only one can be selected
        ButtonGroup operations = new ButtonGroup();
        operations.add(addButton);
        operations.add(subButton);
        operations.add(mulButton);
        operations.add(divButton);

        // Set background color of radio buttons to match the panel
        addButton.setBackground(panel.getBackground());
        subButton.setBackground(panel.getBackground());
        mulButton.setBackground(panel.getBackground());
        divButton.setBackground(panel.getBackground());

        // Create the "Calculate" button
        JButton calcButton = new JButton("Calculate");
        calcButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        //calcButton.setForeground(Color.RED);              // White text
        calcButton.setForeground(new Color(100, 200, 150));

        // Add action listener to handle the button click
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Read the numbers from text fields
                    double num1 = Double.parseDouble(text1.getText());
                    double num2 = Double.parseDouble(text2.getText());
                    double result = 0;

                    // Check which operation was selected and compute result
                    if (addButton.isSelected()) {
                        result = num1 + num2;
                    } else if (subButton.isSelected()) {
                        result = num1 - num2;
                    } else if (mulButton.isSelected()) {
                        result = num1 * num2;
                    } else if (divButton.isSelected()) {
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
                            return;
                        }
                        result = num1 / num2;
                    } else {
                        // If no operation selected, show a warning
                        JOptionPane.showMessageDialog(frame, "Please select an operation.");
                        return;
                    }

                    // Display the result
                    JOptionPane.showMessageDialog(frame, "Result: " + result);

                } catch (NumberFormatException ex) {
                    // If the input is not a number, show an error
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        });

        // Add all components to the panel (row by row)
        panel.add(label1);
        panel.add(text1);

        panel.add(label2);
        panel.add(text2);

        panel.add(addButton);
        panel.add(subButton);

        panel.add(mulButton);
        panel.add(divButton);

        // Empty label for spacing
        panel.add(new JLabel(""));
        panel.add(calcButton);

        // Add the panel to the frame (main window)
        frame.add(panel);

        // Make the window visible
        frame.setVisible(true);
    }
}

