package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-上午1:01
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AllStoreListBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"store_list":[{"store_id":69,"store_name":"君子万年","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/69/oss_69_2018070511362635425.jpg"},{"store_id":70,"store_name":"小羊","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/20180607102151/03571B1B-EAF4-2D7F-A0C1-13C082C1864B."},{"store_id":71,"store_name":"","store_logo":null},{"store_id":72,"store_name":"","store_logo":null},{"store_id":73,"store_name":"曾平手作","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/123/oss_123_2018061513480426798.jpg"},{"store_id":74,"store_name":"川乐","store_logo":""}],"total_page":16}
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
         * store_list : [{"store_id":69,"store_name":"君子万年","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/69/oss_69_2018070511362635425.jpg"},{"store_id":70,"store_name":"小羊","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/20180607102151/03571B1B-EAF4-2D7F-A0C1-13C082C1864B."},{"store_id":71,"store_name":"","store_logo":null},{"store_id":72,"store_name":"","store_logo":null},{"store_id":73,"store_name":"曾平手作","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/123/oss_123_2018061513480426798.jpg"},{"store_id":74,"store_name":"川乐","store_logo":""}]
         * total_page : 16
         */

        private int total_page;
        private List<StoreListBean> store_list;

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<StoreListBean> getStore_list() {
            return store_list;
        }

        public void setStore_list(List<StoreListBean> store_list) {
            this.store_list = store_list;
        }

        public static class StoreListBean {
            /**
             * store_id : 69
             * store_name : 君子万年
             * store_logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/69/oss_69_2018070511362635425.jpg
             */

            private int store_id;
            private String store_name;
            private String store_logo;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getStore_logo() {
                return store_logo;
            }

            public void setStore_logo(String store_logo) {
                this.store_logo = store_logo;
            }
        }
    }
}
