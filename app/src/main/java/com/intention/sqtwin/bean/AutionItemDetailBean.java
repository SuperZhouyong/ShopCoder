package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:46
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemDetailBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"item_info":{"description":"此件玉笔架的用料十分考究，系采用上品和田双色籽料雕琢而成，密度高、润度好，堪称凝滑脂润、如酪似膏，且呈色均匀、色界分明。造型圆润流畅，雅致精巧，气韵灵动。雕琢极尽精致，刻画入微，一丝不苟，纤毫毕现\u2014\u2014以呈色均匀且油润的糖黄玉料雕琢竹排；","author":"张三","author_id":1,"resume":"一个程序员","goods_id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","start_time":"2018-05-07 15:05:00","end_time":"2018-05-15 00:05:00","start_price":"10000.00","increment_type":1,"increment_value":"500.00","commission":"0.05","deposit":"10000.00","auction_field_id":26,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg"}],"current_price":"11000.00","fans_count":0},"staff_list":[{"id":1,"name":"张三","avatar":"1","type":0,"run_count":1}],"price_list":[{"id":25,"bid_time":"2018-05-12 16:15:43","type":0,"price":"11000.00","nickname":"","avatar":""},{"id":24,"bid_time":"2018-05-12 16:14:39","type":0,"price":"10500.00","nickname":"","avatar":""}],"price_count":2,"credit_line":"100.00"}
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
         * item_info : {"description":"此件玉笔架的用料十分考究，系采用上品和田双色籽料雕琢而成，密度高、润度好，堪称凝滑脂润、如酪似膏，且呈色均匀、色界分明。造型圆润流畅，雅致精巧，气韵灵动。雕琢极尽精致，刻画入微，一丝不苟，纤毫毕现\u2014\u2014以呈色均匀且油润的糖黄玉料雕琢竹排；","author":"张三","author_id":1,"resume":"一个程序员","goods_id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","start_time":"2018-05-07 15:05:00","end_time":"2018-05-15 00:05:00","start_price":"10000.00","increment_type":1,"increment_value":"500.00","commission":"0.05","deposit":"10000.00","auction_field_id":26,"images":[{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg"}],"current_price":"11000.00","fans_count":0}
         * staff_list : [{"id":1,"name":"张三","avatar":"1","type":0,"run_count":1}]
         * price_list : [{"id":25,"bid_time":"2018-05-12 16:15:43","type":0,"price":"11000.00","nickname":"","avatar":""},{"id":24,"bid_time":"2018-05-12 16:14:39","type":0,"price":"10500.00","nickname":"","avatar":""}]
         * price_count : 2
         * credit_line : 100.00
         */

        private ItemInfoBean item_info;
        private int price_count;
        private String credit_line;
        private List<StaffListBean> staff_list;
        private List<PriceListBean> price_list;

        public ItemInfoBean getItem_info() {
            return item_info;
        }

        public void setItem_info(ItemInfoBean item_info) {
            this.item_info = item_info;
        }

        public int getPrice_count() {
            return price_count;
        }

        public void setPrice_count(int price_count) {
            this.price_count = price_count;
        }

        public String getCredit_line() {
            return credit_line;
        }

        public void setCredit_line(String credit_line) {
            this.credit_line = credit_line;
        }

        public List<StaffListBean> getStaff_list() {
            return staff_list;
        }

        public void setStaff_list(List<StaffListBean> staff_list) {
            this.staff_list = staff_list;
        }

        public List<PriceListBean> getPrice_list() {
            return price_list;
        }

        public void setPrice_list(List<PriceListBean> price_list) {
            this.price_list = price_list;
        }

        public static class ItemInfoBean {
            /**
             * description : 此件玉笔架的用料十分考究，系采用上品和田双色籽料雕琢而成，密度高、润度好，堪称凝滑脂润、如酪似膏，且呈色均匀、色界分明。造型圆润流畅，雅致精巧，气韵灵动。雕琢极尽精致，刻画入微，一丝不苟，纤毫毕现——以呈色均匀且油润的糖黄玉料雕琢竹排；
             * author : 张三
             * author_id : 1
             * resume : 一个程序员
             * goods_id : 172
             * name : a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架
             * start_time : 2018-05-07 15:05:00
             * end_time : 2018-05-15 00:05:00
             * start_price : 10000.00
             * increment_type : 1
             * increment_value : 500.00
             * commission : 0.05
             * deposit : 10000.00
             * auction_field_id : 26
             * images : [{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451987310.jpg"},{"goodsimage_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451959811.jpg"}]
             * current_price : 11000.00
             * fans_count : 0
             */

            private String description;
            private String author;
            private int author_id;
            private String resume;
            private int goods_id;
            private String name;
            private String start_time;
            private String end_time;
            private String start_price;
            private int increment_type;
            private String increment_value;
            private String commission;
            private String deposit;
            private int auction_field_id;
            private String current_price;
            private int fans_count;
            private List<ImagesBean> images;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getAuthor_id() {
                return author_id;
            }

            public void setAuthor_id(int author_id) {
                this.author_id = author_id;
            }

            public String getResume() {
                return resume;
            }

            public void setResume(String resume) {
                this.resume = resume;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public int getIncrement_type() {
                return increment_type;
            }

            public void setIncrement_type(int increment_type) {
                this.increment_type = increment_type;
            }

            public String getIncrement_value() {
                return increment_value;
            }

            public void setIncrement_value(String increment_value) {
                this.increment_value = increment_value;
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

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                /**
                 * goodsimage_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg
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

        public static class StaffListBean {
            /**
             * id : 1
             * name : 张三
             * avatar : 1
             * type : 0
             * run_count : 1
             */

            private int id;
            private String name;
            private String avatar;
            private int type;
            private int run_count;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getRun_count() {
                return run_count;
            }

            public void setRun_count(int run_count) {
                this.run_count = run_count;
            }
        }

        public static class PriceListBean {
            /**
             * id : 25
             * bid_time : 2018-05-12 16:15:43
             * type : 0
             * price : 11000.00
             * nickname :
             * avatar :
             */

            private int id;
            private String bid_time;
            private int type;
            private String price;
            private String nickname;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBid_time() {
                return bid_time;
            }

            public void setBid_time(String bid_time) {
                this.bid_time = bid_time;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
