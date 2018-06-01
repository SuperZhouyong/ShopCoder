package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/6/1 0001-下午 16:08
 * Blog：Super简单
 * Author: ZhouYong
 */

public class HotSearchInfoBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : ["关键词","关键词","关键词"]
     */

    private boolean is_success;
    private String message;
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
