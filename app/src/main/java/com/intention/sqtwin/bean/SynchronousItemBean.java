package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 16:23
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousItemBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"sync_auction_field":{"auction_start_time":"2018-05-07 15:05:00","auction_end_time":"2018-05-15 00:05:00","goods_id":172,"goods_name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","goods_commonid":166,"images":[{"goodsimage_id":274,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":275,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":276,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg","goodsimage_sort":null,"goodsimage_isdefault":0}],"curent_price":13000}}
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
         * sync_auction_field : {"auction_start_time":"2018-05-07 15:05:00","auction_end_time":"2018-05-15 00:05:00","goods_id":172,"goods_name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","goods_commonid":166,"images":[{"goodsimage_id":274,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":275,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":276,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg","goodsimage_sort":null,"goodsimage_isdefault":0}],"curent_price":13000}
         */

        private SyncAuctionFieldBean sync_auction_field;

        public SyncAuctionFieldBean getSync_auction_field() {
            return sync_auction_field;
        }

        public void setSync_auction_field(SyncAuctionFieldBean sync_auction_field) {
            this.sync_auction_field = sync_auction_field;
        }

        public static class SyncAuctionFieldBean {
            /**
             * auction_start_time : 2018-05-07 15:05:00
             * auction_end_time : 2018-05-15 00:05:00
             * goods_id : 172
             * goods_name : a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架
             * goods_commonid : 166
             * images : [{"goodsimage_id":274,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":275,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg","goodsimage_sort":null,"goodsimage_isdefault":0},{"goodsimage_id":276,"goods_commonid":166,"store_id":1,"color_id":0,"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg","goodsimage_sort":null,"goodsimage_isdefault":0}]
             * curent_price : 13000
             */

            private String auction_start_time;
            private String auction_end_time;
            private int goods_id;
            private String goods_name;
            private int goods_commonid;
            private int curent_price;
            private List<ImagesBean> images;

            public String getAuction_start_time() {
                return auction_start_time;
            }

            public void setAuction_start_time(String auction_start_time) {
                this.auction_start_time = auction_start_time;
            }

            public String getAuction_end_time() {
                return auction_end_time;
            }

            public void setAuction_end_time(String auction_end_time) {
                this.auction_end_time = auction_end_time;
            }

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

            public int getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(int goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public int getCurent_price() {
                return curent_price;
            }

            public void setCurent_price(int curent_price) {
                this.curent_price = curent_price;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                /**
                 * goodsimage_id : 274
                 * goods_commonid : 166
                 * store_id : 1
                 * color_id : 0
                 * goodsimage_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg
                 * goodsimage_sort : null
                 * goodsimage_isdefault : 0
                 */

                private int goodsimage_id;
                private int goods_commonid;
                private int store_id;
                private int color_id;
                private String goodsimage_url;
                private Object goodsimage_sort;
                private int goodsimage_isdefault;

                public int getGoodsimage_id() {
                    return goodsimage_id;
                }

                public void setGoodsimage_id(int goodsimage_id) {
                    this.goodsimage_id = goodsimage_id;
                }

                public int getGoods_commonid() {
                    return goods_commonid;
                }

                public void setGoods_commonid(int goods_commonid) {
                    this.goods_commonid = goods_commonid;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }

                public int getColor_id() {
                    return color_id;
                }

                public void setColor_id(int color_id) {
                    this.color_id = color_id;
                }

                public String getGoodsimage_url() {
                    return goodsimage_url;
                }

                public void setGoodsimage_url(String goodsimage_url) {
                    this.goodsimage_url = goodsimage_url;
                }

                public Object getGoodsimage_sort() {
                    return goodsimage_sort;
                }

                public void setGoodsimage_sort(Object goodsimage_sort) {
                    this.goodsimage_sort = goodsimage_sort;
                }

                public int getGoodsimage_isdefault() {
                    return goodsimage_isdefault;
                }

                public void setGoodsimage_isdefault(int goodsimage_isdefault) {
                    this.goodsimage_isdefault = goodsimage_isdefault;
                }
            }
        }
    }
}
