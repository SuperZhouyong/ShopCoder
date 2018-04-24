package com.intention.sqtwin.bean;

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
     * data : {"adv1":[{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c6742b0a8834fdd2bd52755329009f4e.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/4fde81b8316b0981bc9b3cf0c0220696.jpg","link":"链接"}],"adv2":[{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c6742b0a8834fdd2bd52755329009f4e.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/4fde81b8316b0981bc9b3cf0c0220696.jpg","link":"链接"}],"recommend_item":[{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"},{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"},{"id":5,"name":"拍品名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","current_price":"888","start_price":"666","bid_leader":"石头"}],"recommend_field":[{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}]}
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
        private List<Adv1Bean> adv1;
        private List<Adv2Bean> adv2;
        private List<RecommendItemBean> recommend_item;
        private List<RecommendFieldBean> recommend_field;

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

        public List<RecommendFieldBean> getRecommend_field() {
            return recommend_field;
        }

        public void setRecommend_field(List<RecommendFieldBean> recommend_field) {
            this.recommend_field = recommend_field;
        }

        public static class Adv1Bean {
            /**
             * id : 5
             * name : 图片名称
             * image : http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg
             * link : 链接
             */

            private int id;
            private String name;
            private String image;
            private String link;

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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class Adv2Bean {
            /**
             * id : 5
             * name : 图片名称
             * image : http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg
             * link : 链接
             */

            private int id;
            private String name;
            private String image;
            private String link;

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

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class RecommendItemBean {
            /**
             * id : 5
             * name : 拍品名称
             * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * current_price : 888
             * start_price : 666
             * bid_leader : 石头
             */

            private int id;
            private String name;
            private String image;
            private String current_price;
            private String start_price;
            private String bid_leader;

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

            public String getCurrent_price() {
                return current_price;
            }

            public void setCurrent_price(String current_price) {
                this.current_price = current_price;
            }

            public String getStart_price() {
                return start_price;
            }

            public void setStart_price(String start_price) {
                this.start_price = start_price;
            }

            public String getBid_leader() {
                return bid_leader;
            }

            public void setBid_leader(String bid_leader) {
                this.bid_leader = bid_leader;
            }
        }

        public static class RecommendFieldBean {
            /**
             * id : 5
             * name : 拍场名称
             * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
             * is_favorite : false
             * start_time : 2018-2-1 10:00:00
             * end_time : 2018-3-1 10:00:00
             * item_count : 50
             * bid_count : 50
             * fans_count : 500
             * organzation : {"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}
             */

            private int id;
            private String name;
            private String image;
            private String is_favorite;
            private String start_time;
            private String end_time;
            private String item_count;
            private String bid_count;
            private String fans_count;
            private OrganzationBean organzation;

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

            public String getIs_favorite() {
                return is_favorite;
            }

            public void setIs_favorite(String is_favorite) {
                this.is_favorite = is_favorite;
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

            public String getItem_count() {
                return item_count;
            }

            public void setItem_count(String item_count) {
                this.item_count = item_count;
            }

            public String getBid_count() {
                return bid_count;
            }

            public void setBid_count(String bid_count) {
                this.bid_count = bid_count;
            }

            public String getFans_count() {
                return fans_count;
            }

            public void setFans_count(String fans_count) {
                this.fans_count = fans_count;
            }

            public OrganzationBean getOrganzation() {
                return organzation;
            }

            public void setOrganzation(OrganzationBean organzation) {
                this.organzation = organzation;
            }

            public static class OrganzationBean {
                /**
                 * id : 5
                 * name : 拍卖机构名称
                 * logo : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg
                 */

                private String id;
                private String name;
                private String logo;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }
            }
        }
    }
}
