package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetailBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"artist_info":{"artist_id":5,"name":"艺术家姓名","fans_count":"1500","goods_count":"100","description":"详情","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg"},"item_list":[{"id":1,"name":"拍品名称0","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头0","description":"产品介绍0","price_count":"7"},{"id":2,"name":"拍品名称1","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头1","description":"产品介绍1","price_count":"7"},{"id":3,"name":"拍品名称2","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头2","description":"产品介绍2","price_count":"7"},{"id":4,"name":"拍品名称3","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头3","description":"产品介绍3","price_count":"7"},{"id":5,"name":"拍品名称4","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头4","description":"产品介绍4","price_count":"7"},{"id":6,"name":"拍品名称5","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头5","description":"产品介绍5","price_count":"7"},{"id":7,"name":"拍品名称6","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头6","description":"产品介绍6","price_count":"7"},{"id":8,"name":"拍品名称7","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头7","description":"产品介绍7","price_count":"7"},{"id":9,"name":"拍品名称8","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头8","description":"产品介绍8","price_count":"7"},{"id":10,"name":"拍品名称9","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头9","description":"产品介绍9","price_count":"7"}],"total_page":10}
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
         * artist_info : {"artist_id":5,"name":"艺术家姓名","fans_count":"1500","goods_count":"100","description":"详情","avatar":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg"}
         * item_list : [{"id":1,"name":"拍品名称0","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头0","description":"产品介绍0","price_count":"7"},{"id":2,"name":"拍品名称1","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头1","description":"产品介绍1","price_count":"7"},{"id":3,"name":"拍品名称2","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头2","description":"产品介绍2","price_count":"7"},{"id":4,"name":"拍品名称3","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头3","description":"产品介绍3","price_count":"7"},{"id":5,"name":"拍品名称4","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头4","description":"产品介绍4","price_count":"7"},{"id":6,"name":"拍品名称5","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头5","description":"产品介绍5","price_count":"7"},{"id":7,"name":"拍品名称6","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头6","description":"产品介绍6","price_count":"7"},{"id":8,"name":"拍品名称7","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头7","description":"产品介绍7","price_count":"7"},{"id":9,"name":"拍品名称8","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头8","description":"产品介绍8","price_count":"7"},{"id":10,"name":"拍品名称9","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头9","description":"产品介绍9","price_count":"7"}]
         * total_page : 10
         */

        private ArtistInfoBean artist_info;
        private int total_page;
        private List<ItemListBean> item_list;

        public ArtistInfoBean getArtist_info() {
            return artist_info;
        }

        public void setArtist_info(ArtistInfoBean artist_info) {
            this.artist_info = artist_info;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public static class ArtistInfoBean {
            /**
             * artist_id : 5
             * name : 艺术家姓名
             * fans_count : 1500
             * goods_count : 100
             * description : 详情
             * avatar : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             */

            private int artist_id;
            private String name;
            private String fans_count;
            private String goods_count;
            private String description;
            private String avatar;

            public int getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(int artist_id) {
                this.artist_id = artist_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class ItemListBean {
            /**
             * id : 1
             * name : 拍品名称0
             * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * current_price : 888
             * start_price : 666
             * bid_leader : 石头0
             * description : 产品介绍0
             * price_count : 7
             */

            private int id;
            private String name;
            private String image;
            private String current_price;
            private String start_price;
            private String bid_leader;
            private String description;
            private String price_count;

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

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getBid_leader() {
                return bid_leader;
            }

            public void setBid_leader(String bid_leader) {
                this.bid_leader = bid_leader;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPrice_count() {
                return price_count;
            }

            public void setPrice_count(String price_count) {
                this.price_count = price_count;
            }
        }
    }
}
