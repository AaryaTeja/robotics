package com.company.GUI;

import javax.swing.*;      // For GUI components like JFrame, JPanel, JButton, etc.
import java.awt.*;         // For layouts like BorderLayout, FlowLayout, etc.
import java.awt.event.*;    // For event handling (button clicks, etc.)
import java.io.*;           // For file reading and writing (File, BufferedReader, FileWriter)
import java.util.*;         // For handling collections like ArrayList

public class EnhancedTaskManager {

    // The filename to store tasks
    private static final String TASKS_FILE = "tasks.txt";

    public static void main(String[] args) {
        // Step 1: Create the main window (JFrame) for the application
        JFrame frame = new JFrame("Enhanced Task Manager");  // Set the window title
        frame.setSize(400, 400);  // Set window size to 400x400 pixels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the window is closed

        // Step 2: Create the main panel to hold the components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());  // Use BorderLayout to position components

        // Step 3: Create a DefaultListModel to hold the task data (model for the JList)
        DefaultListModel<String> taskListModel = new DefaultListModel<>();

        // Step 4: Create a JList to display tasks and make it scrollable
        JList<String> taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow selecting only one task at a time
        JScrollPane scrollPane = new JScrollPane(taskList);  // Make the JList scrollable if the list grows too large
        scrollPane.setPreferredSize(new Dimension(300, 200));  // Set the size of the scrollable area

        // Step 5: Create the input field and buttons for adding and deleting tasks
        JTextField taskInput = new JTextField();  // Input field for the new task
        taskInput.setPreferredSize(new Dimension(250, 30));  // Set input field size

        JButton addButton = new JButton("Add Task");  // Button to add a new task
        addButton.setBackground(new Color(60, 179, 113));  // Set the button color (green)
        addButton.setForeground(Color.RED);  // Set the button text color to white

        JButton deleteButton = new JButton("Delete Task");  // Button to delete the selected task
        deleteButton.setBackground(new Color(220, 20, 60));  // Set the button color (red)
        deleteButton.setForeground(Color.RED);  // Set the button text color to white

        // Step 6: Read tasks from the file and add them to the list
        loadTasks(taskListModel);

        // Step 7: Create action listeners for the buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();  // Get the text from the input field
                if (!task.isEmpty()) {  // If the input is not empty
                    taskListModel.addElement(task);  // Add the task to the list model
                    taskInput.setText("");  // Clear the input field after adding the task
                    saveTasks(taskListModel);  // Save tasks to file
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();  // Get the index of the selected task
                if (selectedIndex != -1) {  // If a task is selected
                    taskListModel.remove(selectedIndex);  // Remove the task from the list
                    saveTasks(taskListModel);  // Save the updated task list to the file
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Step 8: Arrange components on the panel using BorderLayout
        JPanel inputPanel = new JPanel(new FlowLayout());  // Panel for input field and Add Task button
        inputPanel.add(taskInput);  // Add the input field to the panel
        inputPanel.add(addButton);  // Add the 'Add Task' button to the panel

        JPanel bottomPanel = new JPanel(new FlowLayout());  // Panel for Delete Task button
        bottomPanel.add(deleteButton);  // Add the 'Delete Task' button to the panel

        // Step 9: Add components to the main panel using BorderLayout
        mainPanel.add(scrollPane, BorderLayout.CENTER);  // Add the scrollable task list to the center
        mainPanel.add(inputPanel, BorderLayout.NORTH);  // Add input panel (with task input and Add button) to the top
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);  // Add the bottom panel (with Delete button) to the bottom

        // Step 10: Set up the frame and display the GUI
        frame.add(mainPanel);  // Add the main panel to the frame
        frame.setVisible(true);  // Make the frame visible
    }

    // Method to load tasks from a file and add them to the JList model
    private static void loadTasks(DefaultListModel<String> taskListModel) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(TASKS_FILE));  // Open the file to read tasks
            String task;
            while ((task = reader.readLine()) != null) {  // Read each line (task) from the file
                taskListModel.addElement(task);  // Add the task to the task list
            }
            reader.close();  // Close the file reader after reading all tasks
        } catch (IOException e) {
            // If the file doesn't exist or there's an error, just print a message and return
            System.out.println("No saved tasks found, starting with an empty list.");
        }
    }

    // Method to save tasks to a file
    private static void saveTasks(DefaultListModel<String> taskListModel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(TASKS_FILE));  // Open the file to write tasks
            for (int i = 0; i < taskListModel.size(); i++) {  // Iterate over all tasks in the list model
                writer.write(taskListModel.getElementAt(i));  // Write each task to the file
                writer.newLine();  // Move to the next line in the file
            }
            writer.close();  // Close the file writer after saving all tasks
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving tasks to file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

