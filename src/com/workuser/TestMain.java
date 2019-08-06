package com.workuser;

import com.workuser.https.HttpsUtil;

import java.io.IOException;

/**
 * @Classname TestMain
 * @Description TODO
 * @Date 2019/8/5 1:35 PM
 * @Created by nihui
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
        String uri = "https://10.75.65.10/rest_v2";
        byte[] bytes = HttpsUtil.doGet(uri);
        System.out.println(new String (bytes,"utf-8"));
//        FileOutputStream fos = new FileOutputStream("D:/bing.txt");
//        fos.write(bytes);
//        fos.close();
        System.out.println("done!");
        byte[] bytes1 = "hello world".getBytes();        //Verify original content
        System.out.println( new String(bytes1,"utf-8") );
    }
}
