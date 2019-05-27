package com.example.charp02.array;

import javax.swing.*;
import java.util.*;
/**
 * @ClassName LotteryDrawing
 * @Author nihui
 * @Date 2019/4/27 12:39
 * @Version 1.0
 * @Description TODO
 */
public class LotteryDrawing {
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("请输入创建数组的大小(数字)");

        int MAX_SIZE = Integer.parseInt(input);

        int[] randomArray = new int[MAX_SIZE];

        input = JOptionPane.showInputDialog("输入随机数最大值(数字)");

        int MAX_VALUE = Integer.parseInt(input);

        for (int i = 0; i <MAX_SIZE; i++) {
            randomArray[i] = (int) (Math.random()*MAX_VALUE);
        }

        System.out.println("====初始状态数组=============");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println(randomArray[i]);
        }
        Arrays.sort(randomArray);
        System.out.println("====排序后数组=============");

        for (int i = 0; i <MAX_SIZE; i++) {
            System.out.println(randomArray[i]);
        }
    }
}
