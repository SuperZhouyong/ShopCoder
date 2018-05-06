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
     * data : {"list":[{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":2000,"current_price":2000},{"id":180,"name":"a10540267 现代 和田浓绿碧玉苏工镂雕灵芝如意摆件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411033118183.jpg","start_price":1300,"current_price":1300},{"id":190,"name":"a10540335 20世纪80年代 和田白玉岁岁平安大玉璧","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg","start_price":12000,"current_price":12000}],"page_count":3}
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
         * list : [{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":2000,"current_price":2000},{"id":180,"name":"a10540267 现代 和田浓绿碧玉苏工镂雕灵芝如意摆件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411033118183.jpg","start_price":1300,"current_price":1300},{"id":190,"name":"a10540335 20世纪80年代 和田白玉岁岁平安大玉璧","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg","start_price":12000,"current_price":12000}]
         * page_count : 3
         */

        private int page_count;
        private List<ListBean> list;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 171
             * name : a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg
             * start_price : 2000
             * current_price : 2000
             */

            private int id;
            private String name;
            private String image;
            private int start_price;
            private int current_price;

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

            public int getStart_price() {
                return start_price;
            }

            public void setStart_price(int start_price) {
                this.start_price = start_price;
            }

            public int getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(int current_price) {
                this.current_price = current_price;
            }
        }
    }
}
