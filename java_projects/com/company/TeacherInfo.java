// Declare the package name. Packages are used to organize Java classes.
package com.company;

// Import necessary Java libraries for file handling, input/output, and data structures.
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * TeacherInfo class processes test scores from a file and generates statistical analysis
 * of grades including distribution of A's, B's, C's, D's, and F's.
 */
public class TeacherInfo {
    // Array to store frequency of each possible score (0-100)
    private int[] scores = new int[101];

    // Array to store count of each letter grade (A, B, C, D, F)
    private int[] grades = new int[5];

    // Array to store teacher and course information (teacher name, course name, course number)
    private String[] teacherData = new String[3];

    // Main method: The entry point of the program.
    public static void main(String[] args) {
        // Create an instance of the TeacherInfo class to use its methods.
        TeacherInfo processor = new TeacherInfo();
        // Call the processFiles method to start the program.
        processor.processFiles();
    }

    // Method to handle file processing and user interaction.
    public void processFiles() {
        // Welcome message to the user.
        System.out.println("Welcome to TeacherInfo!");
        System.out.println("This program will collect all of");
        System.out.println("the information about the number of A's, B's to F's that you have in the course that you select");

        // Create a Scanner object to read user input from the keyboard.
        Scanner keyboard = new Scanner(System.in);

        // Ask the user to enter the name of the teacher's file (including the extension).
        System.out.print("Please enter the name of the teacher's file including the extension -> ");
        String inputFileName = keyboard.nextLine();

        // Ask the user to enter the course number they want to analyze.
        System.out.print("Please enter the course number for data you would like -> ");
        String targetCourse = keyboard.nextLine();

        // Generate the output file name by replacing ".txt" with "-results.txt".
        String outputFileName = inputFileName.replace(".txt", "-results.txt");

        // Try-catch block to handle file-related errors.
        try {
            // Call the readInputFile method to read and process the input file.
            ProcessResult result = readInputFile(inputFileName, targetCourse);

            // Check if the course is valid (matches the target course).
            if (result.validCourse) {
                // Calculate the letter grades based on the scores.
                calculateGrades();
                // Print the results to the console and the output file.
                printResults(outputFileName, result);
            } else {
                // If the course is not valid, display a message and write it to the output file.
                String message = String.format("Since %s does not teach course number %s, there is no data to report.",
                        teacherData[0], targetCourse);
                System.out.println(message);
                // Create a PrintWriter object to write to the output file.
                PrintWriter fileOut = new PrintWriter(new FileWriter(outputFileName));
                fileOut.println(message);
                fileOut.close(); // Close the file writer.
            }
        } catch (IOException e) {
            // Handle any file-related errors and display an error message.
            System.out.println("Error: Problem with file operations.");
        }
    }

    // Method to read the input file and process the data.
    private ProcessResult readInputFile(String fileName, String targetCourse) throws FileNotFoundException {
        // Create a Scanner object to read the input file.
        Scanner fileScanner = new Scanner(new File(fileName));

        // Create a ProcessResult object to store the results of processing the file.
        ProcessResult result = new ProcessResult(false, 0, 0);

        // Read the first three lines of the file (teacher name, course name, course number).
        teacherData[0] = fileScanner.nextLine(); // Teacher name
        teacherData[1] = fileScanner.nextLine(); // Course name
        teacherData[2] = fileScanner.nextLine(); // Course number

        // Check if the course number in the file matches the target course.
        if (!teacherData[2].equals(targetCourse)) {
            fileScanner.close(); // Close the file scanner.
            return result; // Return the result with validCourse set to false.
        }

        // If the course is valid, set the validCourse flag to true.
        result.validCourse = true;
        String currentLine;

        // Process the rest of the file line by line.
        while (fileScanner.hasNextLine()) {
            currentLine = fileScanner.nextLine().trim(); // Read and trim the current line.

            // Skip empty lines.
            if (currentLine.isEmpty()) continue;

            // Check if the line starts with "Section" (indicating a new section).
            if (currentLine.startsWith("Section")) {
                result.numSections++; // Increment the section count.
                continue; // Skip to the next line.
            }

            // Create a Scanner object to process the scores in the current line.
            Scanner lineScanner = new Scanner(currentLine);
            while (lineScanner.hasNextDouble()) {
                // Read each score as a double and convert it to an integer.
                double score = lineScanner.nextDouble();
                int intScore = (int) score;

                // Increment the count for this score in the scores array.
                scores[intScore]++;
                // Increment the total number of scores.
                result.totalScores++;
                // Add the score to the list of all scores.
                result.allScores.add(intScore);
            }
            lineScanner.close(); // Close the line scanner.
        }

        fileScanner.close(); // Close the file scanner.
        return result; // Return the processed result.
    }

    // Method to calculate the distribution of letter grades.
    private void calculateGrades() {
        // Loop through all possible scores (0-100).
        for (int i = 0; i < scores.length; i++) {
            // Count the number of A's (scores >= 90).
            if (i >= 90) grades[0] += scores[i];
                // Count the number of B's (scores >= 80 and < 90).
            else if (i >= 80) grades[1] += scores[i];
                // Count the number of C's (scores >= 70 and < 80).
            else if (i >= 70) grades[2] += scores[i];
                // Count the number of D's (scores >= 60 and < 70).
            else if (i >= 60) grades[3] += scores[i];
                // Count the number of F's (scores < 60).
            else grades[4] += scores[i];
        }
    }

