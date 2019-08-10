package com.javahttprequest;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName JavaHttp
 * @Description TODO
 * @Author nihui
 * @Date 2019/6/14 15:47
 * @Version 1.1
 **/
@Component
public class JavaHttp {

    private String url = "";

    private URLConnection conn;

    public JavaHttp() {
//        JavaHttp ht = new JavaHttp();
//        String url = "http://puffer.gome.inc/zapi.asp?programme=a";
//        String param = "";
//        String head1 = "Content-Type";
//        String head2 = "application/json";
//        //ht.httpConn(url,param,head1,head2);
//        //ht.doPost(url,param,head1,head2);
    }

    //get方式：参数放置在url上
    public String httpConn(String url1, String param, String head1, String head2) {
        String urlNameString = url1 + "?" + param;
        String result = "";
        try {
            URL url = new URL(urlNameString);
            //打开url的连接
            URLConnection conn = url.openConnection();
            //设置连接属性
            conn.setConnectTimeout(6 * 1000);
            conn.setRequestProperty(head1, head2);
            //获得输入流，并封装为字符
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));//获得网络返回的输入流
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            result = new String(result.getBytes(), "UTF-8");
            //System.out.println("result "+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    //post方式，以输出流的形式发送
    public String doPost(String url1, String param, String head1, String head2) {
        String result = "";
        try {
            URL url = new URL(url1);
            //打开url的连接
            URLConnection conn = url.openConnection();
            //设置url的连接属性
            conn.setConnectTimeout(6 * 1000);
            conn.setDoOutput(true);    //设置OutPut是Ture
            //获得输出流，并将其封装为字符流
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            //按字节的方式打印输出字符，并写入数组的某一部分
            out.print(param);
            //刷新输出流的缓冲
            out.flush();
            //获得网络返回的输入流，并封装为输入流
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                result += line;
            }
            result = new String(result.getBytes(), "UTF-8");
            //System.out.println("result  "+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

}
