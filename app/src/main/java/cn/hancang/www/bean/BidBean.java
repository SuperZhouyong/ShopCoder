package cn.hancang.www.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/14-上午12:19
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : null
     */

    private boolean is_success;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}