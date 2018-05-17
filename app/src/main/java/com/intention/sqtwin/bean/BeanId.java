package com.intention.sqtwin.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-下午 18:31
 * Blog：Super简单
 * Author: ZhouYong
 */

public class BeanId implements Parcelable {
    private String ProvinceId;
    private String CityId;
    private String RegionID;

    public String getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(String provinceId) {
        ProvinceId = provinceId;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String regionID) {
        RegionID = regionID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ProvinceId);
        dest.writeString(this.CityId);
        dest.writeString(this.RegionID);
    }

    public BeanId() {
    }

    protected BeanId(Parcel in) {
        this.ProvinceId = in.readString();
        this.CityId = in.readString();
        this.RegionID = in.readString();
    }

    public static final Parcelable.Creator<BeanId> CREATOR = new Parcelable.Creator<BeanId>() {
        @Override
        public BeanId createFromParcel(Parcel source) {
            return new BeanId(source);
        }

        @Override
        public BeanId[] newArray(int size) {
            return new BeanId[size];
        }
    };
}
