package com.intention.sqtwin.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/16-下午11:49
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyInfoBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : {"id":5,"name":"拍场名称","image":"http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg","title":"头衔","sex":"男","birthday ":"2018-2-1 10:00:00","city_id":5,"address":"收货地址","phone":"18611396547"}
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
         * id : 5
         * name : 拍场名称
         * image : http://picture1.yidianchina.com/assets/upload/product/c64361c46cb89980f169bf385ece09a5_380x380.jpg
         * title : 头衔
         * sex : 男
         * birthday  : 2018-2-1 10:00:00
         * city_id : 5
         * address : 收货地址
         * phone : 18611396547
         */

        private int id;
        private String name;
        private String image;
        private String title;
        private String sex;
        private String birthday;
        private int city_id;
        private String address;
        private String phone;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
