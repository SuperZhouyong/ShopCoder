package com.intention.sqtwin.bean;

/**
 * Description: 绝无Bug
 * Data：2018/5/25 0025-下午 17:26
 * Blog：Super简单
 * Author: ZhouYong
 */

public class RealNameStatusBean {

    /**
     * is_success : true
     * message : 操作成功
     * data : {"id":13,"image":"","name":"韦天水","sex":1,"birthday":"","member_provinceid":"","member_cityid":"","member_areaid":"","phone":"","join_type":1,"join_step":2}
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
         * id : 13
         * image :
         * name : 韦天水
         * sex : 1
         * birthday :
         * member_provinceid :
         * member_cityid :
         * member_areaid :
         * phone :
         * join_type : 1
         * join_step : 2
         */

        private int id;
        private String image;
        private String name;
        private int sex;
        private String birthday;
        private String member_provinceid;
        private String member_cityid;
        private String member_areaid;
        private String phone;
        private int join_type;
        private int join_step;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getMember_provinceid() {
            return member_provinceid;
        }

        public void setMember_provinceid(String member_provinceid) {
            this.member_provinceid = member_provinceid;
        }

        public String getMember_cityid() {
            return member_cityid;
        }

        public void setMember_cityid(String member_cityid) {
            this.member_cityid = member_cityid;
        }

        public String getMember_areaid() {
            return member_areaid;
        }

        public void setMember_areaid(String member_areaid) {
            this.member_areaid = member_areaid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getJoin_type() {
            return join_type;
        }

        public void setJoin_type(int join_type) {
            this.join_type = join_type;
        }

        public int getJoin_step() {
            return join_step;
        }

        public void setJoin_step(int join_step) {
            this.join_step = join_step;
        }
    }
}