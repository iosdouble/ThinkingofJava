package com.spi;

/**
 * @Classname FileLogServiceImpl
 * @Description TODO
 * @Date 2019/8/5 10:12 AM
 * @Created by nihui
 */
public class FileLogImpl implements ILog {
    @Override
    public void warn(String msg) {
        System.out.println("File Log "+msg+"!");
    }
}
