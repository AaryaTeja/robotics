package com.company.APCSA;

// Importing the Scanner class so we can get input from the keyboard
import java.util.Scanner;

public class VowelRemover {

    /**
     * This method removes all vowels (both uppercase and lowercase)
     * from the input string and returns the resulting string.
     *
     * @param input The original string entered by the user
     * @return A new string with all vowels removed
     */
    public static String removeVowels(String input)
    {
        // Create an empty string to build the result without vowels
        String result = "";

        // Loop through each character in the input string one by one
        for (int i = 0; i < input.length(); i++) {
            // Get the character at the current index 'i'
            char currentChar = input.charAt(i);

            // Check if the current character is NOT a vowel
            // We check against both lowercase and uppercase vowels
            if (currentChar != 'a' && currentChar != 'e' && currentChar != 'i' &&
                    currentChar != 'o' && currentChar != 'u' &&
                    currentChar != 'A' && currentChar != 'E' && currentChar != 'I' &&
                    currentChar != 'O' && currentChar != 'U') {

                // If it's not a vowel, add it to the result string
                result += currentChar;  // Appending character to the result
            }
        }

        // After the loop, return the final string with vowels removed
        return result;
    }

    /**
     * The main method is the entry point of any Java application.
     * This is where we get input from the user and display the result.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a sentence or word
        System.out.print("Enter a sentence or word: ");

        // Read the entire line of input entered by the user
        String userInput = scanner.nextLine();

        // Call the removeVowels method and store the result
        String result = removeVowels(userInput);

        // Print the original string entered by the user
        System.out.println("Original input: " + userInput);

        // Print the string after removing vowels
        System.out.println("Without vowels: " + result);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}


