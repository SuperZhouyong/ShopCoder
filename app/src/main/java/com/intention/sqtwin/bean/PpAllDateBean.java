package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAllDateBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"main_category":[{"category_id":20,"name":"山水","image":"","parent_id":19,"create_time":"2018-04-19 13:26:52","description":"山水","display_order":0},{"category_id":21,"name":"花鸟","image":"","parent_id":19,"create_time":"2018-04-19 13:27:16","description":"花鸟","display_order":0},{"category_id":22,"name":"人物","image":"","parent_id":19,"create_time":"2018-04-19 13:27:33","description":"人物","display_order":0},{"category_id":23,"name":"画瓷","image":"","parent_id":19,"create_time":"2018-04-19 13:28:34","description":"画瓷","display_order":0},{"category_id":24,"name":"楷书","image":"","parent_id":19,"create_time":"2018-04-19 13:28:48","description":"楷书","display_order":0},{"category_id":25,"name":"行书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:07","description":"行书","display_order":0},{"category_id":26,"name":"隶书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:24","description":"隶书","display_order":0},{"category_id":27,"name":"篆书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:36","description":"篆书","display_order":0},{"category_id":28,"name":"草书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:48","description":"草书","display_order":0},{"category_id":29,"name":"篆刻","image":"","parent_id":19,"create_time":"2018-04-19 13:30:02","description":"篆刻","display_order":0},{"category_id":30,"name":"匾额","image":"","parent_id":19,"create_time":"2018-04-19 13:30:17","description":"匾额","display_order":0},{"category_id":31,"name":"漆书","image":"","parent_id":19,"create_time":"2018-04-19 13:30:30","description":"漆书","display_order":0},{"category_id":32,"name":"其他","image":"","parent_id":19,"create_time":"2018-04-19 13:30:44","description":"其他","display_order":0}],"adv":{"is_success":true,"message":"操作成功","data":[{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c6742b0a8834fdd2bd52755329009f4e.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/4fde81b8316b0981bc9b3cf0c0220696.jpg","link":"链接"}]},"auction_field_list":[{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}],"total_page":20}
     */

    private boolean is_success;
    private String message;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * main_category : [{"category_id":20,"name":"山水","image":"","parent_id":19,"create_time":"2018-04-19 13:26:52","description":"山水","display_order":0},{"category_id":21,"name":"花鸟","image":"","parent_id":19,"create_time":"2018-04-19 13:27:16","description":"花鸟","display_order":0},{"category_id":22,"name":"人物","image":"","parent_id":19,"create_time":"2018-04-19 13:27:33","description":"人物","display_order":0},{"category_id":23,"name":"画瓷","image":"","parent_id":19,"create_time":"2018-04-19 13:28:34","description":"画瓷","display_order":0},{"category_id":24,"name":"楷书","image":"","parent_id":19,"create_time":"2018-04-19 13:28:48","description":"楷书","display_order":0},{"category_id":25,"name":"行书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:07","description":"行书","display_order":0},{"category_id":26,"name":"隶书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:24","description":"隶书","display_order":0},{"category_id":27,"name":"篆书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:36","description":"篆书","display_order":0},{"category_id":28,"name":"草书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:48","description":"草书","display_order":0},{"category_id":29,"name":"篆刻","image":"","parent_id":19,"create_time":"2018-04-19 13:30:02","description":"篆刻","display_order":0},{"category_id":30,"name":"匾额","image":"","parent_id":19,"create_time":"2018-04-19 13:30:17","description":"匾额","display_order":0},{"category_id":31,"name":"漆书","image":"","parent_id":19,"create_time":"2018-04-19 13:30:30","description":"漆书","display_order":0},{"category_id":32,"name":"其他","image":"","parent_id":19,"create_time":"2018-04-19 13:30:44","description":"其他","display_order":0}]
         * adv : {"is_success":true,"message":"操作成功","data":[{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c6742b0a8834fdd2bd52755329009f4e.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/4fde81b8316b0981bc9b3cf0c0220696.jpg","link":"链接"}]}
         * auction_field_list : [{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}},{"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","is_favorite":"false","start_time":"2018-2-1 10:00:00","end_time":"2018-3-1 10:00:00","item_count":"50","bid_count":"50","fans_count":"500","organzation":{"id":"5","name":"拍卖机构名称","logo":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_800x800.jpg"}}]
         * total_page : 20
         */

        private AdvBean adv;
        private int total_page;
        private List<MainCategoryBean> main_category;
        private List<AuctionFieldListBean> auction_field_list;

        public AdvBean getAdv() {
            return adv;
        }

        public void setAdv(AdvBean adv) {
            this.adv = adv;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<MainCategoryBean> getMain_category() {
            return main_category;
        }

        public void setMain_category(List<MainCategoryBean> main_category) {
            this.main_category = main_category;
        }

        public List<AuctionFieldListBean> getAuction_field_list() {
            return auction_field_list;
        }

        public void setAuction_field_list(List<AuctionFieldListBean> auction_field_list) {
            this.auction_field_list = auction_field_list;
        }

        public static class AdvBean {
            /**
             * is_success : true
             * message : 操作成功
             * data : [{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c113f58beba6513c87d39940776ade26.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/c6742b0a8834fdd2bd52755329009f4e.jpg","link":"链接"},{"id":5,"name":"图片名称","image":"http://picture1.yidianchina.com/assets/upload/image/4fde81b8316b0981bc9b3cf0c0220696.jpg","link":"链接"}]
             */

            private boolean is_success;
            private String message;
            private List<DataBean> data;

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

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
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
        }

        public static class MainCategoryBean {
            /**
             * category_id : 20
             * name : 山水
             * image :
             * parent_id : 19
             * create_time : 2018-04-19 13:26:52
             * description : 山水
             * display_order : 0
             */

            private int category_id;
            private String name;
            private String image;
            private int parent_id;
            private String create_time;
            private String description;
            private int display_order;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
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

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getDisplay_order() {
                return display_order;
            }

            public void setDisplay_order(int display_order) {
                this.display_order = display_order;
            }
        }

        public static class AuctionFieldListBean {
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
