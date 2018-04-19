package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午9:39
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShufflingPictureBean {


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
