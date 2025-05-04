package com.company;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort
{

    static int numberOfIntegers = 0 ;
    static int holderArray[] ;

    public static void main(String[] args)
    {
        //java.util.Scanner myObj = new Scanner(System.in);
        //System.out.println("Enter the number of integers that you want to sort");
        //BubbleSort.numberOfIntegers = myObj.nextInt() ;
        //holderArray = new int[BubbleSort.numberOfIntegers] ;

        System.out.println("Enter the integers one by one now:");

        /*for (int i = 0 ; i < BubbleSort.numberOfIntegers ; i++)
        {
            int j = myObj.nextInt() ;
            holderArray[i] = j ;
        }

         */

        Random rand = new Random();
        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }


        //System.out.println("before");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before DateTime: " + now);

        BubbleSort.myBubbleSort(numbers) ;

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("\n After DateTime: " + now1);
        //BubbleSort.myBubbleSort(BubbleSort.holderArray) ;
        //BubbleSort.myBubbleSortAnotherWay(BubbleSort.holderArray);
        //System.out.println("After");

        //System.out.println("The sorted array is:");
        //BubbleSort.printTheArray(BubbleSort.holderArray) ;
        //BubbleSort.printTheArray(numbers) ;


    }
    static void myBubbleSort (int [] b)
    {
        int temp ;
        boolean swapped =  false ;
        for (int i = 0 ; i < b.length ; i ++)
        {
            swapped =  false ;
            for (int j = b.length - 1 ; j > i ; j--)
            {
                if (b[j] < b [j- 1])
                {
                    // swap
                    temp = b[j] ;
                    b[j] = b[j-1];
                    b[j-1] = temp ;

                    swapped = true ;
                }
            }

            if (swapped == false)
            {
                break;
            }

        }
    }

    static void myBubbleSortAnotherWay (int [] b)
    {
        int temp ;
        boolean swapped =  false ;
        for (int i = 0 ; i < b.length ; i ++)
        {
            swapped =  false ;

            for (int j = 0 ; j < b.length - i - 1  ; j++ )
            {
                if (b[j] > b [j+ 1])
                {
                    temp = b[j] ;
                    b[j] = b[j+1];
                    b[j+1] = temp ;

                    swapped = true ;

                }

            }

            if (swapped == false)
            {
                break;
            }

        }
    }


    static void printTheArray (int [] c)
    {
        for (int i = 0 ; i < c.length ; i ++)
        {
            System.out.println(c[i]);
        }

    }


}
