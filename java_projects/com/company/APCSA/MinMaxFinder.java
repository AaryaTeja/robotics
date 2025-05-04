package com.company.APCSA;

// Import the Scanner class so we can read user input
import java.util.Scanner;

public class MinMaxFinder {

    /**
     * This method finds and prints the minimum and maximum values
     * from an integer array entered by the user.
     *
     * @param numbers An array of integers
     */
    public static void findMinMax(int[] numbers) {
        // Assume the first element is both the minimum and maximum
        int min = numbers[0];
        int max = numbers[0];

        // Loop through the entire array starting from the second element (index 1)
        for (int i = 1; i < numbers.length; i++) {
            // If the current number is smaller than the current min, update min
            if (numbers[i] < min) {
                min = numbers[i];
            }

            // If the current number is larger than the current max, update max
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Print out the results
        System.out.println("Minimum value in the array: " + min);
        System.out.println("Maximum value in the array: " + max);
    }

    /**
     * The main method collects user input and calls the findMinMax method.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many numbers they want to enter
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        // Create an integer array of the specified size
        int[] numbers = new int[size];

        // Prompt the user to enter each number one by one
        System.out.println("Enter " + size + " integers:");

        // Use a loop to fill the array with user input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();  // Store input in the array
        }

        // Call the method to find and print min and max
        findMinMax(numbers);

        // Close the scanner to free system resources
        scanner.close();
    }
}

