package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-下午 17:11
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AddFavBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : 1
     */

    private boolean is_success;
    private String message;
    private int data;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
