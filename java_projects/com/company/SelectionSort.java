package com.company;

import java.util.Scanner;

public class SelectionSort
{

    static int numberOfIntegers = 0 ;
    static int holderArray[] ;

    public static void main(String[] args)
    {
        java.util.Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number of integers that you want to sort:");
        SelectionSort.numberOfIntegers = myObj.nextInt();

        holderArray = new int[SelectionSort.numberOfIntegers];

        System.out.println("Enter the integers one by one now:");

        for (int i = 0; i < SelectionSort.numberOfIntegers; i++)
        {
            int j = myObj.nextInt();
            holderArray[i] = j;
        }

        System.out.println("I am printing the integers that i received as input");

        SelectionSort.printTheArray(holderArray);

        mySelectionSort(SelectionSort.holderArray);
        System.out.println("Sorted array is:");

        SelectionSort.printTheArray(holderArray);
    }

    static void printTheArray (int [] c)
    {
        for (int i = 0 ; i < c.length ; i ++)
        {
            System.out.println(c[i]);
        }
    }

    static void mySelectionSort (int [] b)
    {
        int temp = 0 ;
        for (int i = 0 ; i < b.length; i++)
        {
            for (int j = i+1 ; j < b.length ; j++)
            {
                // do comparision here
                if (b[i] > b[j])
                {
                    // swap
                    temp = b[j] ;
                    b[j] = b[i];
                    b[i] = temp ;
                }
            }
        }
    }
}
