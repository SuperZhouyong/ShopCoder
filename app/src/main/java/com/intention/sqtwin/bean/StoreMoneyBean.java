package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-上午 10:36
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreMoneyBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"balance":0,"wait_pay":0,"wait_send":0,"wait_receive":0}
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
         * balance : 0
         * wait_pay : 0
         * wait_send : 0
         * wait_receive : 0
         */

        private int balance;
        private int wait_pay;
        private int wait_send;
        private int wait_receive;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getWait_pay() {
            return wait_pay;
        }

        public void setWait_pay(int wait_pay) {
            this.wait_pay = wait_pay;
        }

        public int getWait_send() {
            return wait_send;
        }

        public void setWait_send(int wait_send) {
            this.wait_send = wait_send;
        }

        public int getWait_receive() {
            return wait_receive;
        }

        public void setWait_receive(int wait_receive) {
            this.wait_receive = wait_receive;
        }
    }
}
