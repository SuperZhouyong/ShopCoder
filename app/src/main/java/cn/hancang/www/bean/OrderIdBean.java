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
     * data : {"openid":null,"alipay_app_orderString":"","pay_sn":"100581867864211016","notify_url":"http://ta.beikunit.com/api/notifyurl/wx_notify","wechat_app_orderString":"{\"error\":0,\"result\":{\"partnerid\":\"1507318451\",\"appid\":\"wx54fa8a2ea47c977b\",\"prepayid\":\"wx09135744382791bc902f30791801682699\",\"package\":\"Sign=WXPay\",\"noncestr\":\"LrtslpP4Ur9ZGLM3\",\"timestamp\":1528523864,\"sign\":\"67B20AE9528DF40C8BEE00A5F46A81D8\"}}"}
     *//*

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
        *//**
         * openid : null
         * alipay_app_orderString :
         * pay_sn : 100581867864211016
         * notify_url : http://ta.beikunit.com/api/notifyurl/wx_notify
         * wechat_app_orderString : {"error":0,"result":{"partnerid":"1507318451","appid":"wx54fa8a2ea47c977b","prepayid":"wx09135744382791bc902f30791801682699","package":"Sign=WXPay","noncestr":"LrtslpP4Ur9ZGLM3","timestamp":1528523864,"sign":"67B20AE9528DF40C8BEE00A5F46A81D8"}}
         *//*

        private Object openid;
        private String alipay_app_orderString;
        private String pay_sn;
        private String notify_url;
        private String wechat_app_orderString;

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public String getAlipay_app_orderString() {
            return alipay_app_orderString;
        }

        public void setAlipay_app_orderString(String alipay_app_orderString) {
            this.alipay_app_orderString = alipay_app_orderString;
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

        public String getWechat_app_orderString() {
            return wechat_app_orderString;
        }

        public void setWechat_app_orderString(String wechat_app_orderString) {
            this.wechat_app_orderString = wechat_app_orderString;
        }
    }*/

