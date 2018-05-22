package com.intention.sqtwin.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-上午 9:56
 * Blog：Super简单
 * Author: ZhouYong
 */

public class UpdateImageBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : [{"id":0,"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png"},{"id":1,"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png"},{"id":2,"image_url":"http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png"}]
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
         * id : 0
         * image_url : http://hancang.oss-cn-beijing.aliyuncs.com/home/auction/oss_78539_2018050511450375689.png
         */

        private int id;
        private String image_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
