package com.example.charp02.array;

/**
 * @ClassName Example01
 * @Author nihui
 * @Date 2019/4/27 14:42
 * @Version 1.0
 * @Description TODO
 */
public class Example01 {

    public static void main(String[] args) {
        int[] fristArray = {1,2,3,4};
        int[] secondArray={5,6,7,8,9,10};
        int[] myArray;
        myArray = fristArray;
        System.out.println("FristArray原始数据");
        for (int i = 0; i <fristArray.length ; i++) {
            System.out.println(fristArray[i]);

        }

        myArray[0] = 100;
        myArray[1] = 121;

        System.out.println("第二次FristArray原始数据");
        for (int i = 0; i <fristArray.length ; i++) {
            System.out.println(fristArray[i]);
        }

        myArray = secondArray;

    }
}
