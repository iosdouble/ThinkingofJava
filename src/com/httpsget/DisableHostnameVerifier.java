package com.httpsget;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @Classname DisableHostnameVerifier
 * @Description TODO
 * @Date 2019/8/9 11:26 AM
 * @Created by nihui
 */
public class DisableHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
