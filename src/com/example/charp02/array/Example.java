package com.example.charp02.array;

import java.applet.Applet;
import java.awt.*;

/**
 * @ClassName Example
 * @Author nihui
 * @Date 2019/4/27 12:28
 * @Version 1.0
 * @Description TODO
 */
public class Example extends Applet {
    int array[];
    public void init(){
        array = new int[5];
        array[0] = 100;
        array[1] = 101;
        array[2] = 102;
        array[3] = 103;
        array[4] = 104;
    }

    public  void paint(Graphics g){
        g.drawString("array[0]="+array[0]+" array[1]="+array[1]+" array[2]="+array[2],12,12);
        g.drawString("array[3]="+array[3]+" array[4]="+array[4],12,32);

    }
}
