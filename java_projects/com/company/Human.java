package com.company;

public class Human
{
    static  Human head ;
    String name ;
    int age ;
    int ht ;
    int wt ;
    Human next;

    Human()
    {
        next = null;
    }

    void PrintHumanDetails ()
    {
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Ht:" + ht);
        System.out.println("Wt:" + wt);
    }

    static void AddNode(Human h)
    {
        if (head == null)
        {
            head = h ;
        }
        else
        {
            Human current = head ;
            while (current.next != null)
            {
                current = current.next ;
            }
            current.next = h ;
        }
    }

    static void  PrintAllNodes ()
    {
        if (head == null)
        {
            return  ; // in case the head itlsef if not there
        }
        else
        {
            Human current = head ;
            while (current.next != null) // iterate through the Human objects in the lsite
            {
                current.PrintHumanDetails();
                current = current.next ;
            }
            current.PrintHumanDetails(); // to take care of the last Human object
        }
    }

}
