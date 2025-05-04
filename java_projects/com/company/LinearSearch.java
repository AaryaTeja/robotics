package com.company;

public class LinearSearch
{


    public static int[] someArray = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
    public static void main(String[] args)
    {
        System.out.println(String.format("%s is present at index: %s",
                30, linearSearch(someArray, 30 )));
        System.out.println(String.format("%s is present at index: %s",
                4, linearSearch(someArray, 4)));
        System.out.println(String.format("%s is present at index: %s",
                15, linearSearch(someArray, 15 )));
    }
    public static int linearSearch(int[] list, int number)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == number)
            {
                return i; // Return the index if the number is found
            }
        }
        return -1; // Return -1 if the number is not found
    }



}
