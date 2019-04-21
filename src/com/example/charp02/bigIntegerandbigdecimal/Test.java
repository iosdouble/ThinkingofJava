package com.example.charp02.bigIntegerandbigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName Test
 * @Author nihui
 * @Date 2019/4/21 10:57
 * @Version 1.0
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        float f1 = 123.01f + 1.01f;
        System.out.println(f1);
        // 结果124.020004 不精确

        System.out.println(123.01 + 1.01);
        //124.02000000000001 不精确

        int i = 1253231233;
        int j = 1246346312;
        //int k = i*j;
        long k = i * j;
        System.out.println(k);
        //结果 1472770120 这个数据不准确


        System.out.println("===============");

        //高精度整数测试();


        BigDecimal bigDecimal = new BigDecimal("123.01");
        BigDecimal bigDecimal1 = new BigDecimal("1.01");

        //设置标度和舍入
        bigDecimal.setScale(5,5);
        bigDecimal1.setScale(5,5);

        BigDecimal result = null;


        //加法
        result = bigDecimal.add(bigDecimal1);
        System.out.println(result);
        //减法

        result = bigDecimal.subtract(bigDecimal1);
        System.out.println(result);

        //乘法
        result = bigDecimal.multiply(bigDecimal1);
        System.out.println(result);
        //除法
         result = bigDecimal.divide(new BigDecimal(2.0));
        System.out.println(result);

        //余数
        result = bigDecimal.remainder(bigDecimal1);
        System.out.println(result);
        //乘方
        result = bigDecimal.pow(2);
        System.out.println(result);


    }

    private static void 高精度整数测试() {
        BigInteger bigInteger = new BigInteger("125");
        BigInteger bigInteger1 = new BigInteger("999");

        //通过Add方法进行操作

        BigInteger add = bigInteger.add(bigInteger1);

        System.out.println(add);

        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract);

        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);

        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide);

        BigInteger remainder = bigInteger.remainder(bigInteger1);
        System.out.println(remainder);

        BigInteger pow = bigInteger.pow(2);
        System.out.println(pow);
    }
}
