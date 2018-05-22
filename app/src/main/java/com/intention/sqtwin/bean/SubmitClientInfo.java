package com.intention.sqtwin.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-上午 10:52
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SubmitClientInfo implements Parcelable {

    private String name;
    private String avatar;

    private String sex;
    private String address;
    private int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.avatar);
        dest.writeString(this.sex);
        dest.writeString(this.address);
        dest.writeInt(this.phone);
    }

    public SubmitClientInfo() {
    }

    protected SubmitClientInfo(Parcel in) {
        this.name = in.readString();
        this.avatar = in.readString();
        this.sex = in.readString();
        this.address = in.readString();
        this.phone = in.readInt();
    }

    public static final Parcelable.Creator<SubmitClientInfo> CREATOR = new Parcelable.Creator<SubmitClientInfo>() {
        @Override
        public SubmitClientInfo createFromParcel(Parcel source) {
            return new SubmitClientInfo(source);
        }

        @Override
        public SubmitClientInfo[] newArray(int size) {
            return new SubmitClientInfo[size];
        }
    };
}
