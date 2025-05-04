package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class GroupAnagrams {
    // Maximum number of words we expect to read from the file.
    public static final int MAX_WORDS = 1000;

    public static void main(String[] args) {
        // Create a Scanner for reading user input from the console.
        Scanner consoleScanner = new Scanner(System.in);

        // Ask the user for the input file name.
        System.out.print("Enter the input file name (with extension): ");
        String inputFileName = consoleScanner.nextLine();

        // Ask the user for the output file name.
        System.out.print("Enter the output file name (with extension): ");
        String outputFileName = consoleScanner.nextLine();

        // Array to store words read from the input file.
        String[] words = new String[MAX_WORDS];
        // Counter to keep track of how many words are read.
        int wordCount = 0;

        // Use try-catch to handle potential file I/O exceptions.
        try {
            // Create a Scanner to read from the input file.
            Scanner fileScanner = new Scanner(new File(inputFileName));

            // Read each word (assumed one per line) until there are no more or we reach MAX_WORDS.
            while (fileScanner.hasNextLine() && wordCount < MAX_WORDS) {
                String word = fileScanner.nextLine().trim();
                // Only add non-empty lines.
                if (!word.equals("")) {
                    words[wordCount] = word;
                    wordCount++;
                }
            }
            fileScanner.close();
        } catch (IOException e)
        {
            System.out.println("Error reading the input file: " + e.getMessage());
            consoleScanner.close();
            return;  // Exit if there is an error.
        }

        // Boolean array to track which words have already been grouped.
        boolean[] grouped = new boolean[wordCount];
        // Array to hold the resulting anagram groups as strings.
        // Since worst-case every word is in its own group, size is wordCount.
        String[] groups = new String[wordCount];
        int groupCount = 0; // Count of groups found.

        // Loop through each word to form groups.
        for (int i = 0; i < wordCount; i++)
        {
            // If this word has already been grouped, skip it.
            if (grouped[i]) {
                continue;
            }
            // Mark this word as grouped.
            grouped[i] = true;

            // Compute the canonical (sorted) form of the current word.
            String canonical = sortChars(words[i]);
            // Start a group with the current word.
            String group = words[i];

            // Compare with every other word that has not been grouped.
            for (int j = i + 1; j < wordCount; j++)
            {
                if (!grouped[j]) {
                    // Compute canonical form for the jth word.
                    String candidateCanonical = sortChars(words[j]);
                    // If the canonical forms are equal, they are anagrams.
                    if (canonical.equals(candidateCanonical))
                    {
                        // Append the word to the current group.
                        group += " " + words[j];
                        // Mark the word as grouped.
                        grouped[j] = true;
                    }
                }
            }
            // Save the group in our groups array.
            groups[groupCount] = group;
            groupCount++;
        }

        // Now, write the groups to the output file.
        try {
            // Create a File object for the output file.
            File outFile = new File(outputFileName);
            // Create parent directories if necessary.
            if (outFile.getParentFile() != null) {
                outFile.getParentFile().mkdirs();
            }
            // Create a PrintWriter to write to the output file.
            PrintWriter fileOut = new PrintWriter(new FileWriter(outFile));

            // Write the total number of groups as the first line.
            fileOut.println("Total groups: " + groupCount);

            // Write each group on its own line.
            for (int i = 0; i < groupCount; i++) {
                fileOut.println(groups[i]);
            }

            // Close the PrintWriter to flush the data to the file.
            fileOut.close();
            System.out.println("Anagram groups have been written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }

        // Close the console scanner.
        consoleScanner.close();
    }

    /**
     * This method returns a canonical (sorted) form of the input string.
     * It removes whitespace, converts the string to lowercase,
     * converts it into a character array, sorts the array, and then
     * returns a new string from the sorted array.
     *
     * @param s the original string
     * @return the canonical (sorted) string
     */
    public static String sortChars(String s) {
        // Remove any whitespace and convert to lowercase.
        String cleaned = s.replaceAll("\\s", "").toLowerCase();
        // Convert the string to a character array.
        char[] charArray = cleaned.toCharArray();
        // Sort the character array.
        Arrays.sort(charArray);
        // Return a new string made from the sorted array.
        return new String(charArray);
    }
}
