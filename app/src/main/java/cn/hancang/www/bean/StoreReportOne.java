package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-下午 14:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreReportOne {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"has_taken":0,"has_taken_count":0,"paid":0,"paid_count":0,"refunded":0,"refunded_count":0,"received":0,"received_count":0,"unshipped":0,"unshipped_count":0,"unconfirmed":0,"unconfirmed_count":0,"refunding":0,"refunding_count":0,"return_goods":0,"return_goods_count":0}
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
         * has_taken : 0
         * has_taken_count : 0
         * paid : 0
         * paid_count : 0
         * refunded : 0
         * refunded_count : 0
         * received : 0
         * received_count : 0
         * unshipped : 0
         * unshipped_count : 0
         * unconfirmed : 0
         * unconfirmed_count : 0
         * refunding : 0
         * refunding_count : 0
         * return_goods : 0
         * return_goods_count : 0
         */

        private int has_taken;
        private int has_taken_count;
        private int paid;
        private int paid_count;
        private int refunded;
        private int refunded_count;
        private int received;
        private int received_count;
        private int unshipped;
        private int unshipped_count;
        private int unconfirmed;
        private int unconfirmed_count;
        private int refunding;
        private int refunding_count;
        private int return_goods;
        private int return_goods_count;

        public int getHas_taken() {
            return has_taken;
        }

        public void setHas_taken(int has_taken) {
            this.has_taken = has_taken;
        }

        public int getHas_taken_count() {
            return has_taken_count;
        }

        public void setHas_taken_count(int has_taken_count) {
            this.has_taken_count = has_taken_count;
        }

        public int getPaid() {
            return paid;
        }

        public void setPaid(int paid) {
            this.paid = paid;
        }

        public int getPaid_count() {
            return paid_count;
        }

        public void setPaid_count(int paid_count) {
            this.paid_count = paid_count;
        }

        public int getRefunded() {
            return refunded;
        }

        public void setRefunded(int refunded) {
            this.refunded = refunded;
        }

        public int getRefunded_count() {
            return refunded_count;
        }

        public void setRefunded_count(int refunded_count) {
            this.refunded_count = refunded_count;
        }

        public int getReceived() {
            return received;
        }

        public void setReceived(int received) {
            this.received = received;
        }

        public int getReceived_count() {
            return received_count;
        }

        public void setReceived_count(int received_count) {
            this.received_count = received_count;
        }

        public int getUnshipped() {
            return unshipped;
        }

        public void setUnshipped(int unshipped) {
            this.unshipped = unshipped;
        }

        public int getUnshipped_count() {
            return unshipped_count;
        }

        public void setUnshipped_count(int unshipped_count) {
            this.unshipped_count = unshipped_count;
        }

        public int getUnconfirmed() {
            return unconfirmed;
        }

        public void setUnconfirmed(int unconfirmed) {
            this.unconfirmed = unconfirmed;
        }

        public int getUnconfirmed_count() {
            return unconfirmed_count;
        }

        public void setUnconfirmed_count(int unconfirmed_count) {
            this.unconfirmed_count = unconfirmed_count;
        }

        public int getRefunding() {
            return refunding;
        }

        public void setRefunding(int refunding) {
            this.refunding = refunding;
        }

        public int getRefunding_count() {
            return refunding_count;
        }

        public void setRefunding_count(int refunding_count) {
            this.refunding_count = refunding_count;
        }

        public int getReturn_goods() {
            return return_goods;
        }

        public void setReturn_goods(int return_goods) {
            this.return_goods = return_goods;
        }

        public int getReturn_goods_count() {
            return return_goods_count;
        }

        public void setReturn_goods_count(int return_goods_count) {
            this.return_goods_count = return_goods_count;
        }
    }
}
