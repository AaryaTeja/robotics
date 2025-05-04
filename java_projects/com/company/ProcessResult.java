// Declare the package name. Packages are used to organize Java classes into folders.
// This helps avoid naming conflicts and makes the code more modular.
package com.company;

// Import the ArrayList class from the java.util package.
// ArrayList is a resizable array that can store a list of objects.
import java.util.ArrayList;

// Define a public class named ProcessResult.
// This class will be used to store and manage data about course processing results.
public class ProcessResult {

    // Declare a boolean variable named validCourse.
    // This variable will store whether the course being processed is valid or not.
    boolean validCourse;

    // Declare an integer variable named totalScores.
    // This variable will store the total number of scores processed.
    int totalScores;

    // Declare an integer variable named numSections.
    // This variable will store the number of sections in the course.
    int numSections;

    // Declare an ArrayList named allScores.
    // This ArrayList will store all the scores processed for the course.
    // The ArrayList can dynamically grow in size as scores are added.
    ArrayList allScores;

    // Define a constructor for the ProcessResult class.
    // A constructor is a special method that is called when an object of the class is created.
    // This constructor takes three parameters:
    // 1. valid: A boolean value indicating whether the course is valid.
    // 2. total: An integer value representing the total number of scores.
    // 3. sections: An integer value representing the number of sections.
    ProcessResult(boolean valid, int total, int sections) {
        // Assign the value of the 'valid' parameter to the 'validCourse' variable.
        validCourse = valid;

        // Assign the value of the 'total' parameter to the 'totalScores' variable.
        totalScores = total;

        // Assign the value of the 'sections' parameter to the 'numSections' variable.
        numSections = sections;

        // Initialize the 'allScores' ArrayList.
        // This creates a new, empty ArrayList that can store scores.
        allScores = new ArrayList();
    }
}