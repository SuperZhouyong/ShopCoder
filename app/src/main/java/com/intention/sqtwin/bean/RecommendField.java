package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/20-上午12:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RecommendField {

    /**
     * is_success : true
     * message : 操作成功
     * data : [{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}]
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
         * name : 拍场名称
         * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
         * is_favorite : false
         * start_time : 2018-2-1 10:00:00
         * end_time : 2018-3-1 10:00:00
         * item_count : 50
         * bid_count : 50
         * fans_count : 500
         * organzation : {"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}
         */

        private int id;
        private String name;
        private String image;
        private String is_favorite;
        private String start_time;
        private String end_time;
        private String item_count;
        private String bid_count;
        private String fans_count;
        private OrganzationBean organzation;

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

        public String getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(String is_favorite) {
            this.is_favorite = is_favorite;
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

        public String getItem_count() {
            return item_count;
        }

        public void setItem_count(String item_count) {
            this.item_count = item_count;
        }

        public String getBid_count() {
            return bid_count;
        }

        public void setBid_count(String bid_count) {
            this.bid_count = bid_count;
        }

        public String getFans_count() {
            return fans_count;
        }

        public void setFans_count(String fans_count) {
            this.fans_count = fans_count;
        }

        public OrganzationBean getOrganzation() {
            return organzation;
        }

        public void setOrganzation(OrganzationBean organzation) {
            this.organzation = organzation;
        }

        public static class OrganzationBean {
            /**
             * id : 5
             * name : 拍卖机构名称
             * logo : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg
             */

            private String id;
            private String name;
            private String logo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }
    }
}
