package com.intention.sqtwin.bean;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-下午5:25
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class DeleteGoodsBean {


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
