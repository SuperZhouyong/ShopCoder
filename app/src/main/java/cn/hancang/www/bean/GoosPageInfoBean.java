package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:17
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoosPageInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"info":{"store_id":1,"goods_qrcode_img":null,"goods_id":3953,"goods_type":1,"goods_commonid":3939,"goods_name":"南红手串","goods_price":"3000.00","goods_marketprice":"5000.00","brand_id":0,"description":"333","goods_storage":1,"is_fav_store":true,"description_image":[{"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_cs5555552-2.jpeg"}],"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018072015310632575_DSC2585.jpg"}]},"share_url":"http://wap.hancang.cn/wechat/shop/goods_info?goods_id=3953"}
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
         * info : {"store_id":1,"goods_qrcode_img":null,"goods_id":3953,"goods_type":1,"goods_commonid":3939,"goods_name":"南红手串","goods_price":"3000.00","goods_marketprice":"5000.00","brand_id":0,"description":"333","goods_storage":1,"is_fav_store":true,"description_image":[{"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_cs5555552-2.jpeg"}],"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018072015310632575_DSC2585.jpg"}]}
         * share_url : http://wap.hancang.cn/wechat/shop/goods_info?goods_id=3953
         */

        private InfoBean info;
        private String share_url;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public static class InfoBean {
            /**
             * store_id : 1
             * goods_qrcode_img : null
             * goods_id : 3953
             * goods_type : 1
             * goods_commonid : 3939
             * goods_name : 南红手串
             * goods_price : 3000.00
             * goods_marketprice : 5000.00
             * brand_id : 0
             * description : 333
             * goods_storage : 1
             * is_fav_store : true
             * description_image : [{"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_cs5555552-2.jpeg"}]
             * images : [{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018072015310632575_DSC2585.jpg"}]
             */

            private int store_id;
            private String goods_qrcode_img;
            private int goods_id;
            private int goods_type;
            private int goods_commonid;
            private String goods_name;
            private String goods_price;
            private String goods_marketprice;
            private int brand_id;
            private String description;
            private int goods_storage;
            private boolean is_fav_store;
            private List<DescriptionImageBean> description_image;
            private List<ImagesBean> images;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getGoods_qrcode_img() {
                return goods_qrcode_img;
            }

            public void setGoods_qrcode_img(String goods_qrcode_img) {
                this.goods_qrcode_img = goods_qrcode_img;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }

            public int getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(int goods_commonid) {
                this.goods_commonid = goods_commonid;
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

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(int goods_storage) {
                this.goods_storage = goods_storage;
            }

            public boolean isIs_fav_store() {
                return is_fav_store;
            }

            public void setIs_fav_store(boolean is_fav_store) {
                this.is_fav_store = is_fav_store;
            }

            public List<DescriptionImageBean> getDescription_image() {
                return description_image;
            }

            public void setDescription_image(List<DescriptionImageBean> description_image) {
                this.description_image = description_image;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class DescriptionImageBean {
                /**
                 * image_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_cs5555552-2.jpeg
                 */

                private String image_url;

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }
            }

            public static class ImagesBean {
                /**
                 * goodsimage_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018072015310632575_DSC2585.jpg
                 */

                private String goodsimage_url;

                public String getGoodsimage_url() {
                    return goodsimage_url;
                }

                public void setGoodsimage_url(String goodsimage_url) {
                    this.goodsimage_url = goodsimage_url;
                }
            }
        }
    }
}
