package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-下午 13:58
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartGoodsBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"cart":[{"member_id":42,"goods_id":200,"goods_name":"测试商品22","price":"313.00","count":14,"goods_commonid":194,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg"}],"price_sum":4382}
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
         * cart : [{"member_id":42,"goods_id":200,"goods_name":"测试商品22","price":"313.00","count":14,"goods_commonid":194,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg"}]
         * price_sum : 4382
         */

        private int price_sum;
        private List<CartBean> cart;

        public int getPrice_sum() {
            return price_sum;
        }

        public void setPrice_sum(int price_sum) {
            this.price_sum = price_sum;
        }

        public List<CartBean> getCart() {
            return cart;
        }

        public void setCart(List<CartBean> cart) {
            this.cart = cart;
        }

        public static class CartBean {
            /**
             * member_id : 42
             * goods_id : 200
             * goods_name : 测试商品22
             * price : 313.00
             * count : 14
             * goods_commonid : 194
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg
             */

            private int member_id;
            private int goods_id;
            private String goods_name;
            private String price;
            private int count;
            private int goods_commonid;
            private String image;

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(int goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
