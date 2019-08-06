package com.workuser.https;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * @Classname HttpsAdapter
 * @Description TODO
 * @Date 2019/8/5 4:24 PM
 * @Created by nihui
 */
public class HttpsAdapter {

    private static final int TIMEOUT = 45000;
    public static final String ENCODING = "UTF-8";

    private static HttpURLConnection createConnection(String url, String method, Map<String, String> headerParameters, String body) throws Exception {
        URL Url = new URL(url);
        trustAllHttpsCertificates();
        HttpURLConnection httpConnection = (HttpURLConnection) Url.openConnection();
        // 设置请求时间
        httpConnection.setConnectTimeout(TIMEOUT);
        // 设置 header
        if (headerParameters != null) {
            Iterator<String> iteratorHeader = headerParameters.keySet().iterator();
            while (iteratorHeader.hasNext()) {
                String key = iteratorHeader.next();
                httpConnection.setRequestProperty(key, headerParameters.get(key));
            }
        }


//        HttpResponse<String> response = Unirest.post("https://10.75.65.10/rest_v2/")
//                .header("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
//                .header("User-Agent", "PostmanRuntime/7.15.2")
//                .header("Accept", "*/*")
//                .header("Cache-Control", "no-cache")
//                .header("Postman-Token", "692eef32-b10c-4237-b654-b4977a27e2c0,66cc775d-c988-466d-ab80-81e4333ec54e")
//                .header("Host", "10.75.65.10")
//                .header("Accept-Encoding", "gzip, deflate")
//                .header("Content-Type", "multipart/form-data; boundary=--------------------------274809682138682741695580")
//                .header("Content-Length", "393")
//                .header("Connection", "keep-alive")
//                .header("cache-control", "no-cache")
//                .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"method\"\r\n\r\nlogin\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"name\"\r\n\r\nhaiyan\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\nHaiyan.1234\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--")
//                .asString();
        //httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + ENCODING);
//        httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=--------------------------274809682138682741695580");

        // 设置请求方法
        httpConnection.setRequestMethod(method);
        httpConnection.setDoOutput(true);
        httpConnection.setDoInput(true);
        // 写query数据流
        if (!(body == null || body.trim().equals(""))) {
            OutputStream writer = httpConnection.getOutputStream();
            try {
                writer.write(body.getBytes(ENCODING));
            } finally {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            }
        }

        // 请求结果
        int responseCode = httpConnection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception(responseCode + ":" + inputStream2String(httpConnection.getErrorStream(), ENCODING));
        }

        return httpConnection;
    }

    private static String inputStream2String(InputStream input, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, encoding));
        StringBuilder result = new StringBuilder();
        String temp = null;
        while ((temp = reader.readLine()) != null) {
            result.append(temp);
        }

        return result.toString();

    }

    //设置 https 请求证书
    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {

        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }


    }

    private static void trustAllHttpsCertificates() throws Exception {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String str, SSLSession session) {
                return true;
            }
        });
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
}
