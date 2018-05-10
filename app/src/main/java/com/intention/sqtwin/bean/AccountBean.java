package com.intention.sqtwin.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午1:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"available_predeposit":"0.00","freeze_predeposit":"0.00"}
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
         * available_predeposit : 0.00
         * freeze_predeposit : 0.00
         */

        private String available_predeposit;
        private String freeze_predeposit;

        public String getAvailable_predeposit() {
            return available_predeposit;
        }

        public void setAvailable_predeposit(String available_predeposit) {
            this.available_predeposit = available_predeposit;
        }

        public String getFreeze_predeposit() {
            return freeze_predeposit;
        }

        public void setFreeze_predeposit(String freeze_predeposit) {
            this.freeze_predeposit = freeze_predeposit;
        }
    }
}
