package com.httpsget;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Classname ClientWithResponseHandler
 * @Description TODO
 * @Date 2019/8/9 11:26 AM
 * @Created by nihui
 */
public class ClientWithResponseHandler {


    public static String doGet(String url) throws Exception {
        SSLContext sslcontext = createIgnoreVerifySSL();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SocksSSLConnectionSocketFactory(sslcontext)).build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);
        // 创建自定义的httpclient对象
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager).build();
        //字符串
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(get);
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity);
        httpclient.close();
        System.out.println(string);
        return string;
    }

    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");
        X509TrustManager trustManager = new X509TrustManager() {

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
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

    public static void main(String[] args){
        try {
            String result = ClientWithResponseHandler.doGet("https://10.75.65.10/rest_v2/user/?method=query-user&token=45ce2d998631b1fac7c27ac452a2533b403d001631e8bafc0100000000000000&param={\"list\":{\"website_name\":\"\",\"group_name\":\"\",\"account\":\"haiyan\"}}");
            //String result = ClientWithResponseHandler.doGet("https://10.75.65.10/rest_v2/user/?method=query-user&token=0434bc558631b1fac7c27ac451216414937e001631e8bafc0100000000000000&param=%22list%22:[{%22account%22:%22tt-user%22}]");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}