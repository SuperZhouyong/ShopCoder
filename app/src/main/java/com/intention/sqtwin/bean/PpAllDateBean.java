package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAllDateBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"main_category":[{"category_id":"0","name":"全部"},{"category_id":19,"name":"中国书画","image":"","parent_id":107,"create_time":"2018-04-19 13:17:13","description":"书画","display_order":11,"is_system":0},{"category_id":33,"name":"古典文献","image":"","parent_id":107,"create_time":"2018-04-19 13:32:47","description":"古典文献","display_order":22,"is_system":0},{"category_id":43,"name":"西画雕塑","image":"","parent_id":107,"create_time":"2018-04-19 13:36:02","description":"西画雕塑","display_order":0,"is_system":0},{"category_id":51,"name":"邮品钱币","image":"","parent_id":107,"create_time":"2018-04-19 13:38:21","description":"邮品钱币","display_order":0,"is_system":0},{"category_id":59,"name":"茶酒滋补","image":"","parent_id":107,"create_time":"2018-04-19 13:41:30","description":"茶酒滋补","display_order":0,"is_system":0},{"category_id":67,"name":"古董珍玩","image":"","parent_id":107,"create_time":"2018-04-19 13:44:12","description":"古董珍玩","display_order":0,"is_system":0},{"category_id":74,"name":"玉翠珠宝","image":"","parent_id":107,"create_time":"2018-04-19 14:05:11","description":"玉翠珠宝","display_order":0,"is_system":0},{"category_id":86,"name":"文玩杂项","image":"","parent_id":107,"create_time":"2018-04-19 14:13:49","description":"文玩杂项","display_order":0,"is_system":0},{"category_id":95,"name":"香道花道","image":"","parent_id":107,"create_time":"2018-04-19 14:28:04","description":"香道花道","display_order":0,"is_system":0},{"category_id":103,"name":"奢侈品","image":"","parent_id":107,"create_time":"2018-04-19 14:30:02","description":"奢侈品","display_order":8,"is_system":0}],"adv":[{"adv_id":23,"adv_title":"自营拍广告","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_74938_2018050511465791819.jpg"},{"adv_id":42,"adv_title":"自营拍首页1-1","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_40164_2018050511460795014.jpg"},{"adv_id":43,"adv_title":"自营拍首页1-2","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_38263_2018050511461975639.png"}],"auction_field_list":[{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":25,"fans_count":9,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"}],"total_page":1}
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
         * main_category : [{"category_id":"0","name":"全部"},{"category_id":19,"name":"中国书画","image":"","parent_id":107,"create_time":"2018-04-19 13:17:13","description":"书画","display_order":11,"is_system":0},{"category_id":33,"name":"古典文献","image":"","parent_id":107,"create_time":"2018-04-19 13:32:47","description":"古典文献","display_order":22,"is_system":0},{"category_id":43,"name":"西画雕塑","image":"","parent_id":107,"create_time":"2018-04-19 13:36:02","description":"西画雕塑","display_order":0,"is_system":0},{"category_id":51,"name":"邮品钱币","image":"","parent_id":107,"create_time":"2018-04-19 13:38:21","description":"邮品钱币","display_order":0,"is_system":0},{"category_id":59,"name":"茶酒滋补","image":"","parent_id":107,"create_time":"2018-04-19 13:41:30","description":"茶酒滋补","display_order":0,"is_system":0},{"category_id":67,"name":"古董珍玩","image":"","parent_id":107,"create_time":"2018-04-19 13:44:12","description":"古董珍玩","display_order":0,"is_system":0},{"category_id":74,"name":"玉翠珠宝","image":"","parent_id":107,"create_time":"2018-04-19 14:05:11","description":"玉翠珠宝","display_order":0,"is_system":0},{"category_id":86,"name":"文玩杂项","image":"","parent_id":107,"create_time":"2018-04-19 14:13:49","description":"文玩杂项","display_order":0,"is_system":0},{"category_id":95,"name":"香道花道","image":"","parent_id":107,"create_time":"2018-04-19 14:28:04","description":"香道花道","display_order":0,"is_system":0},{"category_id":103,"name":"奢侈品","image":"","parent_id":107,"create_time":"2018-04-19 14:30:02","description":"奢侈品","display_order":8,"is_system":0}]
         * adv : [{"adv_id":23,"adv_title":"自营拍广告","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_74938_2018050511465791819.jpg"},{"adv_id":42,"adv_title":"自营拍首页1-1","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_40164_2018050511460795014.jpg"},{"adv_id":43,"adv_title":"自营拍首页1-2","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_38263_2018050511461975639.png"}]
         * auction_field_list : [{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":25,"fans_count":9,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"}]
         * total_page : 1
         */

        private int total_page;
        private List<MainCategoryBean> main_category;
        private List<AdvBean> adv;
        private List<AuctionFieldListBean> auction_field_list;

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<MainCategoryBean> getMain_category() {
            return main_category;
        }

        public void setMain_category(List<MainCategoryBean> main_category) {
            this.main_category = main_category;
        }

        public List<AdvBean> getAdv() {
            return adv;
        }

        public void setAdv(List<AdvBean> adv) {
            this.adv = adv;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class MainCategoryBean {
            /**
             * category_id : 0
             * name : 全部
             * image :
             * parent_id : 107
             * create_time : 2018-04-19 13:17:13
             * description : 书画
             * display_order : 11
             * is_system : 0
             */

            private String category_id;
            private String name;
            private String image;
            private int parent_id;
            private String create_time;
            private String description;
            private int display_order;
            private int is_system;

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
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

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
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

            public int getDisplay_order() {
                return display_order;
            }

            public void setDisplay_order(int display_order) {
                this.display_order = display_order;
            }

            public int getIs_system() {
                return is_system;
            }

            public void setIs_system(int is_system) {
                this.is_system = is_system;
            }
        }

        public static class AdvBean {
            /**
             * adv_id : 23
             * adv_title : 自营拍广告
             * link :
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_74938_2018050511465791819.jpg
             */

            private int adv_id;
            private String adv_title;
            private String link;
            private String image;

            public int getAdv_id() {
                return adv_id;
            }

            public void setAdv_id(int adv_id) {
                this.adv_id = adv_id;
            }

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class AuctionFieldListBean {
            /**
             * id : 27
             * name : 精选古典家具专场
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg
             * organization_id : 12
             * is_favorite : true
             * item_count : 7
             * bid_count : 25
             * fans_count : 9
             * organization : {"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"}
             * start_time : 2018-05-04 05:05:00
             * end_time : 2018-09-10 19:55:00
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
                 * organization_id : 12
                 * name : 荣宝斋
                 * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png
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
