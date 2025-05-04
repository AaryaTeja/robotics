package com.company;

import java.util.ArrayList;




public class ArrayListExample
{

    public static void main(String[] args)
    {
        // Create an ArrayList to store strings
        ArrayList<String> names = new ArrayList<>();

        //ArrayList names = new ArrayList();

        // Add some names to the ArrayList
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Charlie");


        // adding a primitive data type int  that gets auto converted to Integer
        //names.add(1) ;
        //names.add(21) ;
        //names.add(31) ;

        // Print the ArrayList
        System.out.println("ArrayList: " + names); // Output: ArrayList: [Alice, Bob, Charlie, David]

        // Access an element by index
        String firstPerson = (String )names.get(0);
        System.out.println("First person: " + firstPerson); // Output: First person: Alice

        // Modify an element
        names.set(1, "Robert"); // Change "Bob" to "Robert"
        System.out.println("Modified ArrayList: " + names); // Output: Modified ArrayList: [Alice, Robert, Charlie, David]

        // Remove an element
        while (names.remove("Charlie") );


        //names.remove("Charlie");

        System.out.println("ArrayList after removal: " + names); // Output: ArrayList after removal: [Alice, Robert, David]

        // Get the size of the ArrayList
        int size = names.size();
        System.out.println("Size of ArrayList: " + size); // Output: Size of ArrayList: 3

        // Iterate through the ArrayList
        System.out.println("Iterating through ArrayList:");
       /* for (String  name : names)
        {
            System.out.println(name);
        }

        */

/*
        for ( int i = 0 ; i < names.size() ; i++)
        {
            System.out.print(names.get(i));
            System.out.print(" ");

        }

 */


        for (int i = 0 ; i < names.size() ; i++)
        {
            Object obj = names.get(i) ;
            String className = obj.getClass().getName();
            if (className.equalsIgnoreCase("java.lang.String")) // there will be  a problem here
            {
                System.out.println((String) obj);
            }
            else if (className.equalsIgnoreCase("java.lang.Integer"))
            {
                System.out.println((Integer) obj);
            }
            else
            {
                System.out.println ("Unknown type") ;
            }
        }

       // System.out.println (names) ;

    }
}
