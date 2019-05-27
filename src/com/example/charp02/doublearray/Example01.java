package com.example.charp02.doublearray;

/**
 * @ClassName Example01
 * @Author nihui
 * @Date 2019/4/27 19:11
 * @Version 1.0
 * @Description TODO
 */
public class Example01 {
    public static void main(String[] args){
        boolean bTb1[][] = new boolean[4][];
        for (int i = 0; i < bTb1.length; i++) {
            bTb1[i] = new boolean[i+1];
        }

        for (int i = 0; i < bTb1.length; i++) {
            for (int j = 0; j < bTb1[i].length; j++) {
                System.out.print(bTb1[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
