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
     * data : [{"id":0,"url":"http://hancang.oss-cn-beijing.aliyuncs.com/20180523101035/F9373CF6-BA17-5C38-42D7-3508BE7FD588.jpg"}]
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
         * url : http://hancang.oss-cn-beijing.aliyuncs.com/20180523101035/F9373CF6-BA17-5C38-42D7-3508BE7FD588.jpg
         */

        private int id;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
