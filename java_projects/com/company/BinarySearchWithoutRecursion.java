package com.company;

public class BinarySearchWithoutRecursion
{

    public static int[] sortedArray = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};

    public static void main(String[] args)
    {
        System.out.println(String.format("%s is present at index: %s",
                30, binarySearch(sortedArray, 30 )));
        System.out.println(String.format("%s is present at index: %s",
                4, binarySearch(sortedArray, 4)));
        System.out.println(String.format("%s is present at index: %s",
                15, binarySearch(sortedArray, 15 )));
    }
    public static int binarySearch(int[] sortedList, int number) {
        int min = 0;
        int max = sortedList.length - 1;
        while (min <= max)
        {
            //int mid = min + (max - min) / 2;
            int mid = (min + max ) / 2;
            if (sortedList[mid] == number)
            {
                return mid;
            } else if (sortedList[mid] < number)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        }

        return -1;
    }
}