//    *
//     * is_success : true
//     * message : 操作成功
//     * data : {"openid":null,"alipay_app_orderString":"alipay_sdk=alipay-sdk-php-20161101&amp;app_id=2018060160317416&amp;biz_content=%7B%22body%22%3A%221-%22%2C%22subject%22%3A+%22%E7%80%9A%E8%97%8F%E6%94%AF%E4%BB%98%22%2C%22out_trade_no%22%3A+%22520581781427721016%22%2C%22timeout_express%22%3A+%2230m%22%2C%22total_amount%22%3A+%22%24amount%22%2C%22product_code%22%3A%2216%22%7D&amp;charset=UTF-8&amp;format=json&amp;method=alipay.trade.app.pay&amp;notify_url=http%3A%2F%2Fta.beikunit.com%2Fapi%2Fnotifyurl%2Falipay_notify&amp;sign_type=RSA2&amp;timestamp=2018-06-08+13%3A57%3A07&amp;version=1.0&amp;sign=MHlN3deya3iWoAHN64vXxrPsDNh3ThESyf49K3wH%2Bc0rZOa4nQ1ajHcJkXIRCXjAhoJ0vsF1Iw3kSJ6laxokdZYX1kPMLBfJRwtH9zKIduCz84Wksmw36EuMFIHbFkS5kI4mAocU4wKuhunArBxPP9Kzc1RQNLSNYX4oYMOejTx6hWFZqrxmeu1NrWqIIiekt%2Bp7scEAdIcesqVHNV5%2Fy5Wz%2BlwFbJ5cUb26TvKN94e6gYWYvacevKkpQwZdwaFroVZi2n4AwkM442bITxBWzCQflBV0YdjsKcv%2FWzEn%2B8zW93gl117RB7fWyW3DVufvAQJJX6TgIF69KKUtHNQ5fg%3D%3D","pay_sn":"520581781427721016","notify_url":"http://ta.beikunit.com/api/notifyurl/alipay_notify","aliapy_pid":"2088131106864170","aliapy_private_key":"MIIEpAIBAAKCAQEA0b0pSPnkhTy1L3OXy+SJatdevekUtE4LMLzZ3YWXd8Nb8Cwcewm2PpzWBlPhhMyfvr5CfnVFONUWnuT4sTlVOTvuFnXSudhkv9hHO4fqwKqQn4xO61GJVoPvDjEAIrn8oRZAJRTsTwy8ZbB9C6tvAduNmmjwhwiujNqVul/QbUx4ZxrihIr3qReHJpozlbW74CmoXyki+7bbOaQQMVmXXppwSA4U4o6E80Fa2NL84GW5wifh55DYX9qIfxXohrv4gv53bpROCtMgYVB6BHa8vFJGI4RSYiF69vIyJZP1Dm+vbWgM2tedEvajgI6jWXaafelJapWd2JmqvXsYiPC5UQIDAQABAoIBABzWiH2rNluHfFYY668yLh7NnA46pQkhjfJWlRIbUzc5WkPMnOHh9Pfo8piOIfzzcad1W4ktsKXezqxsSTF885XaAqN98cpx0XB7WVf7GTECgr4dOaCrZlnJ7C2kWSNtNSok+A7hMJix5JmKyba4DJxRxseLVD8M14swZtPoZq0QTaSSHYaKUFBdQL0Z/lUUQEUVFoH8kpzazdHi9yCK6jUM9Fxj/8/HCVg9q3lDTMsi7r4/ejLZavxal/toFbb0W6JCcuPuSEKItzTlmPn/NLDXpy5PxnAvJKELpYgHEv0hFnziIxLATLHSTQ+Dy3WS8rOqpPMfNEaxaMPmLGwv6NECgYEA/fikSbU4LjFwYMu8cfnClK5KgbIbANCpIhVpOKajJxBfIJWfBBpELvNO2G/jbAf7z6rXUymNKVU9ZQXKyuh2bB+sv3MsYFCJ8LeLfliUGsM7hKjfNRGK3WKttrwiJHXDafolNV403lcg13Fg/skn+hrQc5umPI5cNFfFFUoEio0CgYEA02oRDs4ifp3u4aZxlpD+2RZGkvjDy+66WZR7llsC9AOYQZiSHg5aYksXMcj3k2PMssz1zeNFOsuc7h7OepLgl4kSyXF4zG/L2ZB2Q2rg797/vkUQxBwDizFWR1FWAFGlfgPKwU1SrH3CkSvRxDrlXFQO9aJFR5xL2mtPN5g7utUCgYAf8I8oveOs24bYhYbThqeT7z9rhCylM5ixsqOi/kHyfbqY7HgtGeiNRwgZbCjbwz1F5qRhzw3zrsaj19CjKA0MmAcvpJpmGnrejRa78wPdQcRQcLRxhh1CrlBOdOaOU0kaIN1hEtHvTGHS9m1OXZnreEfS4jZL01OBObCNdtuPWQKBgQDFlcGvdpPihjQ2DFrof0bPGPSIc5p6Q/lBs3X1xcVyzNFFrRQSpxNt/gQFcW+A/qrXCJtJ+vg+xQE7wuryv8bLmT5Hqpddaba49TyyMXdcd6vI5b+PqSbethOOv8OCtMvYhC7AjkWQFFD9YFjB7tFhguYgR7I8BSUXU2dL7CkWqQKBgQCNO6AgVwzXtSbbmrc6cs2k0/YfJ2Tbb203hxRzc4p27KLRh/5/U5mVEEQPTLBrQQ58burinFb277UX66jGu+TLrWD0Ga1n0ltegZWUpJtzET713yv6tfJslgSavfOmEUW2IiqrAqyGJsDCZUJ0UrFzcxNXlxXyFmO4mjooXTt9ag==","aliapy_account":"xingzheng@hancang.cn"}
//

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
       /* *
         * openid : null
         * alipay_app_orderString : alipay_sdk=alipay-sdk-php-20161101&amp;app_id=2018060160317416&amp;biz_content=%7B%22body%22%3A%221-%22%2C%22subject%22%3A+%22%E7%80%9A%E8%97%8F%E6%94%AF%E4%BB%98%22%2C%22out_trade_no%22%3A+%22520581781427721016%22%2C%22timeout_express%22%3A+%2230m%22%2C%22total_amount%22%3A+%22%24amount%22%2C%22product_code%22%3A%2216%22%7D&amp;charset=UTF-8&amp;format=json&amp;method=alipay.trade.app.pay&amp;notify_url=http%3A%2F%2Fta.beikunit.com%2Fapi%2Fnotifyurl%2Falipay_notify&amp;sign_type=RSA2&amp;timestamp=2018-06-08+13%3A57%3A07&amp;version=1.0&amp;sign=MHlN3deya3iWoAHN64vXxrPsDNh3ThESyf49K3wH%2Bc0rZOa4nQ1ajHcJkXIRCXjAhoJ0vsF1Iw3kSJ6laxokdZYX1kPMLBfJRwtH9zKIduCz84Wksmw36EuMFIHbFkS5kI4mAocU4wKuhunArBxPP9Kzc1RQNLSNYX4oYMOejTx6hWFZqrxmeu1NrWqIIiekt%2Bp7scEAdIcesqVHNV5%2Fy5Wz%2BlwFbJ5cUb26TvKN94e6gYWYvacevKkpQwZdwaFroVZi2n4AwkM442bITxBWzCQflBV0YdjsKcv%2FWzEn%2B8zW93gl117RB7fWyW3DVufvAQJJX6TgIF69KKUtHNQ5fg%3D%3D
         * pay_sn : 520581781427721016
         * notify_url : http://ta.beikunit.com/api/notifyurl/alipay_notify
         * aliapy_pid : 2088131106864170
         * aliapy_private_key : MIIEpAIBAAKCAQEA0b0pSPnkhTy1L3OXy+SJatdevekUtE4LMLzZ3YWXd8Nb8Cwcewm2PpzWBlPhhMyfvr5CfnVFONUWnuT4sTlVOTvuFnXSudhkv9hHO4fqwKqQn4xO61GJVoPvDjEAIrn8oRZAJRTsTwy8ZbB9C6tvAduNmmjwhwiujNqVul/QbUx4ZxrihIr3qReHJpozlbW74CmoXyki+7bbOaQQMVmXXppwSA4U4o6E80Fa2NL84GW5wifh55DYX9qIfxXohrv4gv53bpROCtMgYVB6BHa8vFJGI4RSYiF69vIyJZP1Dm+vbWgM2tedEvajgI6jWXaafelJapWd2JmqvXsYiPC5UQIDAQABAoIBABzWiH2rNluHfFYY668yLh7NnA46pQkhjfJWlRIbUzc5WkPMnOHh9Pfo8piOIfzzcad1W4ktsKXezqxsSTF885XaAqN98cpx0XB7WVf7GTECgr4dOaCrZlnJ7C2kWSNtNSok+A7hMJix5JmKyba4DJxRxseLVD8M14swZtPoZq0QTaSSHYaKUFBdQL0Z/lUUQEUVFoH8kpzazdHi9yCK6jUM9Fxj/8/HCVg9q3lDTMsi7r4/ejLZavxal/toFbb0W6JCcuPuSEKItzTlmPn/NLDXpy5PxnAvJKELpYgHEv0hFnziIxLATLHSTQ+Dy3WS8rOqpPMfNEaxaMPmLGwv6NECgYEA/fikSbU4LjFwYMu8cfnClK5KgbIbANCpIhVpOKajJxBfIJWfBBpELvNO2G/jbAf7z6rXUymNKVU9ZQXKyuh2bB+sv3MsYFCJ8LeLfliUGsM7hKjfNRGK3WKttrwiJHXDafolNV403lcg13Fg/skn+hrQc5umPI5cNFfFFUoEio0CgYEA02oRDs4ifp3u4aZxlpD+2RZGkvjDy+66WZR7llsC9AOYQZiSHg5aYksXMcj3k2PMssz1zeNFOsuc7h7OepLgl4kSyXF4zG/L2ZB2Q2rg797/vkUQxBwDizFWR1FWAFGlfgPKwU1SrH3CkSvRxDrlXFQO9aJFR5xL2mtPN5g7utUCgYAf8I8oveOs24bYhYbThqeT7z9rhCylM5ixsqOi/kHyfbqY7HgtGeiNRwgZbCjbwz1F5qRhzw3zrsaj19CjKA0MmAcvpJpmGnrejRa78wPdQcRQcLRxhh1CrlBOdOaOU0kaIN1hEtHvTGHS9m1OXZnreEfS4jZL01OBObCNdtuPWQKBgQDFlcGvdpPihjQ2DFrof0bPGPSIc5p6Q/lBs3X1xcVyzNFFrRQSpxNt/gQFcW+A/qrXCJtJ+vg+xQE7wuryv8bLmT5Hqpddaba49TyyMXdcd6vI5b+PqSbethOOv8OCtMvYhC7AjkWQFFD9YFjB7tFhguYgR7I8BSUXU2dL7CkWqQKBgQCNO6AgVwzXtSbbmrc6cs2k0/YfJ2Tbb203hxRzc4p27KLRh/5/U5mVEEQPTLBrQQ58burinFb277UX66jGu+TLrWD0Ga1n0ltegZWUpJtzET713yv6tfJslgSavfOmEUW2IiqrAqyGJsDCZUJ0UrFzcxNXlxXyFmO4mjooXTt9ag==
         * aliapy_account : xingzheng@hancang.cn*/


        private String openid;
        private String alipay_app_orderString;
        private String pay_sn;
        private String notify_url;
        private String aliapy_pid;
        private String aliapy_private_key;
        private String aliapy_account;
        private String wechat_app_orderString;

        public String getWechat_app_orderString() {
            return wechat_app_orderString;
        }

        public void setWechat_app_orderString(String wechat_app_orderString) {
            this.wechat_app_orderString = wechat_app_orderString;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getAlipay_app_orderString() {
            return alipay_app_orderString;
        }

        public void setAlipay_app_orderString(String alipay_app_orderString) {
            this.alipay_app_orderString = alipay_app_orderString;
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

        public String getAliapy_pid() {
            return aliapy_pid;
        }

        public void setAliapy_pid(String aliapy_pid) {
            this.aliapy_pid = aliapy_pid;
        }

        public String getAliapy_private_key() {
            return aliapy_private_key;
        }

        public void setAliapy_private_key(String aliapy_private_key) {
            this.aliapy_private_key = aliapy_private_key;
        }

        public String getAliapy_account() {
            return aliapy_account;
        }

        public void setAliapy_account(String aliapy_account) {
            this.aliapy_account = aliapy_account;
        }
    }

}
