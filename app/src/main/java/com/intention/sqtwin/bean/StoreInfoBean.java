package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:01
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoBean {


    /**
     * is_success : false
     * message : 您没有店铺！
     * data : []
     */

    private boolean is_success;
    private String message;
    private List<?> data;

    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
