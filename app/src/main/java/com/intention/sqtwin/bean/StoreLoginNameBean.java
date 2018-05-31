package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:20
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreLoginNameBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"member_name":"17600298095"}
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
         * member_name : 17600298095
         */

        private String member_name;

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }
    }
}
