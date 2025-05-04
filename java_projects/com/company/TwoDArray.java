package com.company;

public class TwoDArray
{

    public static void main(String[] args)
    {
        // Declare and initialize a 2D array
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11, 12}
        };




        // Print the 2D array
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }


        int [][] Another2DArray ;
        Another2DArray =  new int[5][];
        Another2DArray[0] =  new int[4] ;
        Another2DArray[1] =  new int[4] ;
        Another2DArray[2] =  new int[4] ;
        Another2DArray[3] =  new int[6] ;
        Another2DArray[4] =  new int[6] ;

        Another2DArray[0][0] =  12 ;
        Another2DArray[0][1] =  13 ;
        Another2DArray[0][2] =  14 ;
        Another2DArray[0][3] =  15 ;

        //Another2DArray[2][5] =  100 ;

        Another2DArray[4][0] = 17 ;
        Another2DArray[4][1] = 18 ;
        Another2DArray[4][2] = 19 ;
        Another2DArray[4][3] = 20 ;
        Another2DArray[4][4] = 21 ;
        Another2DArray[4][5] = 22 ;
    }

}
