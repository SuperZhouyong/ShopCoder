package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:03
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"price":[{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"},{"id":5,"nickname":"会员昵称","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","bid_time":"2018-3-1 10:00:00","price":"1500","type":"0"}]}
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
        private List<PriceBean> price;

        public List<PriceBean> getPrice() {
            return price;
        }

        public void setPrice(List<PriceBean> price) {
            this.price = price;
        }

        public static class PriceBean {
            /**
             * id : 5
             * nickname : 会员昵称
             * avatar : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * bid_time : 2018-3-1 10:00:00
             * price : 1500
             * type : 0
             */

            private int id;
            private String nickname;
            private String avatar;
            private String bid_time;
            private String price;
            private String type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getBid_time() {
                return bid_time;
            }

            public void setBid_time(String bid_time) {
                this.bid_time = bid_time;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
