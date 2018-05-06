package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryAllBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"category":[{"category_id":19,"name":"中国书画","image":"","parent_id":107,"create_time":"2018-04-19 13:17:13","description":"书画","display_order":11,"is_system":0},{"category_id":33,"name":"古典文献","image":"","parent_id":107,"create_time":"2018-04-19 13:32:47","description":"古典文献","display_order":22,"is_system":0},{"category_id":43,"name":"西画雕塑","image":"","parent_id":107,"create_time":"2018-04-19 13:36:02","description":"西画雕塑","display_order":0,"is_system":0},{"category_id":51,"name":"邮品钱币","image":"","parent_id":107,"create_time":"2018-04-19 13:38:21","description":"邮品钱币","display_order":0,"is_system":0},{"category_id":59,"name":"茶酒滋补","image":"","parent_id":107,"create_time":"2018-04-19 13:41:30","description":"茶酒滋补","display_order":0,"is_system":0},{"category_id":67,"name":"古董珍玩","image":"","parent_id":107,"create_time":"2018-04-19 13:44:12","description":"古董珍玩","display_order":0,"is_system":0},{"category_id":74,"name":"玉翠珠宝","image":"","parent_id":107,"create_time":"2018-04-19 14:05:11","description":"玉翠珠宝","display_order":0,"is_system":0},{"category_id":86,"name":"文玩杂项","image":"","parent_id":107,"create_time":"2018-04-19 14:13:49","description":"文玩杂项","display_order":0,"is_system":0},{"category_id":95,"name":"香道花道","image":"","parent_id":107,"create_time":"2018-04-19 14:28:04","description":"香道花道","display_order":0,"is_system":0},{"category_id":103,"name":"奢侈品","image":"","parent_id":107,"create_time":"2018-04-19 14:30:02","description":"奢侈品","display_order":8,"is_system":0}],"sub_category":[{"category_id":20,"name":"山水","image":"","parent_id":19,"create_time":"2018-04-19 13:26:52","description":"山水","display_order":0,"is_system":0},{"category_id":21,"name":"花鸟","image":"","parent_id":19,"create_time":"2018-04-19 13:27:16","description":"花鸟","display_order":0,"is_system":0},{"category_id":22,"name":"人物","image":"","parent_id":19,"create_time":"2018-04-19 13:27:33","description":"人物","display_order":0,"is_system":0},{"category_id":23,"name":"画瓷","image":"","parent_id":19,"create_time":"2018-04-19 13:28:34","description":"画瓷","display_order":0,"is_system":0},{"category_id":24,"name":"楷书","image":"","parent_id":19,"create_time":"2018-04-19 13:28:48","description":"楷书","display_order":0,"is_system":0},{"category_id":25,"name":"行书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:07","description":"行书","display_order":0,"is_system":0},{"category_id":26,"name":"隶书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:24","description":"隶书","display_order":0,"is_system":0},{"category_id":27,"name":"篆书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:36","description":"篆书","display_order":0,"is_system":0},{"category_id":28,"name":"草书","image":"","parent_id":19,"create_time":"2018-04-19 13:29:48","description":"草书","display_order":0,"is_system":0},{"category_id":29,"name":"篆刻","image":"","parent_id":19,"create_time":"2018-04-19 13:30:02","description":"篆刻","display_order":0,"is_system":0},{"category_id":30,"name":"匾额","image":"","parent_id":19,"create_time":"2018-04-19 13:30:17","description":"匾额","display_order":0,"is_system":0},{"category_id":31,"name":"漆书","image":"","parent_id":19,"create_time":"2018-04-19 13:30:30","description":"漆书","display_order":0,"is_system":0},{"category_id":32,"name":"其他","image":"","parent_id":19,"create_time":"2018-04-19 13:30:44","description":"其他","display_order":0,"is_system":0}]}
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
        private List<CategoryBean> category;
        private List<SubCategoryBean> sub_category;

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<SubCategoryBean> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<SubCategoryBean> sub_category) {
            this.sub_category = sub_category;
        }

        public static class CategoryBean {
            /**
             * category_id : 19
             * name : 中国书画
             * image :
             * parent_id : 107
             * create_time : 2018-04-19 13:17:13
             * description : 书画
             * display_order : 11
             * is_system : 0
             */

            private int category_id;
            private String name;
            private String image;
            private int parent_id;
            private String create_time;
            private String description;
            private int display_order;
            private int is_system;

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

            public int getIs_system() {
                return is_system;
            }

            public void setIs_system(int is_system) {
                this.is_system = is_system;
            }
        }

        public static class SubCategoryBean {
            /**
             * category_id : 20
             * name : 山水
             * image :
             * parent_id : 19
             * create_time : 2018-04-19 13:26:52
             * description : 山水
             * display_order : 0
             * is_system : 0
             */

            private int category_id;
            private String name;
            private String image;
            private int parent_id;
            private String create_time;
            private String description;
            private int display_order;
            private int is_system;

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

            public int getIs_system() {
                return is_system;
            }

            public void setIs_system(int is_system) {
                this.is_system = is_system;
            }
        }
    }
}
