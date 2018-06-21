package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/6/21 0021-上午 11:44
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AliLoginAfterBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"member_id":207,"member_mobile":null}
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
         * member_id : 207
         * member_mobile : null
         */

        private int member_id;
        private String member_mobile;

        public int getMember_id() {
            return member_id;
        }

        public void setMember_id(int member_id) {
            this.member_id = member_id;
        }

        public String getMember_mobile() {
            return member_mobile;
        }

        public void setMember_mobile(String member_mobile) {
            this.member_mobile = member_mobile;
        }
    }
}
