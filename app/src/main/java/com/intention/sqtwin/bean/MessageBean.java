package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessageBean {

    private boolean is_success;
    private String message;
    private AllDateBean.DataBean data;

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

    public AllDateBean.DataBean getData() {
        return data;
    }

    public void setData(AllDateBean.DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<AllDateBean.DataBean.RecommendFieldBean> recommend_field;
        private List<AllDateBean.DataBean.Adv1Bean> adv1;
        private List<AllDateBean.DataBean.Adv2Bean> adv2;
        private List<AllDateBean.DataBean.RecommendItemBean> recommend_item;

        public List<AllDateBean.DataBean.RecommendFieldBean> getRecommend_field() {
            return recommend_field;
        }

        public void setRecommend_field(List<AllDateBean.DataBean.RecommendFieldBean> recommend_field) {
            this.recommend_field = recommend_field;
        }

        public List<AllDateBean.DataBean.Adv1Bean> getAdv1() {
            return adv1;
        }

        public void setAdv1(List<AllDateBean.DataBean.Adv1Bean> adv1) {
            this.adv1 = adv1;
        }

        public List<AllDateBean.DataBean.Adv2Bean> getAdv2() {
            return adv2;
        }

        public void setAdv2(List<AllDateBean.DataBean.Adv2Bean> adv2) {
            this.adv2 = adv2;
        }

        public List<AllDateBean.DataBean.RecommendItemBean> getRecommend_item() {
            return recommend_item;
        }

        public void setRecommend_item(List<AllDateBean.DataBean.RecommendItemBean> recommend_item) {
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
            private AllDateBean.DataBean.RecommendFieldBean.OrganizationBean organization;
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

            public AllDateBean.DataBean.RecommendFieldBean.OrganizationBean getOrganization() {
                return organization;
            }

            public void setOrganization(AllDateBean.DataBean.RecommendFieldBean.OrganizationBean organization) {
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
