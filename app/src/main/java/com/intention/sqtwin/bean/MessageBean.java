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


    /**
     * is_success : true
     * message : 操作成功
     * data : [{"id":4,"title":"测试消息1","message":"测试消息1","statu":2,"type":null,"content_id":null,"image":null,"msg_time":0},{"id":5,"title":"测试消息2","message":"测试消息2","statu":2,"type":null,"content_id":null,"image":null,"msg_time":0}]
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
         * id : 4
         * title : 测试消息1
         * message : 测试消息1
         * statu : 2
         * type : null
         * content_id : null
         * image : null
         * msg_time : 0
         */

        private int id;
        private String title;
        private String message;
        private int statu;
        private Object type;
        private Object content_id;
        private String image;
        private int msg_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatu() {
            return statu;
        }

        public void setStatu(int statu) {
            this.statu = statu;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getContent_id() {
            return content_id;
        }

        public void setContent_id(Object content_id) {
            this.content_id = content_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getMsg_time() {
            return msg_time;
        }

        public void setMsg_time(int msg_time) {
            this.msg_time = msg_time;
        }
    }
}
