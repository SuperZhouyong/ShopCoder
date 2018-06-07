package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:22
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaobaoStoreInfoBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"store_info":{"store_id":1,"store_name":"拍卖拍115","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png","store_description":"拍卖545请问请问","store_banner":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_31296_2018042009394293753.png"},"item_list":[{"id":169,"name":"a10565132 现代 新疆和田青玉细料一百单八子精圆念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050214494676367.jpg","start_price":null,"current_price":"1006.00"},{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":"2000.00","current_price":"2000.00"},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","start_price":"10000.00","current_price":"13000.00"},{"id":176,"name":"a10540289 建国初 和田白玉志在千里手把件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215544550180.jpg","start_price":"12000.00","current_price":"12000.00"}],"auction_field_list":[{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":21,"fans_count":10,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"}]}
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
         * store_info : {"store_id":1,"store_name":"拍卖拍115","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png","store_description":"拍卖545请问请问","store_banner":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_31296_2018042009394293753.png"}
         * item_list : [{"id":169,"name":"a10565132 现代 新疆和田青玉细料一百单八子精圆念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050214494676367.jpg","start_price":null,"current_price":"1006.00"},{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":"2000.00","current_price":"2000.00"},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","start_price":"10000.00","current_price":"13000.00"},{"id":176,"name":"a10540289 建国初 和田白玉志在千里手把件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215544550180.jpg","start_price":"12000.00","current_price":"12000.00"}]
         * auction_field_list : [{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":21,"fans_count":10,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"}]
         */

        private StoreInfoBean store_info;
        private List<ItemListBean> item_list;
        private List<AuctionFieldListBean> auction_field_list;

        public StoreInfoBean getStore_info() {
            return store_info;
        }

        public void setStore_info(StoreInfoBean store_info) {
            this.store_info = store_info;
        }

        public List<ItemListBean> getItem_list() {
            return item_list;
        }

        public void setItem_list(List<ItemListBean> item_list) {
            this.item_list = item_list;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class StoreInfoBean {
            /**
             * store_id : 1
             * store_name : 拍卖拍115
             * store_logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png
             * store_description : 拍卖545请问请问
             * store_banner : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_31296_2018042009394293753.png
             */

            private int store_id;
            private String store_name;
            private String store_logo;
            private String store_description;
            private String store_banner;

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

            public String getStore_description() {
                return store_description;
            }

            public void setStore_description(String store_description) {
                this.store_description = store_description;
            }

            public String getStore_banner() {
                return store_banner;
            }

            public void setStore_banner(String store_banner) {
                this.store_banner = store_banner;
            }
        }

        public static class ItemListBean {
            /**
             * id : 169
             * name : a10565132 现代 新疆和田青玉细料一百单八子精圆念珠串
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050214494676367.jpg
             * start_price : null
             * current_price : 1006.00
             */

            private int id;
            private String name;
            private String image;
            private Object start_price;
            private String current_price;

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

            public Object getStart_price() {
                return start_price;
            }

            public void setStart_price(Object start_price) {
                this.start_price = start_price;
            }

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }
        }

        public static class AuctionFieldListBean {
            /**
             * id : 27
             * name : 精选古典家具专场
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg
             * organization_id : 12
             * is_favorite : true
             * item_count : 7
             * bid_count : 21
             * fans_count : 10
             * organization : {"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"}
             * start_time : 2018-05-04 05:05:00
             * end_time : 2018-09-10 19:55:00
             */

            private int id;
            private String name;
            private String image;
            private int organization_id;
            private String is_favorite;
            private int item_count;
            private int bid_count;
            private int fans_count;
            private OrganizationBean organization;
            private String start_time;
            private String end_time;

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

            public int getOrganization_id() {
                return organization_id;
            }

            public void setOrganization_id(int organization_id) {
                this.organization_id = organization_id;
            }

            public String getIs_favorite() {
                return is_favorite;
            }

            public void setIs_favorite(String is_favorite) {
                this.is_favorite = is_favorite;
            }

            public int getItem_count() {
                return item_count;
            }

            public void setItem_count(int item_count) {
                this.item_count = item_count;
            }

            public int getBid_count() {
                return bid_count;
            }

            public void setBid_count(int bid_count) {
                this.bid_count = bid_count;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public OrganizationBean getOrganization() {
                return organization;
            }

            public void setOrganization(OrganizationBean organization) {
                this.organization = organization;
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

            public static class OrganizationBean {
                /**
                 * organization_id : 12
                 * name : 荣宝斋
                 * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png
                 * is_favorite : true
                 */

                private int organization_id;
                private String name;
                private String image;
                private String is_favorite;

                public int getOrganization_id() {
                    return organization_id;
                }

                public void setOrganization_id(int organization_id) {
                    this.organization_id = organization_id;
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

                public String getIs_favorite() {
                    return is_favorite;
                }

                public void setIs_favorite(String is_favorite) {
                    this.is_favorite = is_favorite;
                }
            }
        }
    }
}
