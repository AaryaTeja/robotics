package com.company;

import java.util.Scanner;  // Import Scanner to read user input
import java.util.Arrays;   // Import Arrays to use the sort and equals methods


/*
"Debit card" and "bad credit"
"Astronomer" and "moon starer"
"Eleven plus two" and "twelve plus one"
"The eyes" and "they see"
"angered" and "deranged"
"dormitory" and "dirty room"
"funeral" and "real fun"
"slot machines" and "cash lost in me"
 */

public class AnagramChecker {

    public static void main(String[] args)
    {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the first string
        System.out.println("Enter the first string:");
        String input1 = scanner.nextLine();

        // Ask the user for the second string
        System.out.println("Enter the second string:");
        String input2 = scanner.nextLine();

        // Call the isAnagram method to check if the two strings are anagrams
        boolean areAnagrams = isAnagram(input1, input2);

        // Display the result to the user
        if (areAnagrams)
        {
            System.out.println("The strings are anagrams.");
        } else
        {
            System.out.println("The strings are not anagrams.");
        }

        // Close the scanner to free up resources
        scanner.close();
    }

    /**
     * Checks whether two strings are anagrams.
     * This method removes whitespace, converts both strings to lowercase,
     * sorts their characters, and then compares the sorted arrays.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @return true if s1 and s2 are anagrams; false otherwise
     */
    public static boolean isAnagram(String s1, String s2) {
        // Remove all whitespace from the strings using replaceAll.
        // The regular expression "\\s" matches any whitespace character.
        String str1 = s1.replaceAll("\\s", "");
        String str2 = s2.replaceAll("\\s", "");

        // Remove all digits
        // String original = "Hello 123, welcome to 2025!";
        // String noDigits = original.replaceAll("\\d", "");
        // System.out.println(noDigits);
        // Output: "Hello , welcome to !"
        // \\d matches any digit (0–9)

        // Replace all spaces with dashes
        // String dashed = original.replaceAll(" ", "-");
        // System.out.println(dashed);
        // Output: "Hello-123,-welcome-to-2025!"
        // " " matches literal space

        // Replace all non-alphanumeric characters
        // String cleaned = original.replaceAll("[^a-zA-Z0-9]", "");
        // System.out.println(cleaned);
        // Output: "Hello123welcometo2025"
        // [^a-zA-Z0-9] matches any character that is NOT a letter or digit

        // Replace multiple spaces with a single space
        // String messy = "Hello     world!   How are  you?";
        // String singleSpaced = messy.replaceAll("\\s+", " ");
        // System.out.println(singleSpaced);
        // Output: "Hello world! How are you?"
        // \\s+ matches one or more whitespace characters

        // Convert both strings to lowercase so that the comparison is case-insensitive.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Convert the strings into character arrays so we can sort them.
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort the character arrays.
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Use Arrays.equals() to compare the sorted arrays.
        // If they are equal, the strings are anagrams.
        return Arrays.equals(charArray1, charArray2);
    }
}
