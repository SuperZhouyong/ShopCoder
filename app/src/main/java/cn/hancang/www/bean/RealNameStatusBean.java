package cn.hancang.www.bean;

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
     * data : {"id":16,"image":"http://hancang.oss-cn-beijing.aliyuncs.com/20180529165505/8D148B21-11E0-BCD9-56B5-4F9DC9670003.jpg","name":"法国观后感","sex":0,"birthday":null,"member_provinceid":null,"member_cityid":null,"member_areaid":null,"phone":"17600298095","join_type":1,"join_step":3,"join_state":"20","join_message":""}
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
         * id : 16
         * image : http://hancang.oss-cn-beijing.aliyuncs.com/20180529165505/8D148B21-11E0-BCD9-56B5-4F9DC9670003.jpg
         * name : 法国观后感
         * sex : 0
         * birthday : null
         * member_provinceid : null
         * member_cityid : null
         * member_areaid : null
         * phone : 17600298095
         * join_type : 1
         * join_step : 3
         * join_state : 20
         * join_message :
         */

        private int id;
        private String image;
        private String name;
        private int sex;
        private Object birthday;
        private Object member_provinceid;
        private Object member_cityid;
        private Object member_areaid;
        private String phone;
        private int join_type;
        private int join_step;
        private String join_state;
        private String join_message;

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

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getMember_provinceid() {
            return member_provinceid;
        }

        public void setMember_provinceid(Object member_provinceid) {
            this.member_provinceid = member_provinceid;
        }

        public Object getMember_cityid() {
            return member_cityid;
        }

        public void setMember_cityid(Object member_cityid) {
            this.member_cityid = member_cityid;
        }

        public Object getMember_areaid() {
            return member_areaid;
        }

        public void setMember_areaid(Object member_areaid) {
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

        public String getJoin_state() {
            return join_state;
        }

        public void setJoin_state(String join_state) {
            this.join_state = join_state;
        }

        public String getJoin_message() {
            return join_message;
        }

        public void setJoin_message(String join_message) {
            this.join_message = join_message;
        }
    }
}
