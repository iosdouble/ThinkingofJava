package com.https;

import java.io.BufferedReader;
        import java.io.ByteArrayOutputStream;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.UnsupportedEncodingException;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;
import javax.net.ssl.*;

import com.alibaba.fastjson.JSONObject;

/**
 * Http请求
 * @author mszhou
 *
 */
public class HttpsUtils {




    private static final int TIMEOUT = 45000;
    public static final String ENCODING = "UTF-8";


    //POST /rest_v2/ HTTP/1.1
    //Host: 10.75.65.10
    //User-Agent: PostmanRuntime/7.15.2
    //Accept: */*
    //Cache-Control: no-cache
    //Postman-Token: 692eef32-b10c-4237-b654-b4977a27e2c0,64da6e6e-4a6e-4383-bfc7-60b9152cb092
    //Host: 10.75.65.10
    //Accept-Encoding: gzip, deflate
    //Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
    //Content-Length: 393
    //Connection: keep-alive
    //cache-control: no-cache
    //
    //
    //Content-Disposition: form-data; name="method"
    //
    //login
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--,
    //Content-Disposition: form-data; name="method"
    //
    //login
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--
    //Content-Disposition: form-data; name="name"
    //
    //haiyan
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--,
    //Content-Disposition: form-data; name="method"
    //
    //login
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--
    //Content-Disposition: form-data; name="name"
    //
    //haiyan
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--
    //Content-Disposition: form-data; name="password"
    //
    //Haiyan.1234
    //------WebKitFormBoundary7MA4YWxkTrZu0gW--

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
                httpConnection.setRequestProperty(key,headerParameters.get(key));
            }
        }

        httpConnection.setRequestProperty("Content-Type","multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");

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

    /**
     * POST请求
     * @param address 请求地址
     * @param headerParameters 参数
     * @param body
     * @return
     * @throws Exception
     */
    public static String post(String address, Map<String, String> headerParameters, String body) throws Exception {

        return proxyHttpRequest(address, "POST", null, getRequestBody(headerParameters));
    }

    /**
     * GET请求
     * @param address
     * @param headerParameters
     * @param body
     * @return
     * @throws Exception
     */
    public static String get(String address,Map<String, String> headerParameters, String body) throws Exception {

        return proxyHttpRequest(address + "?" + getRequestBody(headerParameters), "GET", null, null);
    }


    public static String proxyHttpRequest(String address, String method, Map<String, String> headerParameters, String body) throws Exception {
        String result = null;
        HttpURLConnection httpConnection = null;

        try {
            httpConnection = createConnection(address, method, headerParameters, body);
            String encoding = "UTF-8";
            if (httpConnection.getContentType() != null && httpConnection.getContentType().indexOf("charset=") >= 0) {
                encoding = httpConnection.getContentType().substring(httpConnection.getContentType().indexOf("charset=") + 8);
            }
            result = inputStream2String(httpConnection.getInputStream(), encoding);

        } catch (Exception e) {
            throw e;
        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
        }
        return result;
    }

    /**
     * 将参数化为 body
     * @param params
     * @return
     */
    public static String getRequestBody(Map<String, String> params) {
        return getRequestBody(params, true);
    }

    /**
     * 将参数化为 body
     * @param params
     * @return
     */
    public static String getRequestBody(Map<String, String> params,
                                        boolean urlEncode) {
        StringBuilder body = new StringBuilder();

        Iterator<String> iteratorHeader = params.keySet().iterator();
        while (iteratorHeader.hasNext()) {
            String key = iteratorHeader.next();
            String value = params.get(key);

            if (urlEncode) {
                try {
                    body.append(key + "=" + URLEncoder.encode(value, ENCODING)
                            + "&");
                } catch (UnsupportedEncodingException e) {
                    // e.printStackTrace();
                }
            } else {
                body.append(key + "=" + value + "&");
            }
        }

        if (body.length() == 0) {
            return "";
        }
        return body.substring(0, body.length() - 1);
    }

    /**
     * 读取inputStream 到 string
     * @param input
     * @param encoding
     * @return
     * @throws IOException
     */
    private static String inputStream2String(InputStream input, String encoding)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,
                encoding));
        StringBuilder result = new StringBuilder();
        String temp = null;
        while ((temp = reader.readLine()) != null) {
            result.append(temp);
        }

        return result.toString();

    }


    private static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[1];
        trustAllCerts[0] = (TrustManager) new TrustAllManager();
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(
                sc.getSocketFactory());
    }

    private static class TrustAllManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }
        public void checkServerTrusted(X509Certificate[] certs,
                                       String authType)
                throws CertificateException
        {
        }
        public void checkClientTrusted(X509Certificate[] certs,
                                       String authType)
                throws CertificateException
        {
        }
    }

    //====================================================================
    //============================= 测试调用   ============================
    //====================================================================
    public static void main(String[] args) {

        try {

           //请求地址(我这里测试使用淘宝提供的手机号码信息查询的接口)
            String address = "https://10.75.65.10/rest_v2/";

            //请求参数
            Map<String, String> params = new HashMap<String, String>();
            params.put("method", "login");//这是该接口需要的参数
            params.put("name", "haiyan");//这是该接口需要的参数
            params.put("password", "Haiyan.1234");//这是该接口需要的参数

            // 调用 get 请求
            String res = post(address, params, null);
            System.out.println(res);//打印返回参数

            res = res.substring(res.indexOf("{"));//截取
            JSONObject result = JSONObject.parseObject(res);//转JSON

            System.out.println(result.toString());//打印

        } catch (Exception e) {
            // TODO 异常
            e.printStackTrace();
        }


    }

}