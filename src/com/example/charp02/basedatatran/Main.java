package com.example.charp02.basedatatran;

/**
 * @ClassName Main
 * @Author nihui
 * @Date 2019/4/21 10:31
 * @Version 1.0
 * @Description TODO
 */
public class Main {

    public static void main(String[] args) {
        char a = 'h';
        byte b = 6;
        int i = 120;
        long l = 21334L; //如果不加 L 的话默认是一个Int型数据
        float f = 8.231F; //如果不加 F 的话默认是一个Double类型数据
        double d = 3.34323;

        //自动转换规则转大不转小
        int aa = a+i;
       // char aa = a+i;  //使用这种方式就会损失精度。
        long ll = l - aa;

        float ff = f*b;

        double dd = ff/aa+d;
        //字符串与其他字符的连接都会自转换为字符串
        System.out.println("aa="+aa);
        System.out.println("ll="+ll);
        System.out.println("ff="+ff);
        System.out.println("dd="+dd);

        /**
         * 在一个表达式前面加上类型，表示强制转换，
         * 但是如果实现强制转换的时候就会出现损失
         * 精度的效果。
         */


        /**
         * 在Java中有八种基本数据类型，每个数据类型都有自己对应的
         * 封装类，这也是对于Java面向对象的使用。
         *
         */

        //char  Character  cobj;
        //byte  Byte  bobj;
        //int  Integer iobj;
        //long Long lobj;
        //float Float fobj
        //double Double dobj
        //short Short sobj
        //boolean  Boolean

        /**
         * 1.自动装箱
         *   由基本数据类型到对象的过程
         * 2.自动拆箱
         *   由对象转换到基本数据类型的过程
         */

    }
}
