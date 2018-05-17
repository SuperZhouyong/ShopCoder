package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-上午 11:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsBean {

    /**
     * is_success : true
     * message : 操作成功
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
