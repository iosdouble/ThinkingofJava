package com.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/8/5 10:44 AM
 * @Created by nihui
 */
public class Main {
    private static ServiceLoader<ILog> services = ServiceLoader.load(ILog.class);

    public static void main(String[] args) {
        Iterator<ILog> iterator = services.iterator();
        while (iterator.hasNext()) {
            iterator.next().warn("Hello SPI");
        }
    }
}
