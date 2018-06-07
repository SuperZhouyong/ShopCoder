package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-下午 17:11
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AddFavBean {


    /**
     * is_success : false
     * message : 您已关注过！
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
