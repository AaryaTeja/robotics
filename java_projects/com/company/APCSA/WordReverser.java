package com.company.APCSA;

// Import the Scanner class so we can read input from the keyboard
import java.util.Scanner;

public class WordReverser {

    /**
     * This method reverses the order of words in a sentence.
     * It does NOT reverse the letters inside the words.
     *
     * @param sentence The full sentence entered by the user
     * @return A new sentence with the word order reversed
     */
    public static String reverseWords(String sentence) {
        // Use the split() method to break the sentence into individual words.
        // The space " " is used as the delimiter to split the string.
        String[] words = sentence.split(" ");

        // Create a String to store the reversed sentence
        String reversed = "";

        // Loop through the array of words in reverse order
        // Start from the last index (words.length - 1) and go down to 0
        for (int i = words.length - 1; i >= 0; i--) {
            // Add the current word to the result string
            reversed += words[i];

            // If it's not the last word (index 0), add a space after it
            if (i != 0) {
                reversed += " ";
            }
        }

        // Return the reversed sentence
        return reversed;
    }

    /**
     * The main method is where the program starts running.
     * It gets user input and shows the reversed word order.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a sentence
        System.out.print("Enter a sentence: ");

        // Read the entire line of input using nextLine()
        String userInput = scanner.nextLine();

        // Call the reverseWords method and store the result
        String reversedSentence = reverseWords(userInput);

        // Print the original and reversed sentences
        System.out.println("Original sentence: " + userInput);
        System.out.println("Reversed word order: " + reversedSentence);

        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}

