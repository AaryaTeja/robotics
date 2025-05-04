package com.company.APCSA;

// Import the necessary Java libraries
import java.util.ArrayList;  // For using ArrayLists
import java.util.Scanner;    // For reading user input

// Define the Student class
class Student {

    // Instance variables (also called fields or attributes)
    private String name;                // Student's name
    private int id;                     // Student ID
    private ArrayList<Integer> grades; // List of grades for this student

    /**
     * Constructor method - called when we create a new Student object.
     * It sets the name and ID, and creates an empty list of grades.
     */
    public Student(String name, int id) {
        this.name = name;           // Set the name
        this.id = id;               // Set the ID
        this.grades = new ArrayList<>(); // Initialize empty grade list
    }

    /**
     * This method adds a grade to the student's grade list.
     *
     * @param grade The numeric grade to add (0–100)
     */
    public void addGrade(int grade) {
        grades.add(grade);  // Add the grade to the ArrayList
    }

    /**
     * This method calculates and returns the GPA as a double.
     * GPA is calculated on a 4.0 scale:
     * 90–100 = 4.0, 80–89 = 3.0, 70–79 = 2.0, 60–69 = 1.0, <60 = 0.0
     */
    public double calculateGPA() {
        if (grades.size() == 0) {
            return 0.0; // Avoid division by zero
        }

        double totalPoints = 0.0;

        // Loop through all grades and convert each to GPA points
        for (int grade : grades) {
            if (grade >= 90) {
                totalPoints += 4.0;
            } else if (grade >= 80) {
                totalPoints += 3.0;
            } else if (grade >= 70) {
                totalPoints += 2.0;
            } else if (grade >= 60) {
                totalPoints += 1.0;
            } else {
                totalPoints += 0.0;
            }
        }

        // Average the total points
        return totalPoints / grades.size();
    }

    /**
     * This method prints the student’s name, ID, and GPA.
     */
    public void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("GPA: %.2f\n", calculateGPA());  // Format GPA to 2 decimal places
        System.out.println("--------------");
    }
}

// Main class where the program starts
public class StudentGPATracker {

    public static void main(String[] args) {
        // Create Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a list to hold multiple students
        ArrayList<Student> students = new ArrayList<>();

        // Ask how many students to enter
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character after nextInt

        // Loop to collect data for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Entering data for Student " + (i + 1) + " ---");

            // Get name
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            // Get ID
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();

            // Create a new Student object and add to the list
            Student student = new Student(name, id);

            // Ask how many grades to enter
            System.out.print("How many grades for this student? ");
            int numGrades = scanner.nextInt();

            // Loop to enter each grade
            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade); // Add the grade
            }

            // Add the student to the list
            students.add(student);
            scanner.nextLine(); // Clear newline after nextInt
        }

        // Display all students' info
        System.out.println("\n==== Student Information ====");
        for (Student s : students) {
            s.printStudentInfo(); // Call method to print info
        }

        // Close the scanner
        scanner.close();
    }
}

