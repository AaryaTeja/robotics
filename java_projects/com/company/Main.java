package com.company;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
       //int []  ia = new int[3];
        //Human[]  ha = new Human[3] ;
       java.util.Scanner myObj = new Scanner(System.in);
        java.util.Scanner myObj1 = new Scanner(System.in);
        java.util.Scanner myObj2 = new Scanner(System.in);
        java.util.Scanner myObj3 = new Scanner(System.in);
	  for ( int i=0; i < 200 ; i++ )
      {

          //ha[i] = new Human() ;
          //ha[i].age = myObj.nextInt();
          Human h = new Human() ;
          System.out.println("Enter the Name now:");
          h.name = myObj.nextLine()  ;
          System.out.println("Enter the age now:");
          h.age = myObj1.nextInt();
          System.out.println("Enter the ht now:");
          h.ht = myObj2.nextInt();
          System.out.println("Enter the wt now:");
          h.wt = myObj3.nextInt();

          Human.AddNode(h);
      }
      /*
      for (int j=0; j< ha.length ; j++)

      {
          System.out.println(ha[j].age);
      }

       */


        //System.out.println(ha[2].age);

        Human.PrintAllNodes ();
    }





}
