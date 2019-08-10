package com.newn;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname MyHttps
 * @Description TODO
 * @Date 2019/8/6 4:57 PM
 * @Created by nihui
 */
public class MyHttps {

    public static Object[] get(String url, LinkedHashMap<String, String> property) {
        Map<String, List<String>> headerFields = null;
        StringBuffer buffer = null;
        try {
            //创建SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] tm = {new MyX509TrustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL u = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();
            Set<String> keySet = property.keySet();
            for (String key : keySet) {
                conn.setRequestProperty(key, property.get(key));
            }        //设置当前实例使用的SSLSoctetFactory
            System.out.println("开始链接");
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            System.out.println("链接成功");
            //读取服务器返回的响应头
            headerFields = conn.getHeaderFields();
            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] response = {headerFields, buffer.toString()};
        return response;
    }

}
