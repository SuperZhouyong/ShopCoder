package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-上午9:20
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoOrderListBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"goods":[{"id":200,"name":"测试商品22","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg","start_price":"313.00","current_price":"313.00","goods_type":1},{"id":201,"name":"第2个","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052309553957520.png","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":202,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":203,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":204,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":205,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1}],"total_page":6}
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
         * goods : [{"id":200,"name":"测试商品22","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg","start_price":"313.00","current_price":"313.00","goods_type":1},{"id":201,"name":"第2个","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052309553957520.png","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":202,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":203,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":204,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1},{"id":205,"name":"第一个","image":"","start_price":"3500.00","current_price":"3500.00","goods_type":1}]
         * total_page : 6
         */

        private int total_page;
        private List<GoodsBean> goods;

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * id : 200
             * name : 测试商品22
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415164838749.jpg
             * start_price : 313.00
             * current_price : 313.00
             * goods_type : 1
             */

            private int id;
            private String name;
            private String image;
            private String start_price;
            private String current_price;
            private int goods_type;

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

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }

            public int getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }
        }
    }
}
