package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:39
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"goods_list":[{},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","start_price":10000,"commission":"0.05","deposit":"10000.00","auction_field_id":26,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","current_price":"1600.00","bid_leader":null,"fans_count":0},{},{}],"balance":{"available_predeposit":"0.00","freeze_predeposit":"0.00"}}
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
         * goods_list : [{},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","start_price":10000,"commission":"0.05","deposit":"10000.00","auction_field_id":26,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","current_price":"1600.00","bid_leader":null,"fans_count":0},{},{}]
         * balance : {"available_predeposit":"0.00","freeze_predeposit":"0.00"}
         */

        private BalanceBean balance;
        private List<GoodsListBean> goods_list;

        public BalanceBean getBalance() {
            return balance;
        }

        public void setBalance(BalanceBean balance) {
            this.balance = balance;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class BalanceBean {
            /**
             * available_predeposit : 0.00
             * freeze_predeposit : 0.00
             */

            private String available_predeposit;
            private String freeze_predeposit;

            public String getAvailable_predeposit() {
                return available_predeposit;
            }

            public void setAvailable_predeposit(String available_predeposit) {
                this.available_predeposit = available_predeposit;
            }

            public String getFreeze_predeposit() {
                return freeze_predeposit;
            }

            public void setFreeze_predeposit(String freeze_predeposit) {
                this.freeze_predeposit = freeze_predeposit;
            }
        }

        public static class GoodsListBean {
            /**
             * id : 172
             * name : a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架
             * start_price : 10000
             * commission : 0.05
             * deposit : 10000.00
             * auction_field_id : 26
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg
             * current_price : 1600.00
             * bid_leader : null
             * fans_count : 0
             */

            private int id;
            private String name;
            private int start_price;
            private String commission;
            private String deposit;
            private int auction_field_id;
            private String image;
            private String current_price;
            private String bid_leader;
            private int fans_count;

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

            public int getStart_price() {
                return start_price;
            }

            public void setStart_price(int start_price) {
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
        }
    }
}
