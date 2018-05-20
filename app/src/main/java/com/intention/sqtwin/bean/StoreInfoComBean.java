package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午2:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"favorite_store":[{"store_id":1,"store_name":"瀚藏312234234","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png"}],"favorite_field":[{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":8,"bid_count":4,"fans_count":2,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 00:05:00","end_time":"2018-09-10 19:55:00"}],"favorite_artist":[{"id":1,"name":"张三","avatar":"5acb04f502753.jpg","auction_count":10}],"favorite_item":[{"id":192,"name":"Lot0001 明代晋作榆木官帽椅","start_price":"10000.00","commission":"0.05","deposit":"1000.00","auction_field_id":27,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050413130635227.jpg","current_price":"13000.00","bid_leader":"蜗牛","fans_count":1,"bid_count":3}],"favorite_organ":[{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_59454_2018042608285832701.png","create_time":"2018-04-11 14:47:18","description":"荣宝斋"}]}
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
        private Integer store_page_total ;

        public Integer getStore_page_total() {
            return store_page_total;
        }

        public void setStore_page_total(Integer store_page_total) {
            this.store_page_total = store_page_total;
        }

        private List<FavoriteStoreBean> favorite_store;
        private List<FavoriteFieldBean> favorite_field;
        private List<FavoriteArtistBean> favorite_artist;
        private List<FavoriteItemBean> favorite_item;
        private List<FavoriteOrganBean> favorite_organ;

        public List<FavoriteStoreBean> getFavorite_store() {
            return favorite_store;
        }

        public void setFavorite_store(List<FavoriteStoreBean> favorite_store) {
            this.favorite_store = favorite_store;
        }

        public List<FavoriteFieldBean> getFavorite_field() {
            return favorite_field;
        }

        public void setFavorite_field(List<FavoriteFieldBean> favorite_field) {
            this.favorite_field = favorite_field;
        }

        public List<FavoriteArtistBean> getFavorite_artist() {
            return favorite_artist;
        }

        public void setFavorite_artist(List<FavoriteArtistBean> favorite_artist) {
            this.favorite_artist = favorite_artist;
        }

        public List<FavoriteItemBean> getFavorite_item() {
            return favorite_item;
        }

        public void setFavorite_item(List<FavoriteItemBean> favorite_item) {
            this.favorite_item = favorite_item;
        }

        public List<FavoriteOrganBean> getFavorite_organ() {
            return favorite_organ;
        }

        public void setFavorite_organ(List<FavoriteOrganBean> favorite_organ) {
            this.favorite_organ = favorite_organ;
        }

        public static class FavoriteStoreBean {
            /**
             * store_id : 1
             * store_name : 瀚藏312234234
             * store_logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png
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

        public static class FavoriteFieldBean {
            /**
             * id : 27
             * name : 精选古典家具专场
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg
             * organization_id : 12
             * is_favorite : true
             * item_count : 8
             * bid_count : 4
             * fans_count : 2
             * organization : {"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"}
             * start_time : 2018-05-04 00:05:00
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

        public static class FavoriteArtistBean {
            /**
             * id : 1
             * name : 张三
             * avatar : 5acb04f502753.jpg
             * auction_count : 10
             */

            private int id;
            private String name;
            private String avatar;
            private int auction_count;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getAuction_count() {
                return auction_count;
            }

            public void setAuction_count(int auction_count) {
                this.auction_count = auction_count;
            }
        }

        public static class FavoriteItemBean {
            /**
             * id : 192
             * name : Lot0001 明代晋作榆木官帽椅
             * start_price : 10000.00
             * commission : 0.05
             * deposit : 1000.00
             * auction_field_id : 27
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050413130635227.jpg
             * current_price : 13000.00
             * bid_leader : 蜗牛
             * fans_count : 1
             * bid_count : 3
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

        public static class FavoriteOrganBean {
            /**
             * organization_id : 12
             * name : 荣宝斋
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png
             * logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_59454_2018042608285832701.png
             * create_time : 2018-04-11 14:47:18
             * description : 荣宝斋
             */

            private int organization_id;
            private String name;
            private String image;
            private String logo;
            private String create_time;
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
        }
    }
}
