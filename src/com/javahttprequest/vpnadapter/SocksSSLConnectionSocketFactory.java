package com.javahttprequest.vpnadapter;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import javax.net.ssl.SSLContext;

/**
 * @Classname SocksSSLConnectionSocketFactory
 * @Description TODO
 * @Date 2019/8/9 11:27 AM
 * @Created by nihui
 */
public class SocksSSLConnectionSocketFactory extends SSLConnectionSocketFactory {
    public SocksSSLConnectionSocketFactory(SSLContext sslContext) {
        super(sslContext,new DisableHostnameVerifier());
    }
}
