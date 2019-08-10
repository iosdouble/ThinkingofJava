package com.javahttprequest.vpnadapter.bean;

/**
 * @Classname VPNUserResult
 * @Description TODO
 * @Date 2019/8/9 3:32 PM
 * @Created by nihui
 */
public class VpnUserResult {

    private String website_name;
    private String group_name;
    private String account;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getWebsite_name() {
        return website_name;
    }

    public void setWebsite_name(String website_name) {
        this.website_name = website_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
