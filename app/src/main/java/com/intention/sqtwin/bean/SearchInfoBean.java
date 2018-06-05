package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/30 0030-上午 10:38
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"item_list":[{"id":257,"name":"test1","start_price":"123.00","commission":"0.05","deposit":"456.00","auction_field_id":43,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052415091823005.png","current_price":"123.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":256,"name":"123123","start_price":"1.00","commission":"0.05","deposit":"1.00","auction_field_id":45,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052415101735521.png","current_price":"1.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":254,"name":"ceshi123123","start_price":"2.00","commission":"0.05","deposit":"1.00","auction_field_id":45,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052215560220387.png","current_price":"2.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":199,"name":"Lot0016 清早期榆木缸架","start_price":"18000.00","commission":"0.05","deposit":"12000.00","auction_field_id":37,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164818107.jpg","current_price":"18000.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":196,"name":"Lot0007 明代槐木楠木双拼佛龛","start_price":"46000.00","commission":"0.05","deposit":"40000.00","auction_field_id":27,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415051069530.jpg","current_price":"54000.00","bid_leader":"张晓翔","fans_count":0,"bid_count":8},{"id":192,"name":"Lot0001 明代晋作榆木官帽椅","start_price":"10000.00","commission":"0.05","deposit":"1000.00","auction_field_id":27,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050413130635227.jpg","current_price":"42000.00","bid_leader":"张晓翔","fans_count":1,"bid_count":20}],"page_count":2}
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
         * item_list : [{"id":257,"name":"test1","start_price":"123.00","commission":"0.05","deposit":"456.00","auction_field_id":43,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052415091823005.png","current_price":"123.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":256,"name":"123123","start_price":"1.00","commission":"0.05","deposit":"1.00","auction_field_id":45,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052415101735521.png","current_price":"1.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":254,"name":"ceshi123123","start_price":"2.00","commission":"0.05","deposit":"1.00","auction_field_id":45,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052215560220387.png","current_price":"2.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":199,"name":"Lot0016 清早期榆木缸架","start_price":"18000.00","commission":"0.05","deposit":"12000.00","auction_field_id":37,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164818107.jpg","current_price":"18000.00","bid_leader":"暂无","fans_count":0,"bid_count":0},{"id":196,"name":"Lot0007 明代槐木楠木双拼佛龛","start_price":"46000.00","commission":"0.05","deposit":"40000.00","auction_field_id":27,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415051069530.jpg","current_price":"54000.00","bid_leader":"张晓翔","fans_count":0,"bid_count":8},{"id":192,"name":"Lot0001 明代晋作榆木官帽椅","start_price":"10000.00","commission":"0.05","deposit":"1000.00","auction_field_id":27,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050413130635227.jpg","current_price":"42000.00","bid_leader":"张晓翔","fans_count":1,"bid_count":20}]
         * page_count : 2
         */

        private int page_count;
        private List<ItemListBean> item_list;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public static class ItemListBean {
            /**
             * id : 257
             * name : test1
             * start_price : 123.00
             * commission : 0.05
             * deposit : 456.00
             * auction_field_id : 43
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052415091823005.png
             * current_price : 123.00
             * bid_leader : 暂无
             * fans_count : 0
             * bid_count : 0
             */

            private int id;
            private String name;
            private String start_price;
            private String commission;
            private String deposit;
            private int auction_field_id;
            private String image;
            private String current_price;
            private String bid_leader;
            private int fans_count;
            private int bid_count;

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

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
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

            public String getBid_leader() {
                return bid_leader;
            }

            public void setBid_leader(String bid_leader) {
                this.bid_leader = bid_leader;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public int getBid_count() {
                return bid_count;
            }

            public void setBid_count(int bid_count) {
                this.bid_count = bid_count;
            }
        }
    }
}
