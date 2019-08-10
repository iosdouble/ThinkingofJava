package com.javahttprequest.vpnuserinfo;

import java.util.List;

/**
 * @Classname RespResult
 * @Description TODO
 * @Date 2019/8/9 5:43 PM
 * @Created by nihui
 */
public class RespResult {
    private String rs;
    private String module;
    private Integer total;
    private List<ResultItemObject> list;


    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ResultItemObject> getList() {
        return list;
    }

    public void setList(List<ResultItemObject> list) {
        this.list = list;
    }
}
