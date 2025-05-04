package com.company.APCSA;

// Import required classes
import java.util.ArrayList;    // To use ArrayList
import java.util.Scanner;      // To get user input

public class RemoveDuplicates {

    /**
     * This method removes duplicates from an ArrayList of integers.
     * It keeps only the first occurrence of each number.
     *
     * @param list The original list with possible duplicates
     * @return A new list containing only unique values
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        // Create a new ArrayList to store only unique numbers
        ArrayList<Integer> uniqueList = new ArrayList<>();

        // Loop through each number in the original list
        for (int num : list) {
            // If the number is not already in the unique list, add it
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);  // Add only if it's not a duplicate
            }
        }

        // Return the list with duplicates removed
        return uniqueList;
    }

    /**
     * The main method: gets input from user, calls removeDuplicates, and prints results.
     */
    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create an empty ArrayList to store the user's numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Ask user how many numbers they want to enter
        System.out.print("How many numbers do you want to enter? ");
        int count = scanner.nextInt();  // Read the count

        // Loop to take each number as input and add it to the list
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int value = scanner.nextInt();  // Read the number
            numbers.add(value);             // Add to ArrayList
        }

        // Call the method to remove duplicates
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);

        // Print the original and the result
        System.out.println("Original list: " + numbers);
        System.out.println("List after removing duplicates: " + uniqueNumbers);

        // Close the scanner to avoid memory leaks
        scanner.close();
    }
}

