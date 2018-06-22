package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AllDateBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"recommend_field":[{"id":26,"name":"集萃斋玉器杂项","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg","organization_id":1,"is_favorite":"true","item_count":21,"bid_count":0,"fans_count":0,"organization":{"organization_id":1,"name":"中国嘉德","image":"","is_favorite":"true"},"start_time":"2018-05-02 00:05:00","end_time":"2018-12-31 00:05:00"},{"id":27,"name":"精选古典家具专场","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213450998552.jpg","organization_id":12,"is_favorite":"true","item_count":8,"bid_count":0,"fans_count":0,"organization":{"organization_id":12,"name":"荣宝斋","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_94501_2018042608290313825.png","is_favorite":"true"},"start_time":"2018-05-04 00:05:00","end_time":"2018-09-10 19:55:00"}],"adv1":[{"adv_id":38,"adv_title":"首页广告","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png"},{"adv_id":39,"adv_title":"首页广告2","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_39136_2018050511453194597.jpeg"}],"adv2":[{"adv_id":41,"adv_title":"首页广告2-1","link":"","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_36205_2018050511455572398.jpg"}],"recommend_item":[{"id":190,"name":"a10540335 20世纪80年代 和田白玉岁岁平安大玉璧","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg","start_price":12000,"current_price":12000},{"id":172,"name":"a10540126 现代 苏工摘色精雕和田双色籽料婴戏笔架","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215451930107.jpg","start_price":10000,"current_price":10000},{"id":171,"name":"a10540004 现代 天然上品煤精正圆大珠十八罗汉念珠串","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050215382784493.jpg","start_price":2000,"current_price":2000},{"id":180,"name":"a10540267 现代 和田浓绿碧玉苏工镂雕灵芝如意摆件","image":"http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411033118183.jpg","start_price":1300,"current_price":1300}]}
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
        private List<RecommendFieldBean> recommend_field;
        private List<Adv1Bean> adv1;
        private List<Adv2Bean> adv2;
        private List<RecommendItemBean> recommend_item;

        public List<RecommendFieldBean> getRecommend_field() {
            return recommend_field;
        }

        public void setRecommend_field(List<RecommendFieldBean> recommend_field) {
            this.recommend_field = recommend_field;
        }

        public List<Adv1Bean> getAdv1() {
            return adv1;
        }

        public void setAdv1(List<Adv1Bean> adv1) {
            this.adv1 = adv1;
        }

        public List<Adv2Bean> getAdv2() {
            return adv2;
        }

        public void setAdv2(List<Adv2Bean> adv2) {
            this.adv2 = adv2;
        }

        public List<RecommendItemBean> getRecommend_item() {
            return recommend_item;
        }

        public void setRecommend_item(List<RecommendItemBean> recommend_item) {
            this.recommend_item = recommend_item;
        }

        public static class RecommendFieldBean {
            /**
             * id : 26
             * name : 集萃斋玉器杂项
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050213454947150.jpg
             * organization_id : 1
             * is_favorite : true
             * item_count : 21
             * bid_count : 0
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

        public static class Adv1Bean {
            /**
             * adv_id : 38
             * adv_title : 首页广告
             * link :
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png
             */

            private int adv_id;
            private String adv_title;
            private String link;
            private String image;

            private Integer link_type ;
            private String link_value ;

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
        }

        public static class Adv2Bean {
            /**
             * adv_id : 41
             * adv_title : 首页广告2-1
             * link :
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_36205_2018050511455572398.jpg
             */

            private int adv_id;
            private String adv_title;
            private String link;
            private String image;
            private Integer link_type ;
            private String link_value ;
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
        }

        public static class RecommendItemBean {
            /**
             * id : 190
             * name : a10540335 20世纪80年代 和田白玉岁岁平安大玉璧
             * image : http://hancang.oss-cn-beijing.aliyuncs.com/home/store/goods/1/oss_1_2018050411462028477.jpg
             * start_price : 12000
             * current_price : 12000
             */

            private int id;
            private String name;
            private String image;
            private int start_price;
            private int current_price;

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

            public int getStart_price() {
                return start_price;
            }

            public void setStart_price(int start_price) {
                this.start_price = start_price;
            }

            public int getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(int current_price) {
                this.current_price = current_price;
            }
        }
    }
}
