package cn.hancang.www.bean;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:03
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderIdBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"openid":null,"pay_sn":"760581515099603042","notify_url":"http://ta.beikunit.com/api/notifyurl/alipay_notify"}
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
         * openid : null
         * pay_sn : 760581515099603042
         * notify_url : http://ta.beikunit.com/api/notifyurl/alipay_notify
         */

        private Object openid;
        private String pay_sn;
        private String notify_url;

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }
    }
}
