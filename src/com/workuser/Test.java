package com.workuser;

import com.workuser.https.HttpClientService;
import org.apache.http.NameValuePair;


import java.util.List;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/8/5 3:04 PM
 * @Created by nihui
 */
public class Test {
    public static void main(String[] args) throws Exception{
        String url = "https://10.75.65.10/rest_v2/";
        /**
         * 参数值
         */
        Object [] params = new Object[]{"method","name","password"};
        /**
         * 参数名
         */
        Object [] values = new Object[]{"login","haiyan","Haiyan.1234"};
        /**
         * 获取参数对象
         */
        List<NameValuePair> paramsList = HttpClientService.getParams(params, values);
        /**
         * 发送get
         */
        Object result = HttpClientService.sendGet(url, paramsList);
        /**
         * 发送post
         */
        Object result2 = HttpClientService.sendPost(url, paramsList);

        System.out.println("GET返回信息：" + result);
        System.out.println("POST返回信息：" + result2);
    }
}
