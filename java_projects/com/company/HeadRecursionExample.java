package com.company;

public class HeadRecursionExample
{

    // A simple method that prints numbers from 1 to n using head recursion
    public static void headRecursion(int n)
    {
        // Base case: stop when n is 0
        if (n == 0)
        {
            return;
        }

        // First: recursive call (this will go all the way to n == 0)
        headRecursion(n - 1);

        // Then: print after the recursive call
        System.out.println(n);
    }

    public static void main(String[] args) {
        System.out.println("Head Recursion Output:");
        headRecursion(5);  // Output: 1 2 3 4 5
    }
}