    // Method to print the results to both the console and the output file.
    private void printResults(String outputFileName, ProcessResult result) throws IOException {
        // Create a PrintWriter object to write to the output file.
        PrintWriter fileOut = new PrintWriter(new FileWriter(outputFileName));

        // Create a header with teacher and course information.
        String header = String.format("Data for: %s\n", teacherData[0]);
        header += String.format("Course number: %s\n", teacherData[2]);
        header += String.format("Number of sections: %d\n", result.numSections);
        header += String.format("Total # of scores = %d\n", result.totalScores);
        header += String.format("Course: %s\n", teacherData[1]);

        // Print the header to the console and the output file.
        System.out.print(header);
        fileOut.print(header);

        // Print Version 1: All scores printed from high to low.
        System.out.println("\nData version 1: All scores printed from high to low.");
        fileOut.println("\nData version 1: All scores printed from high to low.");
        printAllScores(result.allScores, true, null, fileOut); // Print to file.
        printAllScores(result.allScores, false, System.out, null); // Print to console.

        // Print Version 2: Scores grouped by ranges (90's, 80's, etc.).
        System.out.println("\nData version 2: Here are all of the scores grouped together by 90's, 80's etc.");
        fileOut.println("\nData version 2: Here are all of the scores grouped together by 90's, 80's etc.");
        printScoresByRange(false, System.out, null); // Print to console.
        printScoresByRange(true, null, fileOut); // Print to file.

        // Print Version 3: Total number of each letter grade.
        String version3 = "\nData version 3:\nTotal number of each letter grade\n";
        System.out.print(version3);
        fileOut.print(version3);
        printGradeStats(result.totalScores, false, System.out, null); // Print to console.
        printGradeStats(result.totalScores, true, null, fileOut); // Print to file.

        fileOut.close(); // Close the file writer.
    }

    // Method to print all scores in descending order.
    private void printAllScores(ArrayList allScores, boolean toFile, PrintStream console, PrintWriter file) {
        // Sort the scores in descending order.
        Collections.sort(allScores, Collections.reverseOrder());
        int lineCount = 0; // Counter to track the number of scores printed per line.

        // Loop through all scores and print them.
        for (Object scoreObj : allScores) {
            int score = (int) scoreObj; // Convert the score to an integer.
            String formatted = String.format("%-3d ", score); // Format the score.

            // Print to the file or console based on the toFile flag.
            if (toFile) {
                file.print(formatted);
            } else {
                console.print(formatted);
            }

            lineCount++;
            // Print a new line after every 15 scores.
            if (lineCount % 15 == 0) {
                if (toFile) file.println();
                else console.println();
            }
        }

        // Print a new line if the last line is not complete.
        if (lineCount % 15 != 0) {
            if (toFile) file.println();
            else console.println();
        }
    }

    // Method to print scores grouped by ranges (90's, 80's, etc.).
    private void printScoresByRange(boolean toFile, PrintStream console, PrintWriter file) {
        // Loop through score ranges (90-100, 80-89, etc.).
        for (int range = 90; range >= 0; range -= 10) {
            int upper = (range == 90) ? 100 : range + 9; // Determine the upper limit of the range.
            StringBuilder line = new StringBuilder(); // Create a StringBuilder to store the scores.

            // Loop through scores in the current range.
            for (int score = upper; score >= range; score--) {
                // Append each score to the line based on its frequency.
                for (int count = 0; count < scores[score]; count++) {
                    line.append(String.format("%-3d ", score));
                }
            }

            // Print the line if it contains scores or if it's the 90's range.
            if (line.length() > 0 || range == 90) {
                if (toFile) {
                    file.println(line.toString()); // Print to file.
                } else {
                    console.println(line.toString()); // Print to console.
                }
            }
        }
    }

    // Method to print statistics for each letter grade.
    private void printGradeStats(int totalScores, boolean toFile, PrintStream console, PrintWriter file) {
        // Arrays to store letter grades and their corresponding score ranges.
        String[] letters = {"A", "B", "C", "D", "F"};
        String[] ranges = {"(90-100)", "(80-89)", "(70-79)", "(60-69)", "(0-59)"};

        // Loop through each letter grade.
        for (int i = 0; i < grades.length; i++) {
            // Calculate the percentage of each letter grade.
            double percentage = (totalScores > 0) ? (grades[i] * 100.0 / totalScores) : 0;

            // Format the grade count and percentage.
            String gradeCount = String.format("%s %s: %d\n", letters[i], ranges[i], grades[i]);
            String gradePercentage = String.format("%.2f%%\n", percentage);

            // Print to the file or console based on the toFile flag.
            if (toFile) {
                file.print(gradeCount);
                file.print(gradePercentage);
            } else {
                console.print(gradeCount);
                console.print(gradePercentage);
            }
        }
    }
}