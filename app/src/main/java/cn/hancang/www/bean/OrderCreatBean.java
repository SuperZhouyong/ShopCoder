package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/6/21 0021-下午 17:59
 * Blog：Super简单
 * Author: ZhouYong
 */

public class OrderCreatBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"total_freight":0,"total_amount":48600,"goods_list":[{"goods_name":"Lot0012 明早期大漆镶绿云石板座屏","goods_image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415091927737.jpg","goods_id":"197","goods_price":"48600.00","count":1}],"address_list":[{"name":"还是世界上就是计算机","phone":"646454646","id":32,"address":"大好河山收拾你就说你是你撒你那","address_is_default":1,"province_id":1,"city_id":36,"area_id":37,"province_name":"北京","city_name":"北京市","area_name":"东城区"}],"pay_list":[{"pay_type":1,"name":"微信支付"},{"pay_type":2,"name":"支付宝"}]}
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
         * total_freight : 0
         * total_amount : 48600
         * goods_list : [{"goods_name":"Lot0012 明早期大漆镶绿云石板座屏","goods_image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415091927737.jpg","goods_id":"197","goods_price":"48600.00","count":1}]
         * address_list : [{"name":"还是世界上就是计算机","phone":"646454646","id":32,"address":"大好河山收拾你就说你是你撒你那","address_is_default":1,"province_id":1,"city_id":36,"area_id":37,"province_name":"北京","city_name":"北京市","area_name":"东城区"}]
         * pay_list : [{"pay_type":1,"name":"微信支付"},{"pay_type":2,"name":"支付宝"}]
         */

        private int total_freight;
        private int total_amount;
        private List<GoodsListBean> goods_list;
        private List<AddressListBean> address_list;
        private List<PayListBean> pay_list;

        public int getTotal_freight() {
            return total_freight;
        }

        public void setTotal_freight(int total_freight) {
            this.total_freight = total_freight;
        }

        public int getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(int total_amount) {
            this.total_amount = total_amount;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<AddressListBean> getAddress_list() {
            return address_list;
        }

        public void setAddress_list(List<AddressListBean> address_list) {
            this.address_list = address_list;
        }

        public List<PayListBean> getPay_list() {
            return pay_list;
        }

        public void setPay_list(List<PayListBean> pay_list) {
            this.pay_list = pay_list;
        }

        public static class GoodsListBean {
            /**
             * goods_name : Lot0012 明早期大漆镶绿云石板座屏
             * goods_image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050415091927737.jpg
             * goods_id : 197
             * goods_price : 48600.00
             * count : 1
             */

            private String goods_name;
            private String goods_image;
            private String goods_id;
            private String goods_price;
            private int count;

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        public static class AddressListBean {
            /**
             * name : 还是世界上就是计算机
             * phone : 646454646
             * id : 32
             * address : 大好河山收拾你就说你是你撒你那
             * address_is_default : 1
             * province_id : 1
             * city_id : 36
             * area_id : 37
             * province_name : 北京
             * city_name : 北京市
             * area_name : 东城区
             */

            private String name;
            private String phone;
            private int id;
            private String address;
            private int address_is_default;
            private int province_id;
            private int city_id;
            private int area_id;
            private String province_name;
            private String city_name;
            private String area_name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getAddress_is_default() {
                return address_is_default;
            }

            public void setAddress_is_default(int address_is_default) {
                this.address_is_default = address_is_default;
            }

            public int getProvince_id() {
                return province_id;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public String getProvince_name() {
                return province_name;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }

        public static class PayListBean {
            /**
             * pay_type : 1
             * name : 微信支付
             */

            private int pay_type;
            private String name;

            public int getPay_type() {
                return pay_type;
            }

            public void setPay_type(int pay_type) {
                this.pay_type = pay_type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
