package com.example.charp01;

/**
 * @ClassName Test
 * @Author nihui
 * @Date 2019/4/20 11:40
 * @Version 1.0
 * @Description TODO
 */
public class Test {

    /**
     * Java中的字符集操作可以使用中文的方式
     * 这里使用中文的方式实现一个方法名的编写
     *
     */
    public static void 我是一个输出语句(){
        System.out.println("hello, world!");
    }
    public static void main(String[] args) {
        Test.我是一个输出语句();
        Test.关键字标识符();
    }

    public static void 关键字标识符(){
        System.out.println("联系关于标识符和关键字的使用");
        /**
         * 这里演示的是关于标识符的操作。
         */
        int ABC = 1123;
        int abc = 1231;

        System.out.println(abc);
        System.out.println(ABC);
    }


}
