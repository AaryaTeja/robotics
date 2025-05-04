package com.company.GUI;

import javax.swing.*;             // GUI components
import java.awt.*;                // Layouts and colors
import java.awt.event.*;         // Event handling

import javax.swing.*;             // Import Swing GUI components (JList, JFrame, etc.)
import java.awt.*;                // For layouts and colors (like FlowLayout)
import java.awt.event.*;         // For handling user actions (button clicks)

public class TodoListApp {

    public static void main(String[] args) {

        // Step 1: Create the main window (JFrame)
        JFrame frame = new JFrame("My To-Do List");  // Create a JFrame object with title
        frame.setSize(400, 400);  // Set window size: width 400px, height 400px
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when window is closed

        // Step 2: Create the main panel to hold everything inside the window
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());  // BorderLayout divides the space into 5 regions: North, South, Center, West, East

        // Step 3: Create the data model for the list
        // DefaultListModel holds the data for the JList (our tasks).
        // We are using a model of type String because each task will be a string.
        DefaultListModel<String> taskListModel = new DefaultListModel<>();

        // Step 4: Create the JList and link it to the model (taskListModel)
        JList<String> taskList = new JList<>(taskListModel);  // The JList displays tasks, which come from the taskListModel
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Only one task can be selected at a time
        taskList.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font for better readability

        // Step 5: Create a JScrollPane to add scrollbars to the JList (in case the list is long)
        JScrollPane scrollPane = new JScrollPane(taskList); // Wrap the taskList inside a JScrollPane
        scrollPane.setPreferredSize(new Dimension(300, 200)); // Set size of the scroll pane (controls list size)

        // Step 6: Create a text field for users to enter tasks
        JTextField taskInput = new JTextField();  // TextField for entering a new task
        taskInput.setPreferredSize(new Dimension(250, 30)); // Set the text field size

        // Step 7: Create buttons
        // "Add Task" button: Adds the entered task to the list
        JButton addButton = new JButton("Add Task");
        //addButton.setBackground(new Color(60, 179, 113)); // Green background for "Add Task"
        addButton.setForeground(Color.RED);  // White text color for the button

        // "Delete Task" button: Deletes the selected task from the list
        JButton deleteButton = new JButton("Delete Task");
        //deleteButton.setBackground(new Color(220, 20, 60)); // Red background for "Delete Task"
        deleteButton.setForeground(Color.BLUE);  // White text color for the button

        // Step 8: Create panels to arrange buttons and input field
        JPanel inputPanel = new JPanel(new FlowLayout());  // Create a FlowLayout for the input panel
        inputPanel.add(taskInput); // Add task input field to this panel
        inputPanel.add(addButton); // Add the "Add Task" button to this panel

        JPanel bottomPanel = new JPanel(new FlowLayout()); // Create another panel for the "Delete Task" button
        bottomPanel.add(deleteButton); // Add the "Delete Task" button to this panel

        // Step 9: Add components to the main panel using BorderLayout
        mainPanel.add(scrollPane, BorderLayout.CENTER);    // Center: Where the list of tasks is shown
        mainPanel.add(inputPanel, BorderLayout.NORTH);     // North: Where the input field and add button go
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);    // South: Where the delete button goes

        // Step 10: Add action listener to "Add Task" button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  // Triggered when button is clicked
                String task = taskInput.getText().trim();  // Get the text entered in the input field and remove extra spaces
                if (!task.isEmpty()) {  // If task is not empty
                    taskListModel.addElement(task);  // Add the task to the DefaultListModel (taskListModel)
                    taskInput.setText("");  // Clear the input field after adding the task
                } else {
                    // If the task is empty, show an error message
                    JOptionPane.showMessageDialog(frame, "Please enter a task!");
                }
            }
        });

        // Step 11: Add action listener to "Delete Task" button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  // Triggered when button is clicked
                int selectedIndex = taskList.getSelectedIndex();  // Get the index of the selected task
                if (selectedIndex != -1) {  // If a task is selected (index != -1)
                    taskListModel.remove(selectedIndex);  // Remove the selected task from the model (and thus from the list)
                } else {
                    // If no task is selected, show a message
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete!");
                }
            }
        });

        // Step 12: Add the main panel to the frame and make it visible
        frame.add(mainPanel);  // Add the main panel to the JFrame (the window)
        frame.setVisible(true); // Make the window visible
    }
}
