package com.example.charp02.classandobject;

/**
 * @ClassName Point
 * @Author nihui
 * @Date 2019/4/21 16:15
 * @Version 1.0
 * @Description TODO
 */
public class Point {
    int x;
    int y;

    //利用Return关键字进行返回操作
    public int getX() {
        return x;
    }

    //前缀没有this是参数，加上this是类的变量
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
