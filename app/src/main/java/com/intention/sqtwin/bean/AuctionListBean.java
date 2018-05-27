package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午2:20
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionListBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"item_list":[{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":"2000.00","current_price":"2000.00"}],"page_count":1}
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
         * item_list : [{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":"2000.00","current_price":"2000.00"}]
         * page_count : 1
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
             * id : 171
             * name : a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg
             * start_price : 2000.00
             * current_price : 2000.00
             */

            private int id;
            private String name;
            private String image;
            private String start_price;
            private String current_price;

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

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }
        }
    }
}
