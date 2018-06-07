package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:31
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : [{"id":5,"main_goods_image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","main_goods_name":"第一件商品名称","type":"订单类型","order_time":"2018-2-1 10:00:00","status ":"订单状态"},{"id":5,"main_goods_image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","main_goods_name":"第一件商品名称","type":"订单类型","order_time":"2018-2-1 10:00:00","status ":"订单状态"},{"id":5,"main_goods_image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","main_goods_name":"第一件商品名称","type":"订单类型","order_time":"2018-2-1 10:00:00","status ":"订单状态"}]
     */

    private boolean is_success;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * main_goods_image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
         * main_goods_name : 第一件商品名称
         * type : 订单类型
         * order_time : 2018-2-1 10:00:00
         * status  : 订单状态
         */

        private int id;
        private String main_goods_image;
        private String main_goods_name;
        private String type;
        private String order_time;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain_goods_image() {
            return main_goods_image;
        }

        public void setMain_goods_image(String main_goods_image) {
            this.main_goods_image = main_goods_image;
        }

        public String getMain_goods_name() {
            return main_goods_name;
        }

        public void setMain_goods_name(String main_goods_name) {
            this.main_goods_name = main_goods_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrder_time() {
            return order_time;
        }

        public void setOrder_time(String order_time) {
            this.order_time = order_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
