package com.workuser.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname HttpAdatper
 * @Description TODO
 * @Date 2019/7/22 10:45 AM
 * @Created by nihui
 */
public class HttpAdatper {

    //http://10.115.38.68:8000/v1/service/?departments__haiyancode=115

    //http://10.115.254.14:8000/v1/service/

    //‘/v1/login’, username=‘admin’, password=‘admin’

    public static void main(String[] args) {


        String token = getToken();
        System.out.println(token);



        //Authorization: Token  ee4f4e3135227aedf5d5fa557ae7bcd4f6daed8d
        //Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
        //              multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW


        RestClient restClient = new RestClient();
        String url = "http://10.115.254.14:8000/v1/service/?departments__haiyancode=115";
        HashMap<String, String> requestHeader = new HashMap<>();

        requestHeader.put("Accept","*/*");
        requestHeader.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        requestHeader.put("Authorization","Token  "+token);
        CloseableHttpResponse response = null;

        try {
            response = restClient.get(url, requestHeader);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();

            String string = exchange(inputStream);
            System.out.println(string);



        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static String getToken() {

        RestClient restClient = new RestClient();
        String url = "http://10.115.254.14:8000/v1/login";
        HashMap<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/json");
        requestHeader.put("Access-Control-Allow-Origin", "*");
        requestHeader.put("Accept","*/*");
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("username", "admin");
        tokenMap.put("password", "admin");
        String jsonString = JSON.toJSONString(tokenMap);
        CloseableHttpResponse response = null;

        try {
            response = restClient.post(url, jsonString, requestHeader);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();

            String string = exchange(inputStream);
            System.out.println(string);

            JSONObject jsonObject = JSON.parseObject(string);

            return (String) jsonObject.get("token");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String exchange(InputStream in){
        return exchange(in,"utf-8");
    }
    private static String exchange(InputStream in, String encode) {

        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, encode));
            StringBuffer sb = new StringBuffer();

            while ((str = reader.readLine()) != null) {
                sb.append(str).append("\n");
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
