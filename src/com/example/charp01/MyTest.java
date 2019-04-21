package com.example.charp01;

/**
 * @ClassName MyTest
 * @Author nihui
 * @Date 2019/4/20 12:06
 * @Version 1.0
 * @Description TODO
 */
public class MyTest {

    public static void main(String[] args) {
        //变量的声明  变量类型 变量名 =  变量值；
        /**
         * 变量 ：保存数据的单元。
         * 在计算机中对于变量的存储，是在内存中开辟存储数据的空间。
         * 对于这块空间的大小就是由变量的类型来决定
         */

        int i;
        int number = 123;
        //以上的这两个变量就在内存中占用了8个字节

        String name = "Java";
        String str;

        //对于之前说过的变量名称作为一个标识符，所以要符合标识符的规则

        /**
         * Java 是一种强类型的编程语言，对于每一个对象都需要有一个明确的类型
         *
         *
         * 在Java中数据主要分为两大类
         * 1.基本数据类型
         *      boolean
         *      byte
         *      char
         *      short
         *      int
         *      long
         *      float
         *      double
         * 2.引用数据类型
         *     String
         *     Date
         *     对象
         *     等等
         */

        //整型
        //十进制
        int int10 = -12;
        //八进制 代表十进制的 10
        int int8 = 012;
        //十六进制
        int int16 =0x123;
        System.out.println(int8);
        System.out.println(int10);

        //byte表示一个字节表数范围为-128~127之间
        byte byte1 = 123;
        byte byte2 = -128;

        System.out.println("================");

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        short short1 = 12312;
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        int int1 = 12321;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        long long1 = 2132131231;
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        float float1 = 213.123F;
        float float2 = 123.231f;

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);

        double double1 = 213.04;
        double double2 = 12321D;
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        //表示正无穷大
        //Float.POSITIVE_INFINITY
        boolean b ;

        //字符型

        //一个字符在内存中占用的是两个字节，声明一个字符就要2个字节也就是16个bit。

        char char1 = 'a';
        char char2 = '中';
        char char3 = '@';

        System.out.println("a的编码"+(int)char1);

        int A = char1;
        char1 = (char)A;

        //这些字符之间是可以直接进行操作的。所以说对于表数范围大的转换
        //为表数范围小的数的时候有可能会损失精度，在实际使用的时候需要注意


    }
}