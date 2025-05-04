package com.company;

/**
 * Created by chelakara.prakash on 4/12/2025.
 */


public class NQueensProblem
{
    // Main method to test the program
    public static void main(String[] args)
    {
        // Create an object with desired board size (e.g., 8 for 8-Queens)
        NQueensProblem qp = new NQueensProblem(1);

        // Start solving the N-Queens problem
        qp.Solve();
    }

    // 2D array to represent the chessboard where 1 = Queen, 0 = Empty
    private int[][] ChessBoard;

    // Total number of queens (also the size of the board)
    private int NumberOfQueens;

    // Constructor to initialize the board and number of queens
    public NQueensProblem(int NumberOfQueens)
    {
        // Create an NxN board filled with 0s
        this.ChessBoard = new int[NumberOfQueens][NumberOfQueens];
        this.NumberOfQueens = NumberOfQueens;
    }

    // This method begins the process of solving the N-Queens problem
    public void Solve()
    {
        // Start placing queens from the first column (column index = 0)
        if (SetQueens(0)) {
            // If successful, print the board
            PrintQueens();
        } else {
            // If no arrangement is possible
            System.out.println("No solution to the problem");
        }
    }

    // Recursive method to try placing queens column by column
    private boolean SetQueens(int ColIndex) {
        // Base case: all queens are placed successfully
        if (ColIndex == NumberOfQueens) {
            return true;
        }
        // Try placing the queen in all rows for the current column
        for (int rowIndex = 0; rowIndex < NumberOfQueens; rowIndex++)
        {
            // Check if it's safe to place a queen at (rowIndex, ColIndex)
            if (IsPlaceValid(rowIndex, ColIndex))
            {
                // Place the queen
                ChessBoard[rowIndex][ColIndex] = 1;

                // Recursively try to place the next queen in the next column
                if (SetQueens(ColIndex + 1))
                {
                    return true; // Found a valid configuration
                }

                // Backtrack: remove the queen if no further solution found
                ChessBoard[rowIndex][ColIndex] = 0;
            }
        }
        // If queen cannot be placed in any row in this column
        return false;
    }

    // Method to check if it's safe to place a queen at the given position
    private boolean IsPlaceValid(int rowIndex, int columnIndex)
    {
        // Check the same row on the left side
        for (int i = 0; i < columnIndex; i++)
        {
            if (ChessBoard[rowIndex][i] == 1)
            {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = rowIndex, j = columnIndex; i >= 0 && j >= 0; i--, j--)
        {
            if (ChessBoard[i][j] == 1)
            {
                return false;
            }
        }

        // Check the lower-left diagonal
        for (int i = rowIndex, j = columnIndex; i < NumberOfQueens && j >= 0; i++, j--)
        {
            if (ChessBoard[i][j] == 1)
            {
                return false;
            }
        }

        // If no conflict is found, it's a valid position
        return true;
    }

    // Method to print the final board with queens placed
    void PrintQueens()
    {
        for (int i = 0; i < NumberOfQueens; i++)
        {
            for (int j = 0; j < NumberOfQueens; j++)
            {
                // Print '*' for queen, '-' for empty
                if (ChessBoard[i][j] == 1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print(" - ");
                }
            }
            // Move to the next line after each row
            System.out.println();
        }
    }


}

