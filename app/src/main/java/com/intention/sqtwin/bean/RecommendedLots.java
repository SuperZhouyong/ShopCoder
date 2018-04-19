package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午11:45
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RecommendedLots {

    /**
     * is_success : true
     * message : 操作成功
     * data : [{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"},{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"},{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"}]
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
         * id : 5
         * name : 拍品名称
         * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
         * current_price : 888
         * start_price : 666
         * bid_leader : 石头
         */

        private int id;
        private String name;
        private String image;
        private String current_price;
        private String start_price;
        private String bid_leader;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCurrent_price() {
            return current_price;
        }

        public void setCurrent_price(String current_price) {
            this.current_price = current_price;
        }

        public String getStart_price() {
            return start_price;
        }

        public void setStart_price(String start_price) {
            this.start_price = start_price;
        }

        public String getBid_leader() {
            return bid_leader;
        }

        public void setBid_leader(String bid_leader) {
            this.bid_leader = bid_leader;
        }
    }
}
