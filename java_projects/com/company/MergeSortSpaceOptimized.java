package com.company;


import java.time.LocalDateTime;
import java.util.Random;

public class MergeSortSpaceOptimized
{

    static int [] aux ;

    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println("Before:");
        printArray(numbers);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before DateTime: " + now);
        myMergeSort(numbers);

        System.out.println("\nAfter:");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("\nAfter DateTime: " + now1);
       printArray(numbers);
    }


    static void myMergeSort (int [] a)
    {
        aux =  new int[a.length];
        myMergeSort (0,a.length -1 , a) ;
    }




    static void myMergeSort (int lo, int hi, int [] a)
    {
        // exit clause
        if (hi<= lo)
        {
            return ;
        }

        // find the mid point
        int mid = (lo + hi) / 2 ;

        myMergeSort(lo, mid, a);

        myMergeSort(mid + 1, hi , a);

        merge (lo, mid, hi, a) ;
    }

    static void merge (int lo, int mid , int hi, int [] b)
    {
        int i = lo ;
        int j = mid + 1 ;

        // fill the aux array now
        for (int k = lo ; k <=hi ; k ++)
        {
            aux [k] = b [k] ;
        }

        for (int p = lo ; p <= hi ; p++)
        {
            if (i > mid )
            {
                b[p] = aux [j++] ;
            }
            else if (j > hi)
            {
                b[p] = aux [i++] ;
            }
            else if (aux [j] < aux [i])
            {
                b[p] = aux [j++] ;
            }
            else
            {
                b[p] = aux [i++] ;
            }
        }
    }


    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
    }




}

