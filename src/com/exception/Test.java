package com.exception;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/7/26 1:11 PM
 * @Created by nihui
 */
public class Test {
    public static void main(String[] args) {
        int result = myMethod();
        System.out.println(result);
    }

    private static int testReturn() {
        try{
            int a = 5/1;
            return a;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("这个方法会执行么！");
        }
    }


    public static int myMethod() {

        int i = 0;
        int[] num = {1, 2, 3};

        System.out.println(num[3]);

        try {
            System.out.println("try 代码块被执行！");
            return 0;
        } catch (Exception e) {
            System.out.println("catch 代码块被执行！");
            return 0;
        } finally {
            System.out.println("finally 代码块被执行！");
        }
    }

    public static int myMethod1() {

        int i = 0;
        int[] num = { 1, 2, 3 };

        if (i == 0) {
            return 0;
        }

        System.out.println(num[3]);

        try {
            System.out.println("try 代码块被执行！");
            return 0;
        } catch (Exception e) {
            System.out.println("catch 代码块被执行！");
            return 0;
        } finally {
            System.out.println("finally 代码块被执行！");
        }

    }


    public static int myMethod2() {

        try {
            System.out.println("try 代码块被执行！");

            System.exit(0);

            return 0;
        } catch (Exception e) {
            System.out.println("catch 代码块被执行！");
            return 0;
        } finally {
            System.out.println("finally 代码块被执行！");
        }

    }


}
