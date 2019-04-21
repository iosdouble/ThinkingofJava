package com.example.charp02.classandmember.abc;

import com.example.charp02.classandmember.app.MyClass;

import java.util.Map;

/**
 * @ClassName ABC
 * @Author nihui
 * @Date 2019/4/21 17:00
 * @Version 1.0
 * @Description TODO
 */
public class ABC extends MyClass {
    public void subMehod(){
        this.mProtectedString = "test";

        /**
         * 表示可以调用public和protected修饰的方法和变量
         */

    }
}
