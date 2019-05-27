package com.example.charp02.doublearray;

/**
 * @ClassName MatrixMultiply
 * @Author nihui
 * @Date 2019/4/27 19:16
 * @Version 1.0
 * @Description TODO
 */
public class MatrixMultiply {
    public static void main(String[] args){
        int[][] a = new int[2][3];
        int[][] b = {{1,5,2,8},{5,9,10,-3},{2,7,-5,-18}};
        int[][] c = new int[2][4];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = (i+1)*(j+2);
            }
        }
        System.out.println("* * * Matrix A * * *");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("* * * Matrix B * * *");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }

        System.out.println("* * * Matrix C * * *");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }



    }
}
