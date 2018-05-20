package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/14 0014-下午 13:18
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"member_id":16}
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
         * member_id : 16
         */

        private int member_id;

        public int getMember_id() {
            return member_id;
        }

        public void setMember_id(int member_id) {
            this.member_id = member_id;
        }
    }
}
