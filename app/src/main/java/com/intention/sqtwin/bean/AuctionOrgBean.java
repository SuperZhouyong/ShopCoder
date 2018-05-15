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
     * data : {"organization_info":{"organization_id":1,"name":"中国嘉德","image":"","logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_38692_2018042608251131882.png","create_time":"2018-04-04 13:53:18","description":"中国嘉德","fans_count":1,"goods_count":21},"auction_field_list":[{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":21,"bid_count":7,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-02 00:05:00","end_time":"2018-12-31 00:05:00"}]}
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
         * organization_info : {"organization_id":1,"name":"中国嘉德","image":"","logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_38692_2018042608251131882.png","create_time":"2018-04-04 13:53:18","description":"中国嘉德","fans_count":1,"goods_count":21}
         * auction_field_list : [{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":21,"bid_count":7,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-02 00:05:00","end_time":"2018-12-31 00:05:00"}]
         */

        private OrganizationInfoBean organization_info;
        private List<AuctionFieldListBean> auction_field_list;

        public OrganizationInfoBean getOrganization_info() {
            return organization_info;
        }

        public void setOrganization_info(OrganizationInfoBean organization_info) {
            this.organization_info = organization_info;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class OrganizationInfoBean {
            /**
             * organization_id : 1
             * name : 中国嘉德
             * image :
             * logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_38692_2018042608251131882.png
             * create_time : 2018-04-04 13:53:18
             * description : 中国嘉德
             * fans_count : 1
             * goods_count : 21
             */

            private int organization_id;
            private String name;
            private String image;
            private String logo;
            private String create_time;
            private String description;
            private int fans_count;
            private int goods_count;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public int getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(int goods_count) {
                this.goods_count = goods_count;
            }
        }

        public static class AuctionFieldListBean {
            /**
             * id : 26
             * name : 集萃斋玉器杂项
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg
             * organization_id : 1
             * is_favorite : true
             * item_count : 21
             * bid_count : 7
             * fans_count : 0
             * organization : {"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"}
             * start_time : 2018-05-02 00:05:00
             * end_time : 2018-12-31 00:05:00
             */

            private int id;
            private String name;
            private String image;
            private int organization_id;
            private String is_favorite;
            private int item_count;
            private int bid_count;
            private int fans_count;
            private OrganizationBean organization;
            private String start_time;
            private String end_time;

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

            public int getOrganization_id() {
                return organization_id;
            }

            public void setOrganization_id(int organization_id) {
                this.organization_id = organization_id;
            }

            public String getIs_favorite() {
                return is_favorite;
            }

            public void setIs_favorite(String is_favorite) {
                this.is_favorite = is_favorite;
            }

            public int getItem_count() {
                return item_count;
            }

            public void setItem_count(int item_count) {
                this.item_count = item_count;
            }

            public int getBid_count() {
                return bid_count;
            }

            public void setBid_count(int bid_count) {
                this.bid_count = bid_count;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public OrganizationBean getOrganization() {
                return organization;
            }

            public void setOrganization(OrganizationBean organization) {
                this.organization = organization;
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

            public static class OrganizationBean {
                /**
                 * organization_id : 1
                 * name : 中国嘉德
                 * image :
                 * is_favorite : true
                 */

                private int organization_id;
                private String name;
                private String image;
                private String is_favorite;

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
            }
        }
    }
}
