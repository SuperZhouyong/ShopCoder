package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:25
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"adv":[{"adv_id":45,"adv_title":"衍生品1","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_39617_2018050514065876993.jpg"},{"adv_id":46,"adv_title":"衍生品2","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_25185_2018050514071616429.jpg"},{"adv_id":47,"adv_title":"衍生品3","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_35517_2018050514072876293.jpg"}],"article":[{"article_id":1,"article_title":"1","article_author":"1","article_image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg"},{"article_id":2,"article_title":"","article_author":"1","article_image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg"}],"goods_list":[{"goods_id":171,"goods_name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","goods_price":"0.00","goods_image":""},{"goods_id":190,"goods_name":"a10540335 20世纪80年代 和田白玉岁岁平安大玉璧","goods_price":"0.00","goods_image":""},{"goods_id":193,"goods_name":"Lot0002 明代榆木书桌","goods_price":"0.00","goods_image":""},{"goods_id":200,"goods_name":"测试商品","goods_price":"313.00","goods_image":""}],"shop_list":[{"store_id":1,"store_name":"瀚藏312234234","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png"}]}
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
        private List<AdvBean> adv;
        private List<ArticleBean> article;
        private List<GoodsListBean> goods_list;
        private List<ShopListBean> shop_list;

        public List<AdvBean> getAdv() {
            return adv;
        }

        public void setAdv(List<AdvBean> adv) {
            this.adv = adv;
        }

        public List<ArticleBean> getArticle() {
            return article;
        }

        public void setArticle(List<ArticleBean> article) {
            this.article = article;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<ShopListBean> getShop_list() {
            return shop_list;
        }

        public void setShop_list(List<ShopListBean> shop_list) {
            this.shop_list = shop_list;
        }

        public static class AdvBean {
            /**
             * adv_id : 45
             * adv_title : 衍生品1
             * link :
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_39617_2018050514065876993.jpg
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

        public static class ArticleBean {
            /**
             * article_id : 1
             * article_title : 1
             * article_author : 1
             * article_image : http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg
             */

            private int article_id;
            private String article_title;
            private String article_author;
            private String article_image;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getArticle_title() {
                return article_title;
            }

            public void setArticle_title(String article_title) {
                this.article_title = article_title;
            }

            public String getArticle_author() {
                return article_author;
            }

            public void setArticle_author(String article_author) {
                this.article_author = article_author;
            }

            public String getArticle_image() {
                return article_image;
            }

            public void setArticle_image(String article_image) {
                this.article_image = article_image;
            }
        }

        public static class GoodsListBean {
            /**
             * goods_id : 171
             * goods_name : a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串
             * goods_price : 0.00
             * goods_image :
             */

            private int goods_id;
            private String goods_name;
            private String goods_price;
            private String goods_image;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }

        public static class ShopListBean {
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
    }
}
