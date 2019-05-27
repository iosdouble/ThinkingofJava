package com.example.charp02.doublearray;

/**
 * @ClassName Test
 * @Author nihui
 * @Date 2019/4/27 19:01
 * @Version 1.0
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {


        int[][] intArray;
        short shortArray[][];
        char[] charArray[];
        intArray = new int[3][5];//直接分配（平衡二维数组-矩阵）
        shortArray=new short[3][];//非平衡数组


        shortArray[0] = new short[4];
        shortArray[1] = new short[3];
        shortArray[2] = new short[5];

        char[][] charArray2 ={{'A','B','M'},{'D','E','H','H'},{'A','A','A'},{'w','w'}};


        int[] smallPrimes = {2,3,5,7,11,13};
        int[] luckyNumbers = {1001,1002,1003,1004,1005,1006,1007};

        System.arraycopy(smallPrimes,2,luckyNumbers,3,4);
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.println(luckyNumbers[i]);
        }

    }
}
