package com.intention.sqtwin.bean;

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
     * data : {"info":{"store_id":1,"goods_id":171,"goods_commonid":165,"goods_name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","goods_price":"0.00","goods_marketprice":null,"brand_id":0,"description":"拍品信息\r\n年代：现代      \r\n直径：2.1厘米      \r\n拍品说明\r\n备注: 每粒直径：21mm，共19粒，总重：110g。配天然煤精佛头、顶珠。带北大宝石鉴定中心出具珠宝玉石鉴定证书。","goods_storage":0,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382818049.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382980548.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215383630424.jpg"}]}}
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
         * info : {"store_id":1,"goods_id":171,"goods_commonid":165,"goods_name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","goods_price":"0.00","goods_marketprice":null,"brand_id":0,"description":"拍品信息\r\n年代：现代      \r\n直径：2.1厘米      \r\n拍品说明\r\n备注: 每粒直径：21mm，共19粒，总重：110g。配天然煤精佛头、顶珠。带北大宝石鉴定中心出具珠宝玉石鉴定证书。","goods_storage":0,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382818049.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382980548.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215383630424.jpg"}]}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * store_id : 1
             * goods_id : 171
             * goods_commonid : 165
             * goods_name : a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串
             * goods_price : 0.00
             * goods_marketprice : null
             * brand_id : 0
             * description : 拍品信息
             年代：现代
             直径：2.1厘米
             拍品说明
             备注: 每粒直径：21mm，共19粒，总重：110g。配天然煤精佛头、顶珠。带北大宝石鉴定中心出具珠宝玉石鉴定证书。
             * goods_storage : 0
             * images : [{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382818049.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382980548.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215383630424.jpg"}]
             */

            private int store_id;
            private int goods_id;
            private int goods_commonid;
            private String goods_name;
            private String goods_price;
            private String  goods_marketprice;
            private int brand_id;
            private String description;
            private int goods_storage;
            private List<ImagesBean> images;

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
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

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                /**
                 * goodsimage_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg
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
