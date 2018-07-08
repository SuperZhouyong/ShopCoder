package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:40
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AllMallDateBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"adv":[{"adv_id":48,"adv_title":"淘宝广告1","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_26007_2018052216420819397.jpg"},{"adv_id":49,"adv_title":"淘宝广告2","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_75192_2018052216431443052.png"}],"store":[{"store_id":1,"store_name":"瀚藏312234234","store_logo":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png"}],"item":[{"id":190,"name":"a10540335 20世纪80年代 和田白玉岁岁平安大玉璧","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg","start_price":"12000.00","current_price":"82000.00"},{"id":191,"name":"a10540336 20世纪80年代 和田三彩白玉料苏工精雕梅兰姑娘福临门大牌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411575311374.jpg","start_price":"22000.00","current_price":"22000.00"},{"id":192,"name":"Lot0001 明代晋作榆木官帽椅","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050413130635227.jpg","start_price":"10000.00","current_price":"29000.00"},{"id":193,"name":"Lot0002 明代榆木书桌","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050414075882025.jpg","start_price":"12000.00","current_price":"12000.00"}],"field":[{"id":38,"name":"专场12","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018051610220884484.jpg","organization_id":0,"is_favorite":"true","item_count":2,"bid_count":0,"fans_count":0,"start_time":"2018-05-16 00:00:00","end_time":"2018-05-31 03:15:00"},{"id":37,"name":"重要古董珍玩专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050214311936760.jpg","organization_id":1,"is_favorite":"true","item_count":1,"bid_count":0,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-04 00:05:00","end_time":"2018-07-31 00:05:00"}]}
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
        private List<AdvBean> adv;
        private List<StoreBean> store;
        private List<ItemBean> item;
        private List<FieldBean> field;

        public List<AdvBean> getAdv() {
            return adv;
        }

        public void setAdv(List<AdvBean> adv) {
            this.adv = adv;
        }

        public List<StoreBean> getStore() {
            return store;
        }

        public void setStore(List<StoreBean> store) {
            this.store = store;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        public List<FieldBean> getField() {
            return field;
        }

        public void setField(List<FieldBean> field) {
            this.field = field;
        }

        public static class AdvBean {
            /**
             * adv_id : 48
             * adv_title : 淘宝广告1
             * link :
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_26007_2018052216420819397.jpg
             */

            private int adv_id;
            private String adv_title;
            private String link;
            private String image;
            private Integer link_type;
            private String link_value;

            public Integer getLink_type() {
                return link_type;
            }

            public void setLink_type(Integer link_type) {
                this.link_type = link_type;
            }

            public String getLink_value() {
                return link_value;
            }

            public void setLink_value(String link_value) {
                this.link_value = link_value;
            }

            public int getAdv_id() {
                return adv_id;
            }

            public void setAdv_id(int adv_id) {
                this.adv_id = adv_id;
            }

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class StoreBean {
            /**
             * store_id : 1
             * store_name : 瀚藏312234234
             * store_logo : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_71534_2018042314223191306.png
             */

            private int store_id;
            private String store_name;
            private String store_logo;

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
        }

        public static class ItemBean {
            /**
             * id : 190
             * name : a10540335 20世纪80年代 和田白玉岁岁平安大玉璧
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg
             * start_price : 12000.00
             * current_price : 82000.00
             */

            private int id;
            private String name;
            private String image;
            private String start_price;
            private String current_price;
            private int goods_type;

            public int getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }

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
        }

        public static class FieldBean {
            /**
             * id : 38
             * name : 专场12
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018051610220884484.jpg
             * organization_id : 0
             * is_favorite : true
             * item_count : 2
             * bid_count : 0
             * fans_count : 0
             * start_time : 2018-05-16 00:00:00
             * end_time : 2018-05-31 03:15:00
             * organization : {"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"}
             */

            private int id;
            private String name;
            private String image;
            private int organization_id;
            private String is_favorite;
            private int item_count;
            private int bid_count;
            private int fans_count;
            private String start_time;
            private String end_time;
            private OrganizationBean organization;

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

            public OrganizationBean getOrganization() {
                return organization;
            }

            public void setOrganization(OrganizationBean organization) {
                this.organization = organization;
            }

            public static class OrganizationBean {
                /**
                 * organization_id : 1
                 * name : 中国嘉德
                 * image :
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
