package cn.hancang.www.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-下午 15:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreReportTwo {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"fans":0,"fans_add":0,"publish_count":31,"payment_number":0,"scale":0}
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
         * fans : 0
         * fans_add : 0
         * publish_count : 31
         * payment_number : 0
         * scale : 0
         */

        private int fans;
        private int fans_add;
        private int publish_count;
        private int payment_number;
        private int scale;

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getFans_add() {
            return fans_add;
        }

        public void setFans_add(int fans_add) {
            this.fans_add = fans_add;
        }

        public int getPublish_count() {
            return publish_count;
        }

        public void setPublish_count(int publish_count) {
            this.publish_count = publish_count;
        }

        public int getPayment_number() {
            return payment_number;
        }

        public void setPayment_number(int payment_number) {
            this.payment_number = payment_number;
        }

        public int getScale() {
            return scale;
        }

        public void setScale(int scale) {
            this.scale = scale;
        }
    }
}
