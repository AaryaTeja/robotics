package com.company;

public class MatrixMultiplication
{
    final int x = 88 ;
    public static void main(String[] args)
    {
        //MatrixMultiplication m =  new MatrixMultiplication() ;
       // m.mymethod(5, "ereerere") ;
       // m.mymethod((int) 5.23) ;




        // Define two matrices
        int[][] matrixA = {
                {1, 2, 3, 8},
                {4, 5, 6, 9}
        };
        int[][] matrixB = {
                {7, 8, 4},
                {9, 10, 6},
                {11, 12, 5},
                {6, 7, 3}
        };

        // Check if the matrices can be multiplied
        if (matrixA[0].length != matrixB.length) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }

        // Resultant matrix
        int[][] result = new int[matrixA.length][matrixB[0].length];

        // Perform matrix multiplication
        for (int i = 0; i < matrixA.length; i++) { // Rows of matrixA
            for (int j = 0; j < matrixB[0].length; j++) { // Columns of matrixB
                for (int k = 0; k < matrixA[0].length; k++) { // Columns of matrixA (or rows of matrixB)
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Print the resultant matrix
        System.out.println("Resultant Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    final void mymethod ()
    {
        System.out.println("this is test");
    }
    void mymethod ( final int x, final String s)
    {
      //  x = x+1;
       // s =  "erererer" ;
        System.out.println("this is test");
    }
    //void mymethod (double y)
    //{
    //    System.out.println("this is test");
    //}


}
