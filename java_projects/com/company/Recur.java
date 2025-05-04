package com.company;

public class Recur
{
    public static void main(String[] args)
    {
        long  f = Recur.F(47);
        System.out.println("Fibo is: " + f);

        //long sum = Recur.sumationOfNumbers (2000);
        //System.out.println("sum is: " + sum);

        //int mul = Recur.multiplication(5) ;
        //System.out.println("mul is: " + mul);


    }
    static long sumationOfNumbers(long i)
    {
        System.out.println(i);
     if (i == 1 )
     {
         return 1 ;
     }
     return i + sumationOfNumbers (i - 1) ;

    }


    static int multiplication(int i)
    {
        System.out.println(i);
        if (i == 1 )
        {
            return 1 ;
        }

        return i * multiplication (i - 1) ;

    }

    static int F(long i)
    {
        //System.out.println(i);
        if (i==0)
        {
            return 0 ;
        }
        else if (i== 1)
        {
            return 1 ;
        }

        return F(i-1) + F(i-2) ;

    }
}
