package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"staff_info":{"staff_id":1,"create_time":"2018-04-04 14:25:11","name":"张三","avatar":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_16351_2018041110104892614.png","type":0,"description":"描述","store_id":0},"page_count":1,"auction_field_list":[{"id":43,"name":"测试3","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052315182750943.png","organization_id":0,"is_favorite":"false","item_count":2,"bid_count":0,"fans_count":0,"start_time":"2018-05-23 00:00:00","end_time":"2018-05-26 00:00:00"},{"id":42,"name":"测试3","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052123012710447.jpg","organization_id":1,"is_favorite":"false","item_count":0,"bid_count":0,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"false"}},{"id":39,"name":"111","image":"","organization_id":0,"is_favorite":"false","item_count":0,"bid_count":0,"fans_count":0},{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":33,"fans_count":10,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"false"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"},{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":19,"bid_count":30,"fans_count":2,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"false"},"start_time":"2018-05-02 01:05:00","end_time":"2018-08-31 23:55:00"}]}
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
         * staff_info : {"staff_id":1,"create_time":"2018-04-04 14:25:11","name":"张三","avatar":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_16351_2018041110104892614.png","type":0,"description":"描述","store_id":0}
         * page_count : 1
         * auction_field_list : [{"id":43,"name":"测试3","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052315182750943.png","organization_id":0,"is_favorite":"false","item_count":2,"bid_count":0,"fans_count":0,"start_time":"2018-05-23 00:00:00","end_time":"2018-05-26 00:00:00"},{"id":42,"name":"测试3","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052123012710447.jpg","organization_id":1,"is_favorite":"false","item_count":0,"bid_count":0,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"false"}},{"id":39,"name":"111","image":"","organization_id":0,"is_favorite":"false","item_count":0,"bid_count":0,"fans_count":0},{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":7,"bid_count":33,"fans_count":10,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"false"},"start_time":"2018-05-04 05:05:00","end_time":"2018-09-10 19:55:00"},{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":19,"bid_count":30,"fans_count":2,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"false"},"start_time":"2018-05-02 01:05:00","end_time":"2018-08-31 23:55:00"}]
         */

        private StaffInfoBean staff_info;
        private int page_count;
        private List<AuctionFieldListBean> auction_field_list;

        public StaffInfoBean getStaff_info() {
            return staff_info;
        }

        public void setStaff_info(StaffInfoBean staff_info) {
            this.staff_info = staff_info;
        }

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class StaffInfoBean {
            /**
             * staff_id : 1
             * create_time : 2018-04-04 14:25:11
             * name : 张三
             * avatar : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_16351_2018041110104892614.png
             * type : 0
             * description : 描述
             * store_id : 0
             */

            private int staff_id;
            private String create_time;
            private String name;
            private String avatar;
            private int type;
            private String description;
            private int store_id;

            public int getStaff_id() {
                return staff_id;
            }

            public void setStaff_id(int staff_id) {
                this.staff_id = staff_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }
        }

        public static class AuctionFieldListBean {
            /**
             * id : 43
             * name : 测试3
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018052315182750943.png
             * organization_id : 0
             * is_favorite : false
             * item_count : 2
             * bid_count : 0
             * fans_count : 0
             * start_time : 2018-05-23 00:00:00
             * end_time : 2018-05-26 00:00:00
             * organization : {"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"false"}
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
                 * is_favorite : false
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
