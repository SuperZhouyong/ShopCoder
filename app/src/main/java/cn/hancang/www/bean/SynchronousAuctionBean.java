package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:50
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"sync_auction_field":[{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":20,"bid_count":6,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-02 00:05:00","end_time":"2018-12-31 00:05:00"}],"page_count":1}
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
         * sync_auction_field : [{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":20,"bid_count":6,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-02 00:05:00","end_time":"2018-12-31 00:05:00"}]
         * page_count : 1
         */

        private int page_count;
        private List<SyncAuctionFieldBean> sync_auction_field;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<SyncAuctionFieldBean> getSync_auction_field() {
            return sync_auction_field;
        }

        public void setSync_auction_field(List<SyncAuctionFieldBean> sync_auction_field) {
            this.sync_auction_field = sync_auction_field;
        }

        public static class SyncAuctionFieldBean {
            /**
             * id : 26
             * name : 集萃斋玉器杂项
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg
             * organization_id : 1
             * is_favorite : true
             * item_count : 20
             * bid_count : 6
             * fans_count : 0
             * organization : {"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"}
             * start_time : 2018-05-02 00:05:00
             * end_time : 2018-12-31 00:05:00
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
