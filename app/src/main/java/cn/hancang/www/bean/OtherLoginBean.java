package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/6/8 0008-下午 17:59
 * Blog：Super简单
 * Author: ZhouYong
 */

public class OtherLoginBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"member_id":"118"}
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
         * member_id : 118
         */

        private String member_id;

        public String getMember_id() {
            return member_id;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }
    }
}
