package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午12:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDeatilBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : [{"type":1,"amount":"240","date":"2018-3-1 10:00:00"},{"type":2,"amount":"240","date":"2018-3-1 10:00:00"},{"type":1,"amount":"240","date":"2018-3-1 10:00:00"}]
     */

    private boolean is_success;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 1
         * amount : 240
         * date : 2018-3-1 10:00:00
         */

        private int type;
        private String amount;
        private String date;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
