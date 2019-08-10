package com.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;


import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname HttpAdapter
 * @Description TODO
 * @Date 2019/8/6 12:56 PM
 * @Created by nihui
 */

public class HttpAdapter {

    public  String getResult(ChangeObject changeObject) {
        String getTokenUrl = "https://10.75.65.10/rest_v2/";
        String token = getToken(getTokenUrl, "haiyan", "Haiyan.1234");

        String url = "https://10.75.65.10/rest_v2/user/";
        HashMap<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/x-www-form-urlencoded");
        requestHeader.put("Access-Control-Allow-Origin", "*");
        requestHeader.put("Accept", "*/*");

        Map<String, List<ChangeObject>> param = new HashMap<>();
        List<ChangeObject> list = new ArrayList<>();

//        ChangeObject changeObject = new ChangeObject();
//        changeObject.setAccount("haiyan");
//        changeObject.setEndtime("2019-08-10 10:10:10");
//        changeObject.setValid_yn(1);

        list.add(changeObject);
        param.put("list", list);

//        System.out.println(list.toString());

        Map<String, String> kv = new HashMap<>();
        kv.put("method", "add-user");
        kv.put("token", token);
        kv.put("param", toJson(param));


//        String testStr = toJson(kv);
//        System.out.println(testStr);

        String testString = null;
        try {
            testString = getParameter(kv);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String result = null;
//        System.out.println(testString);
        try {
            CloseableHttpResponse closeableHttpResponse = post(url, testString, requestHeader);
            HttpEntity entity = closeableHttpResponse.getEntity();
            InputStream inputStream = entity.getContent();
            result = exchange(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String getParameter(Map<String, String> parameters) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String params = null;
        // 编码请求参数
        if (parameters.size() == 1) {
            for (String name : parameters.keySet()) {
                sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
            }
            params = sb.toString();
        } else {
            for (String name : parameters.keySet()) {
                sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
                        .append("&");
            }
            String temp_params = sb.toString();
            params = temp_params.substring(0, temp_params.length() - 1);
        }
        return params;
    }

    private static String getToken(String url, String name, String password) {
        HashMap<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        requestHeader.put("Access-Control-Allow-Origin", "*");
        requestHeader.put("Accept", "*/*");
        String jsonString = "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"method\"\r\n\r\nlogin\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"name\"\r\n\r\n" + name + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n" + password + "\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--";
        try {
            CloseableHttpResponse closeableHttpResponse = post(url, jsonString, requestHeader);
            HttpEntity entity = closeableHttpResponse.getEntity();
            InputStream inputStream = entity.getContent();
            String str = exchange(inputStream);
            Token tokenData = toObject(str, Token.class);
            return tokenData.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static <T> String toJson(T t) {
        if (t == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;

            try {
                json = mapper.writeValueAsString(t);
                return json;
            } catch (JsonProcessingException var4) {
                var4.printStackTrace();
            }
        }
        return null;
    }

    private static CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headermap) throws ClientProtocolException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
        //创建一个HttpPost的请求对象
        HttpPost httppost = new HttpPost(url);


        httppost.setEntity(new StringEntity(entityString));

        //加载请求头到httppost对象
        for (Map.Entry<String, String> entry : headermap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }
        //发送post请求
        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
        return httpResponse;
    }


    private static String exchange(InputStream in) {
        return exchange(in, "utf-8");
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

    private static <T> T toObject(String json, Class<T> clazz) {
        return StringUtils.isBlank(json) ? null : toObject(json, (String) null, clazz);
    }

    private static <T> T toObject(String json, String path, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            T t = null;
            if (StringUtils.isBlank(path)) {
                try {
                    t = mapper.readValue(json, clazz);
                    return t;
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
            } else {
                try {
                    JsonNode jsonRoot = mapper.readTree(json);
                    JsonNode jsonNode = jsonRoot.at(path);
                    if (jsonNode.isMissingNode()) {
                        return t;
                    } else {
                        t = mapper.readValue(jsonNode.toString(), clazz);
                        return t;
                    }
                } catch (IOException var8) {
                    var8.printStackTrace();
                }
            }
        }
        return null;
    }
}
