package com.company;

public class TwoDArray {
    int[][] numbers1;
    int[][] numbers2;
    int[][] numbers3 = new int[4][3];

    TwoDArray() {
        int[][] numbers1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int[][] numbers2 = {
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21},
                {22, 23, 24}

        };
        this.numbers1 = numbers1;
        this.numbers2 = numbers2;
    }

    void add() {
        for (int i = 0; i < numbers3.length; i++) {
            for (int j = 0; j < numbers3[i].length; j++) {
                numbers3[i][j] = numbers1[i][j] + numbers2[i][j];
            }
        }
    }

    void printaddNumbers3() {
        for (int i = 0; i < numbers3.length; i++) {
            for (int j = 0; j < numbers3[i].length; j++) {
                System.out.print(numbers3[i][j] + " ");
            }
            System.out.println();
        }
    }
    void subtract() {
        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                numbers3[i][j] = numbers2[i][j] - numbers1[i][j];
            }
        }
    }
    void printsubNumbers3() {
        for (int i = 0; i < numbers3.length; i++) {
            for (int j = 0; j < numbers3[i].length; j++) {
                System.out.print(numbers3[i][j] + " ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        TwoDArray obj = new TwoDArray();
        obj.add();
        obj.printaddNumbers3();
        System.out.println("\n\n");
        obj.subtract();
        obj.printsubNumbers3();
    }
}