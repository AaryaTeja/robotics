package com.company;

import java.time.LocalDateTime;
import java.util.Random;



public class QuickSortL
{

    //private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};


    public static void main(String[] args)
    {


       /* Random rand = new Random();
        int[] numbers = new int[1000000000];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(1000000000);
        }

        */

        //int[] numbers = {5,4,3,2, 1 } ;

        //int[] numbers = new int[ ]  {95, 11, 49, 39, 79, 73 ,76 ,14, 15, 89, } ;

        // good example
       // int[] numbers = {6, 5, 4, 2, 1, 10 ,3 ,7, 8, 9, } ;

        int[] numbers = {3,3,2,2 } ;

        // good example
        //int [] numbers = { 10, 7, 8, 9, 1} ;

       //int [] numbers =  new int[] {3,3,2,3,3 } ;
        //int [] numbers =  new int[] {3,3,3,3,3 } ;

        //int [] numbers = {5, 4, 3, 2, 1};

        //int [] numbers = {4, 6, 4, 4, 4, 7, 4};

        //int[] numbers = new int[ ]  {3, 3, 3, 3, 3, 3 ,3 ,3, 3, 3, } ;

        //int[] numbers = new int[100000000 ] ;

        //int [] numbers =  new int [] { 4, 2} ;


        // Filling the array with random numbers between 0 and 99
        //for (int i = 0; i < numbers.length; i++)
        //{
        //    numbers[i] = rand.nextInt(100000000);
        //}

         /*
        print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
        print(listToSort);
        */

        // Printing the original array before sorting
        System.out.println("Original array:");
        //print(numbers);


        System.out.println("Before:");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before DateTime: " + now);

        // Sorting the array using quicksort
        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter:");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("\nAfter DateTime: " + now1);

        // Printing the sorted array after quicksort is applied
        //System.out.println("Sorted array:");
        //print(numbers);
    }

    // Method to print the array elements
    public static void print(int[] listToSort)
    {
        for (int el : listToSort)
        {
            System.out.print(el + " ");
        }
        System.out.println();

    }

    // Method to swap two elements in the array
    public static void swap(int[] listToSort, int iIndex, int jIndex)
    {
        int temp = listToSort[iIndex]; // Store value of listToSort[iIndex]
        listToSort[iIndex] = listToSort[jIndex]; // Assign listToSort[jIndex] to listToSort[iIndex]
        listToSort[jIndex] = temp; // Assign temp (old value of listToSort[iIndex]) to listToSort[jIndex]
    }

    // Recursive quicksort function
    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) { // Base case: if the partition size is 1 or 0, stop recursion
            return;
        }

         // try array with just 2 elements [4, 2]

        // Find the pivot index by partitioning the array
        int pivotIndex = partition(listToSort, low, high);

        // Recursively apply quicksort to the left part of the pivot
        quickSort(listToSort, low, pivotIndex - 1);

        // Recursively apply quicksort to the right part of the pivot
        quickSort(listToSort, pivotIndex + 1, high);
    }

    // Partition function to place pivot in correct position and return its index
    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low]; // Choosing the first element as pivot
        int l = low; // Left pointer
        int h = high; // Right pointer

        // Move elements such that those smaller than pivot are on the left,
        // and those greater are on the right
        while (l < h)
        {
            // Move left pointer to the right as long as elements are <= pivot
            while (listToSort[l] <= pivot && l < h)
            {
                l++; // Increment left pointer
            }
            // Move right pointer to the left as long as elements are > pivot

           while (h > low && listToSort[h] > pivot)
            //while (h > low && listToSort[h] >= pivot)
            {
                h--; // Decrement right pointer
            }
            // Swap elements if pointers haven't crossed
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        // Swap pivot with the element at the high pointer to put it in the correct position


        swap(listToSort, low, h); // do the swap here



        // Print the current pivot and array state for debugging
        //System.out.println("Pivot: " + pivot);
        //print(listToSort);

        return h; // Return the final position of the pivot
    }
}


