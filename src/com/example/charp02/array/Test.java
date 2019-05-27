package com.example.charp02.array;

/**
 * @ClassName Test
 * @Author nihui
 * @Date 2019/4/27 12:04
 * @Version 1.0
 * @Description TODO
 */
public class Test {
    public static void main(String[] args){
        //数组
        /**
         * 在编写程序的时候我们需要使用大量的相同类型的数据的时候
         * 就需要使用到一个数组。
         *
         * 对于数组来说就是一种存储相同类型数据的数据的集合。
         *
         * 例如
         *
         * 存储数据的类型[]  数组的引用标识
         * int[]  myIntArray
         *
         * 存储数据的类型  数组引用标识[]
         * int myIntArray[]
         */

        int[] myintArray;

        int myintArray1[];

        String[] myStringArray;

        char[] myCharArray;

        Student[]  myStudentArray;

        //数组的创建 数组名称= new 数据类型[数组的大小]
        myintArray = new int[10];

        myStringArray = new String[15];

        myCharArray = new char[10];

        myStudentArray = new Student[10];

        for (int i = 0; i < myintArray.length; i++) {
            myintArray[i] = i;
        }

        for (int i = 0; i < myintArray.length; i++) {
            System.out.println(myintArray[i]);
        }

    }
}

class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
