package com.javahttprequest.vpnadapter;

import com.gome.arch.web.business.haiyan.server.javahttprequest.adapter.HttpClientUtils;
import com.gome.arch.web.business.haiyan.server.javahttprequest.adapter.Token;
import com.gome.arch.web.business.haiyan.server.javahttprequest.vpnadapter.bean.VpnUserQueryParam;
import com.gome.arch.web.business.haiyan.server.javahttprequest.vpnadapter.bean.VpnUserResult;
import com.javahttprequest.adapter.HttpClientUtils;
import com.javahttprequest.adapter.Token;
import com.javahttprequest.vpnadapter.bean.VpnUserQueryParam;
import com.javahttprequest.vpnadapter.bean.VpnUserResult;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.cat.core.util.json.JsonUtil;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ClientWithResponseHandler
 * @Description TODO
 * @Date 2019/8/9 11:26 AM
 * @Created by nihui
 */
public class ClientWithResponseHandler {


    private static String doGet(String url) throws Exception {
        SSLContext sslcontext = createIgnoreVerifySSL();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SocksSSLConnectionSocketFactory(sslcontext)).build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);
        // 创建自定义的httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager).build();
        //字符串
        URL urlt = new URL(url);
        System.out.println(url);
        URI uri = new URI(urlt.getProtocol(), urlt.getHost(), urlt.getPath(), urlt.getQuery(), null);
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = httpclient.execute(get);
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity);
        httpclient.close();
        return string;
    }

    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");
        X509TrustManager trustManager = new X509TrustManager() {

            public void checkClientTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            public void checkServerTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {


            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
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
            Token tokenData = JsonUtil.toObject(str, Token.class);
            return tokenData.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){

        VpnUserResult vpnUserResult = new VpnUserResult();
        vpnUserResult.setGroup_name("");
        vpnUserResult.setWebsite_name("");
        vpnUserResult.setAccount("huangyanlin");
        VpnUserQueryParam userQueryParam = new VpnUserQueryParam();
        userQueryParam.setList(vpnUserResult);
        String paramjson = JsonUtil.toJson(userQueryParam);
        System.out.println(paramjson);
        try {
            String getTokenUrl = "https://10.75.65.10/rest_v2/";
            String token = getToken(getTokenUrl, "haiyan", "Haiyan.1234");
            String root = "https://10.75.65.10/rest_v2/user/";
            String url = root+"?method=query-user&token="+token+"&param="+paramjson;
            String result = ClientWithResponseHandler.doGet(url);

            //String result = ClientWithResponseHandler.doGet("https://10.75.65.10/rest_v2/user/?method=query-user&token=45ce2d998631b1fac7c27ac452a2533b403d001631e8bafc0100000000000000&param="+paramjson);
            //String result = ClientWithResponseHandler.doGet("https://10.75.65.10/rest_v2/user/?method=query-user&token=0434bc558631b1fac7c27ac451216414937e001631e8bafc0100000000000000&param=%22list%22:[{%22account%22:%22tt-user%22}]");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}