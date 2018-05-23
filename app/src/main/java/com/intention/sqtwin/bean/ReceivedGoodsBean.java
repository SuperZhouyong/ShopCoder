package com.intention.sqtwin.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-上午 11:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsBean {


    /**
     * is_success : true
     * message : 操作成功
     * data : [{"name":"挺好刚刚","phone":"1760029805","id":14,"address":"发GV发个哈哈哈","address_is_default":"0","province_id":3,"city_id":73,"area_id":1126,"province_name":"河北","city_name":"石家庄市","area_name":"井陉县"}]
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

    public static class DataBean implements Parcelable {
        /**
         * name : 挺好刚刚
         * phone : 1760029805
         * id : 14
         * address : 发GV发个哈哈哈
         * address_is_default : 0
         * province_id : 3
         * city_id : 73
         * area_id : 1126
         * province_name : 河北
         * city_name : 石家庄市
         * area_name : 井陉县
         */

        private String name;
        private String phone;
        private int id;
        private String address;
        private String address_is_default;
        private int province_id;
        private int city_id;
        private int area_id;
        private String province_name;
        private String city_name;
        private String area_name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress_is_default() {
            return address_is_default;
        }

        public void setAddress_is_default(String address_is_default) {
            this.address_is_default = address_is_default;
        }

        public int getProvince_id() {
            return province_id;
        }

        public void setProvince_id(int province_id) {
            this.province_id = province_id;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.phone);
            dest.writeInt(this.id);
            dest.writeString(this.address);
            dest.writeString(this.address_is_default);
            dest.writeInt(this.province_id);
            dest.writeInt(this.city_id);
            dest.writeInt(this.area_id);
            dest.writeString(this.province_name);
            dest.writeString(this.city_name);
            dest.writeString(this.area_name);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.name = in.readString();
            this.phone = in.readString();
            this.id = in.readInt();
            this.address = in.readString();
            this.address_is_default = in.readString();
            this.province_id = in.readInt();
            this.city_id = in.readInt();
            this.area_id = in.readInt();
            this.province_name = in.readString();
            this.city_name = in.readString();
            this.area_name = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
