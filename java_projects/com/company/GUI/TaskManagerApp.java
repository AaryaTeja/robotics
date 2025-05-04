package com.company.GUI;

import javax.swing.*;  // Import Swing components (JFrame, JButton, JList, etc.)
import java.awt.*;     // For layouts like BorderLayout, FlowLayout, etc.
import java.awt.event.*;  // For handling user actions (clicking buttons, menu items)

public class TaskManagerApp {

    public static void main(String[] args) {
        // Step 1: Create the main frame (window) for the app
        JFrame frame = new JFrame("Task Manager");  // Create a JFrame object with the title
        frame.setSize(400, 400);  // Set window size: 400x400 pixels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when window is closed

        // Step 2: Create the main panel to hold everything
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());  // Use BorderLayout to arrange components

        // Step 3: Create a DefaultListModel to hold task data (model for the JList)
        DefaultListModel<String> taskListModel = new DefaultListModel<>();

        // Step 4: Create a JList to display tasks
        JList<String> taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow only one item to be selected
        JScrollPane scrollPane = new JScrollPane(taskList);  // Add scroll functionality if the list grows too big
        scrollPane.setPreferredSize(new Dimension(300, 200));  // Set scroll pane size

        // Step 5: Create the input field and buttons
        JTextField taskInput = new JTextField();  // TextField for entering a new task
        taskInput.setPreferredSize(new Dimension(250, 30));  // Set the size of the input field

        JButton addButton = new JButton("Add Task");  // Button to add a new task
        //addButton.setBackground(new Color(60, 179, 113));  // Set button color to green
        addButton.setForeground(Color.RED);  // Set button text color to white

        JButton deleteButton = new JButton("Delete Task");  // Button to delete the selected task
        //deleteButton.setBackground(new Color(220, 20, 60));  // Set button color to red
        deleteButton.setForeground(Color.RED);  // Set button text color to white

        // Step 6: Create the menu bar
        JMenuBar menuBar = new JMenuBar();  // Create a menu bar
        JMenu fileMenu = new JMenu("File");  // Create a 'File' menu
        JMenuItem newTaskItem = new JMenuItem("New Task");  // 'New Task' menu item
        JMenuItem exitItem = new JMenuItem("Exit");  // 'Exit' menu item

        // Step 7: Set up the menu actions
        newTaskItem.addActionListener(new ActionListener() {  // When 'New Task' is clicked
            public void actionPerformed(ActionEvent e) {
                taskInput.setText("");  // Clear the task input field
                taskInput.requestFocus();  // Focus back to the task input field
            }
        });

        exitItem.addActionListener(new ActionListener() {  // When 'Exit' is clicked
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Close the application
            }
        });

        fileMenu.add(newTaskItem);  // Add 'New Task' item to 'File' menu
        fileMenu.add(exitItem);  // Add 'Exit' item to 'File' menu
        menuBar.add(fileMenu);  // Add 'File' menu to the menu bar

        // Step 8: Create the action listeners for buttons
        addButton.addActionListener(new ActionListener() {  // Add task when the 'Add Task' button is clicked
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();  // Get text from the input field
                if (!task.isEmpty()) {  // If the input is not empty
                    taskListModel.addElement(task);  // Add the task to the task list
                    taskInput.setText("");  // Clear the input field after adding the task
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task!", "Error", JOptionPane.ERROR_MESSAGE);  // Show error if task is empty
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {  // Delete selected task when the 'Delete Task' button is clicked
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();  // Get the index of the selected task
                if (selectedIndex != -1) {  // If a task is selected
                    taskListModel.remove(selectedIndex);  // Remove the selected task
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete!", "Error", JOptionPane.ERROR_MESSAGE);  // Show error if no task is selected
                }
            }
        });

        // Step 9: Arrange components on the panel
        JPanel inputPanel = new JPanel(new FlowLayout());  // Panel to hold the input field and 'Add Task' button
        inputPanel.add(taskInput);  // Add the task input field
        inputPanel.add(addButton);  // Add the 'Add Task' button

        JPanel bottomPanel = new JPanel(new FlowLayout());  // Panel to hold the 'Delete Task' button
        bottomPanel.add(deleteButton);  // Add the 'Delete Task' button

        // Step 10: Add components to the main panel using BorderLayout
        mainPanel.add(scrollPane, BorderLayout.CENTER);  // Add the scrollable task list to the center of the panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);  // Add the input panel to the top (North) of the main panel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);  // Add the bottom panel to the bottom (South) of the main panel

        // Step 11: Set up the frame and add components
        frame.setJMenuBar(menuBar);  // Add the menu bar to the frame
        frame.add(mainPanel);  // Add the main panel (which holds all components) to the frame
        frame.setVisible(true);  // Make the frame visible
    }
}

