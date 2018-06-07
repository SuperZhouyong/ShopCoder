package cn.hancang.www.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-下午 18:31
 * Blog：Super简单
 * Author: ZhouYong
 */

public class BeanId implements Parcelable {
    private Integer ProvinceId;
    private Integer CityId;
    private Integer RegionID;

    public Integer getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(Integer provinceId) {
        ProvinceId = provinceId;
    }

    public Integer getCityId() {
        return CityId;
    }

    public void setCityId(Integer cityId) {
        CityId = cityId;
    }

    public Integer getRegionID() {
        return RegionID;
    }

    public void setRegionID(Integer regionID) {
        RegionID = regionID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.ProvinceId);
        dest.writeValue(this.CityId);
        dest.writeValue(this.RegionID);
    }

    public BeanId() {
    }

    protected BeanId(Parcel in) {
        this.ProvinceId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.CityId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.RegionID = (Integer) in.readValue(Integer.class.getClassLoader());
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
