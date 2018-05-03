package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/3-下午10:40
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"organization_info":{"organization_id":5,"name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","fans_count":"888","goods_count":"88","description":"简介"},"auction_field_list":[{"id":0,"name":"拍场名称0","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称0","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":1,"name":"拍场名称1","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称1","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":2,"name":"拍场名称2","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称2","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":3,"name":"拍场名称3","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称3","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":4,"name":"拍场名称4","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称4","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称5","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称5","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":6,"name":"拍场名称6","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称6","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":7,"name":"拍场名称7","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称7","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":8,"name":"拍场名称8","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称8","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":9,"name":"拍场名称9","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称9","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}],"total_page":10}
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
         * organization_info : {"organization_id":5,"name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","fans_count":"888","goods_count":"88","description":"简介"}
         * auction_field_list : [{"id":0,"name":"拍场名称0","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称0","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":1,"name":"拍场名称1","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称1","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":2,"name":"拍场名称2","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称2","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":3,"name":"拍场名称3","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称3","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":4,"name":"拍场名称4","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称4","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称5","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称5","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":6,"name":"拍场名称6","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称6","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":7,"name":"拍场名称7","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称7","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":8,"name":"拍场名称8","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称8","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":9,"name":"拍场名称9","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称9","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}]
         * total_page : 10
         */

        private OrganizationInfoBean organization_info;
        private int total_page;
        private List<AuctionFieldListBean> auction_field_list;

        public OrganizationInfoBean getOrganization_info() {
            return organization_info;
        }

        public void setOrganization_info(OrganizationInfoBean organization_info) {
            this.organization_info = organization_info;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class OrganizationInfoBean {
            /**
             * organization_id : 5
             * name : 拍卖机构名称
             * logo : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * fans_count : 888
             * goods_count : 88
             * description : 简介
             */

            private int organization_id;
            private String name;
            private String logo;
            private String fans_count;
            private String goods_count;
            private String description;

            public int getOrganization_id() {
                return organization_id;
            }

            public void setOrganization_id(int organization_id) {
                this.organization_id = organization_id;
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

            public String getFans_count() {
                return fans_count;
            }

            public void setFans_count(String fans_count) {
                this.fans_count = fans_count;
            }

            public String getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(String goods_count) {
                this.goods_count = goods_count;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class AuctionFieldListBean {
            /**
             * id : 0
             * name : 拍场名称0
             * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * is_favorite : false
             * start_time : 2018-2-1 10:00:00
             * end_time : 2018-3-1 10:00:00
             * item_count : 50
             * bid_count : 50
             * fans_count : 500
             * organzation : {"id":"5","name":"拍卖机构名称0","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}
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
                 * name : 拍卖机构名称0
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
}
