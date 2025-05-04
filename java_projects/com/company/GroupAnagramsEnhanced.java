package com.company;



// Import necessary classes for file handling, arrays, and user input
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class GroupAnagramsEnhanced
{
    // Set a maximum limit on number of words to read from the input file
    public static final int MAX_WORDS = 1000;

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner consoleScanner = new Scanner(System.in);

        // Ask the user for the name of the input file
        System.out.print("Enter the input file name (with extension): ");
        String inputFileName = consoleScanner.nextLine(); // Read input file name

        // Ask the user for the name of the output file
        System.out.print("Enter the output file name (with extension): ");
        String outputFileName = consoleScanner.nextLine(); // Read output file name

        // Array to store words read from the input file
        String[] words = new String[MAX_WORDS];
        int wordCount = 0; // Counter to track how many words are read

        // Try reading the input file
        try {
            Scanner fileScanner = new Scanner(new File(inputFileName)); // Scanner to read file

            // Read each line from the file until EOF or max words reached
            while (fileScanner.hasNextLine() && wordCount < MAX_WORDS) {
                String word = fileScanner.nextLine().trim(); // Remove leading/trailing spaces

                if (!word.trim().isEmpty()) { // Skip blank lines
                    words[wordCount] = word; // Store the word in array
                    wordCount++; // Increment word counter
                }
            }
            fileScanner.close(); // Close the file scanner
        } catch (IOException e) { // Handle errors in reading file
            System.out.println("Error reading the input file: " + e.getMessage());
            consoleScanner.close(); // Close scanner
            return; // Exit the program
        }

        // Boolean array to mark whether a word has been grouped already
        boolean[] grouped = new boolean[wordCount];

        // Array to store the grouped anagrams
        String[] groups = new String[wordCount]; // One group per word max
        int groupCount = 0; // Counter for number of anagram groups

        // Loop through all words to group them
        for (int i = 0; i < wordCount; i++) {
            if (grouped[i]) continue; // Skip if already grouped

            grouped[i] = true; // Mark this word as grouped
            String canonical = sortChars(words[i]); // Get canonical form (sorted chars)
            String group = words[i]; // Start a new group with the current word

            // Compare with all remaining ungrouped words
            for (int j = i + 1; j < wordCount; j++) {
                if (!grouped[j]) {
                    String candidateCanonical = sortChars(words[j]); // Canonical of candidate word

                    // If both canonical forms match, they are anagrams
                    if (canonical.equals(candidateCanonical)) {
                        group += " " + words[j]; // Add to group
                        grouped[j] = true; // Mark as grouped
                    }
                }
            }

            // Optional: sort each group alphabetically for neat output
            String[] groupWords = group.split(" "); // Split group into individual words
            Arrays.sort(groupWords, String.CASE_INSENSITIVE_ORDER); // Sort ignoring case
            groups[groupCount] = String.join(" ", groupWords); // Join sorted words back
            groupCount++; // Increment group count
        }

        // Try writing the grouped anagrams to the output file
        try {
            File outFile = new File(outputFileName); // Create file object
            if (outFile.getParentFile() != null) {
                outFile.getParentFile().mkdirs(); // Create parent directories if needed
            }

            PrintWriter fileOut = new PrintWriter(new FileWriter(outFile)); // Writer to output file

            fileOut.println("Total groups: " + groupCount); // Write header line

            // Write each group with group number
            for (int i = 0; i < groupCount; i++)
            {
                fileOut.println("Group " + (i + 1) + ": " + groups[i]);
                System.out.println("Group " + (i + 1) + ": " + groups[i]);
            }

            fileOut.close(); // Close file writer
            System.out.println("Anagram groups have been written to " + outputFileName);
        } catch (IOException e) { // Handle writing errors
            System.out.println("Error writing to the output file: " + e.getMessage());
        }

        consoleScanner.close(); // Close console scanner
    }

    /**
     * Converts a word to a canonical form by removing spaces, non-letters,
     * converting to lowercase, sorting characters alphabetically
     */
    public static String sortChars(String s)
    {
        String cleaned = s.replaceAll("[\\W_]", "").toLowerCase(); // Remove punctuation and make lowercase
        char[] charArray = cleaned.toCharArray(); // Convert to character array
        Arrays.sort(charArray); // Sort characters alphabetically
        return new String(charArray); // Convert sorted array back to string
    }
}
