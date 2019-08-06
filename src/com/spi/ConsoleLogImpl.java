package com.spi;

/**
 * @Classname ConsoleLogServiceImpl
 * @Description TODO
 * @Date 2019/8/5 10:12 AM
 * @Created by nihui
 */
public class ConsoleLogImpl implements ILog {

    @Override
    public void warn(String msg) {
        System.out.println("Console Log "+msg+"!");
    }
}
