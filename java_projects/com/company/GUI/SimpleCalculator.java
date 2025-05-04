package com.company.GUI;

// Import necessary Swing and AWT classes
import javax.swing.*;        // For GUI components like JFrame, JButton, JLabel, etc.
import java.awt.*;           // For layouts like GridLayout
import java.awt.event.*;     // For handling user actions like button clicks

// Main class
public class SimpleCalculator {

    // Main method - this is where the program starts
    public static void main(String[] args) {

        // Create a new window (JFrame) and set its title
        JFrame frame = new JFrame("Simple Calculator");

        // Set the size of the window: width=300 pixels, height=200 pixels
        frame.setSize(300, 200);

        // Ensure the program exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold all the components (text fields, labels, button)
        JPanel panel = new JPanel();

        // Set the layout manager to GridLayout (4 rows, 2 columns, 10px gaps)
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Create a label for the first number
        JLabel label1 = new JLabel("Number 1:");

        // Create a text field where the user can type the first number
        JTextField text1 = new JTextField();

        // Create a label for the second number
        JLabel label2 = new JLabel("Number 2:");

        // Create a text field for the second number
        JTextField text2 = new JTextField();

        // Create a button labeled "Add"
        JButton addButton = new JButton("Add");

        // Create an empty label just to fill space in the grid layout
        JLabel filler = new JLabel("");



        /*
        class MyButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                // what to do when clicked
            }
        }

        addButton.addActionListener(new MyButtonListener());

         */


        // Add a "listener" to the button - this runs when the button is clicked
        addButton.addActionListener(new ActionListener() {
            // This is the method that runs when the button is clicked
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    // Get the text from both text fields and convert to numbers
                    double num1 = Double.parseDouble(text1.getText());
                    double num2 = Double.parseDouble(text2.getText());

                    // Add the two numbers
                    double sum = num1 + num2;

                    // Show the result in a popup dialog
                    JOptionPane.showMessageDialog(frame, "Sum: " + sum);
                } catch (NumberFormatException ex) {
                    // If the user entered something that isn't a number
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");

                    // Check these out toString() is called internally
                    /*
                        JOptionPane.showMessageDialog(null, 3.14159);
                        JOptionPane.showMessageDialog(null, true);
                        JOptionPane.showMessageDialog(null, new JLabel("I am a JLabel!"));
                     */
                }
            }
        });

        // Add all the components to the panel in the order they appear in the grid
        panel.add(label1);  // Row 1, Col 1
        panel.add(text1);   // Row 1, Col 2

        panel.add(label2);  // Row 2, Col 1
        panel.add(text2);   // Row 2, Col 2

        panel.add(filler);      // Row 3, Col 1 (just empty space)
        panel.add(addButton);   // Row 3, Col 2 (the button)

        // Add the panel to the main frame (window)
        frame.add(panel);

        // Make the window visible
        frame.setVisible(true);
    }
}
