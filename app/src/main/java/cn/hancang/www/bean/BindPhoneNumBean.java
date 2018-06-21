package cn.hancang.www.bean;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-下午9:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BindPhoneNumBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : 16
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
