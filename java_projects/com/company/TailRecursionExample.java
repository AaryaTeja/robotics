package com.company;

public class TailRecursionExample {

    // A method that prints numbers from n to 1 using tail recursion
    public static void tailRecursion(int n) {
        // Base case
        if (n == 0) {
            return;
        }

        // First: print the number
        System.out.println(n);

        // Then: make the recursive call (last action)
        tailRecursion(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Tail Recursion Output:");
        tailRecursion(5);  // Output: 5 4 3 2 1
    }
}
