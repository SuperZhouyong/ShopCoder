package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:46
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemDetailBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"item_info":{"goods_id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"","start_time":"2018-05-07 15:05:00","end_time":"2018-05-15 00:05:00","start_price":10000,"increment_type":1,"increment_value":500,"commission":"0.05","deposit":"10000.00","auction_field_id":26,"mobile_body":"","current_price":10000,"fans_count":""},"staff_list":[],"artist_info":{},"price_list":[]}
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
         * item_info : {"goods_id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"","start_time":"2018-05-07 15:05:00","end_time":"2018-05-15 00:05:00","start_price":10000,"increment_type":1,"increment_value":500,"commission":"0.05","deposit":"10000.00","auction_field_id":26,"mobile_body":"","current_price":10000,"fans_count":""}
         * staff_list : []
         * artist_info : {}
         * price_list : []
         */

        private ItemInfoBean item_info;
        private ArtistInfoBean artist_info;
        private List<?> staff_list;
        private List<?> price_list;

        public ItemInfoBean getItem_info() {
            return item_info;
        }

        public void setItem_info(ItemInfoBean item_info) {
            this.item_info = item_info;
        }

        public ArtistInfoBean getArtist_info() {
            return artist_info;
        }

        public void setArtist_info(ArtistInfoBean artist_info) {
            this.artist_info = artist_info;
        }

        public List<?> getStaff_list() {
            return staff_list;
        }

        public void setStaff_list(List<?> staff_list) {
            this.staff_list = staff_list;
        }

        public List<?> getPrice_list() {
            return price_list;
        }

        public void setPrice_list(List<?> price_list) {
            this.price_list = price_list;
        }

        public static class ItemInfoBean {
            /**
             * goods_id : 172
             * name : a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架
             * image :
             * start_time : 2018-05-07 15:05:00
             * end_time : 2018-05-15 00:05:00
             * start_price : 10000
             * increment_type : 1
             * increment_value : 500
             * commission : 0.05
             * deposit : 10000.00
             * auction_field_id : 26
             * mobile_body :
             * current_price : 10000
             * fans_count :
             */

            private int goods_id;
            private String name;
            private String image;
            private String start_time;
            private String end_time;
            private int start_price;
            private int increment_type;
            private int increment_value;
            private String commission;
            private String deposit;
            private int auction_field_id;
            private String mobile_body;
            private int current_price;
            private String fans_count;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
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

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getStart_price() {
                return start_price;
            }

            public void setStart_price(int start_price) {
                this.start_price = start_price;
            }

            public int getIncrement_type() {
                return increment_type;
            }

            public void setIncrement_type(int increment_type) {
                this.increment_type = increment_type;
            }

            public int getIncrement_value() {
                return increment_value;
            }

            public void setIncrement_value(int increment_value) {
                this.increment_value = increment_value;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public String getDeposit() {
                return deposit;
            }

            public void setDeposit(String deposit) {
                this.deposit = deposit;
            }

            public int getAuction_field_id() {
                return auction_field_id;
            }

            public void setAuction_field_id(int auction_field_id) {
                this.auction_field_id = auction_field_id;
            }

            public String getMobile_body() {
                return mobile_body;
            }

            public void setMobile_body(String mobile_body) {
                this.mobile_body = mobile_body;
            }

            public int getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(int current_price) {
                this.current_price = current_price;
            }

            public String getFans_count() {
                return fans_count;
            }

            public void setFans_count(String fans_count) {
                this.fans_count = fans_count;
            }
        }

        public static class ArtistInfoBean {
        }
    }
}
