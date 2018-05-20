package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午11:24
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreMessageBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : [{"storemsg_id":12,"storemt_code":"1","store_id":4,"storemsg_content":"1","storemsg_addtime":1,"storemsg_readids":"1","store_logo":"beijing.aliyuncs.com/home/store/goods/12/oss_12_2018051715511178174.png"}]
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
         * storemsg_id : 12
         * storemt_code : 1
         * store_id : 4
         * storemsg_content : 1
         * storemsg_addtime : 1
         * storemsg_readids : 1
         * store_logo : beijing.aliyuncs.com/home/store/goods/12/oss_12_2018051715511178174.png
         */

        private int storemsg_id;
        private String storemt_code;
        private int store_id;
        private String storemsg_content;
        private String storemsg_addtime;
        private String storemsg_readids;
        private String store_logo;

        public int getStoremsg_id() {
            return storemsg_id;
        }

        public void setStoremsg_id(int storemsg_id) {
            this.storemsg_id = storemsg_id;
        }

        public String getStoremt_code() {
            return storemt_code;
        }

        public void setStoremt_code(String storemt_code) {
            this.storemt_code = storemt_code;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public String getStoremsg_content() {
            return storemsg_content;
        }

        public void setStoremsg_content(String storemsg_content) {
            this.storemsg_content = storemsg_content;
        }

        public String getStoremsg_addtime() {
            return storemsg_addtime;
        }

        public void setStoremsg_addtime(String storemsg_addtime) {
            this.storemsg_addtime = storemsg_addtime;
        }

        public String getStoremsg_readids() {
            return storemsg_readids;
        }

        public void setStoremsg_readids(String storemsg_readids) {
            this.storemsg_readids = storemsg_readids;
        }

        public String getStore_logo() {
            return store_logo;
        }

        public void setStore_logo(String store_logo) {
            this.store_logo = store_logo;
        }
    }
}
