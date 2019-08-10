package com.javahttprequest.vpnuserinfo;

import java.util.List;

/**
 * @Classname ResultItemObject
 * @Description TODO
 * @Date 2019/8/9 5:46 PM
 * @Created by nihui
 */
public class ResultItemObject {
    private String id;
    private String account;
    private String status;
    private String remark;
    private String cellphone;
    private String email;
    private String website_name;
    private String auth_name;
    private List<UserGroupInfo> group_list;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite_name() {
        return website_name;
    }

    public void setWebsite_name(String website_name) {
        this.website_name = website_name;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public List<UserGroupInfo> getGroup_list() {
        return group_list;
    }

    public void setGroup_list(List<UserGroupInfo> group_list) {
        this.group_list = group_list;
    }
}
