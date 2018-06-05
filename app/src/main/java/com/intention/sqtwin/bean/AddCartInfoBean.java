package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/6/5 0005-下午 15:48
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AddCartInfoBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"cart":true}
     */

    private boolean is_success;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cart : true
         */

        private boolean cart;

        public boolean isCart() {
            return cart;
        }

        public void setCart(boolean cart) {
            this.cart = cart;
        }
    }
}
