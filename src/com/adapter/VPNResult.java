package com.adapter;

/**
 * @Classname VPNResult
 * @Description TODO
 * @Date 2019/8/6 1:16 PM
 * @Created by nihui
 */
public class VPNResult {

    private String name;//用户名
    private String rs;//返回的状态值，OK表示成功，其他表示失败
    private String errorrs;//如果数据错误，返回的错误提示信息
    private String module;// module string 是 固定值:user
    private String site;  //是 站点名称

    public VPNResult(String name, String rs, String errorrs, String module, String site) {
        this.name = name;
        this.rs = rs;
        this.errorrs = errorrs;
        this.module = module;
        this.site = site;
    }

    public VPNResult() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getErrorrs() {
        return errorrs;
    }

    public void setErrorrs(String errorrs) {
        this.errorrs = errorrs;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
