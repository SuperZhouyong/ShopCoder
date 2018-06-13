package cn.hancang.www.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:01
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"store_id":40,"store_name":"男的女的就到家觉得就到家男的女的你你的呢","store_logo":"难兄难弟男的女的那你","store_description":"http://hancang.oss-cn-beijing.aliyuncs.com/20180529104531/92F8395B-B1E8-92ED-53EE-93A2478FDD5A.jpg","store_banner":null,"fans_count":0}
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
         * store_id : 40
         * store_name : 男的女的就到家觉得就到家男的女的你你的呢
         * store_logo : 难兄难弟男的女的那你
         * store_description : http://hancang.oss-cn-beijing.aliyuncs.com/20180529104531/92F8395B-B1E8-92ED-53EE-93A2478FDD5A.jpg
         * store_banner : null
         * fans_count : 0
         */

        private int store_id;
        private String store_name;
        private String store_logo;
        private String store_description;
        private Object store_banner;
        private int fans_count;

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

        public String getStore_description() {
            return store_description;
        }

        public void setStore_description(String store_description) {
            this.store_description = store_description;
        }

        public Object getStore_banner() {
            return store_banner;
        }

        public void setStore_banner(Object store_banner) {
            this.store_banner = store_banner;
        }

        public int getFans_count() {
            return fans_count;
        }

        public void setFans_count(int fans_count) {
            this.fans_count = fans_count;
        }
    }
}
