package com.company;


import java.util.Random;

public class Main {

    private static int k;

    public static void  create(int[][] a, int col, int row, int l, int h, int i, int j) {
        Random rn = new Random();
        a[i][j] = l + rn.nextInt() % (h - l + 1);
        if (j < col-1) {
            create(a, col, row, l, h, i, j + 1);
        }
        else if (i < row-1) {
            create(a, col, row, l, h, i + 1, 0);
        }
    }


    public static void print(int[][] a, int row, int col, int i, int j ) {

        if (j == 0) {
            System.out.print("|");
        }

        System.out.printf("%4d" ,a[i][j]);

        if (j == col-1) {
            System.out.print( "|");
            System.out.println();
        }

        if (j < col-1) {
            print(a, row, col, i, j + 1);
        }
        else if (i < row-1) {
            print(a, row, col, i + 1, 0);
        }
        else {
            System.out.println();
        }
    }

    public static void Tsort(int[][] a, int row, int col, int i1, int i2) {
        if ((a[i1][0] > a[i1 + 1][0])
                ||
                (a[i1][0] == a[i1 + 1][0] &&
                        a[i1][1] > a[i1 + 1][1])
                ||
                (a[i1][0] == a[i1 + 1][0] &&
                        a[i1][1] == a[i1 + 1][1] &&
                        a[i1][3] < a[i1 + 1][3]))
            change(a, i1, i1 + 1, col, 0);
        if (i1 < row - i2 - 2) {
            Tsort(a, row, col, i1 + 1, i2);
        }
        else if (i2 < row - 2) {
            Tsort(a, row, col, 0, i2+1);
        }

    }

    public static void change(int[][] a,  int i1, int i2, int col,int i) {
        int k;

        k = a[i1][i];
        a[i1][i] = a[i2][i];
        a[i2][i] = k;

        if (i < col - 1) {
            change(a, i1, i2, col, i + 1);
        }
    }

    public static int amount(int[][] a, int row, int col, int j, int i, int k) {
        if (!(a[i][j] % 2 == 0) || !(a[i][j] < 0)) {
            k++;
        }
        if (j < col - 1) {
             amount(a, row, col, j + 1, i, k);
        }
        else if (i < row - 1) {
             amount(a, row, col , 0,i + 1, k);
        }
        final int s1 = k;
        return s1;
    }


    public static int sum(int[][] a, int row, int col, int j, int i, int s) {
        if (!(a[i][j] % 2 == 0) || !(a[i][j] < 0)) {
            s += a[i][j];
            a[i][j] = 0;
        }
        if (j < col - 1) {
            sum(a, row, col, j + 1, i, s);
        }
        else if (i < row - 1) {
            sum(a, row, col , 0,i + 1, s);
        }
        final int s1 = s;
        return s1;
    }




    public static void main(String[] args) {
        int row = 7;
        int col = 6;
        int k ;
        int s ;
        int l = -12;
        int h = 23;

        int[][] X = new int[row][col];



        create(X, col, row, l, h, 0, 0);

        print(X, row, col, 0,0 );

        Tsort(X, row, col, 0, 0);

        print(X, row, col, 0, 0);

        k = amount(X, row, col, 0, 0, 0);
        s = sum(X, row, col, 0,0,0);

        print(X, row, col,0,0);

        System.out.println("sum = " + s );
        System.out.println("amount = " + k );
    }

}
