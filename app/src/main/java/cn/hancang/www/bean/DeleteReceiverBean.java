package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-上午 11:12
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DeleteReceiverBean {

    /**
     * is_success : true
     * message : 删除成功
     * data : 12
     */

    private boolean is_success;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
