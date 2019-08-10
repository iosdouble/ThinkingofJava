package com.adapter;

/**
 * @Classname ChangeObject
 * @Description TODO
 * @Date 2019/8/6 10:52 AM
 * @Created by nihui
 */
public class ChangeObject {



    //用户账户
    private String account;
    //延期时间
    private String validfrom;
    private String validto;

    //是否操作时间 1 表示操作 0 表示不操作
    private Integer valid_yn;
    //用户ID(唯一标识属性)
    private String dn;
    //站点名称
    private String websitename;
    //认证服务器名称(编辑时不可修改)
    private String authServerName;
    //用户状态(0:禁止，1:允许【默认】，2:锁定)
    private Integer status_yn;
    //是否是VIP账号0 不是，1 是
    private Integer vip;
    //是否绑定IP 0是不绑定，1是绑定
    private Integer ipbindtype;
    //是否远程唤醒 0 不设置，1 唤醒
    private Integer mac_yn;
    //认证类型(0:本地【默认】，1:Radius，2:LDAP，3:AD，4:OCSP，5: Cert，7:POP3，8:SMTP，9:短信，10:HTTP，11:DB，12:动态，99:多因素)
    private Integer authtype;


    public ChangeObject() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(String validfrom) {
        this.validfrom = validfrom;
    }

    public String getValidto() {
        return validto;
    }

    public void setValidto(String validto) {
        this.validto = validto;
    }

    public Integer getValid_yn() {
        return valid_yn;
    }

    public void setValid_yn(Integer valid_yn) {
        this.valid_yn = valid_yn;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getWebsitename() {
        return websitename;
    }

    public void setWebsitename(String websitename) {
        this.websitename = websitename;
    }

    public String getAuthServerName() {
        return authServerName;
    }

    public void setAuthServerName(String authServerName) {
        this.authServerName = authServerName;
    }

    public Integer getStatus_yn() {
        return status_yn;
    }

    public void setStatus_yn(Integer status_yn) {
        this.status_yn = status_yn;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getIpbindtype() {
        return ipbindtype;
    }

    public void setIpbindtype(Integer ipbindtype) {
        this.ipbindtype = ipbindtype;
    }

    public Integer getMac_yn() {
        return mac_yn;
    }

    public void setMac_yn(Integer mac_yn) {
        this.mac_yn = mac_yn;
    }

    public Integer getAuthtype() {
        return authtype;
    }

    public void setAuthtype(Integer authtype) {
        this.authtype = authtype;
    }
}
