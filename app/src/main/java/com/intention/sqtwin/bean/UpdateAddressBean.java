package com.intention.sqtwin.bean;

import retrofit2.http.Field;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-下午 17:07
 * Blog：Super简单
 * Author: ZhouYong
 */

public class UpdateAddressBean {
    //名字
    private String name;
    //电话
    private String phone;
    // 省Id
    private Integer province_id;
    // 城市ID
    private Integer city_id;
    // 区域ID
    private Integer area_id;
    // 是否默认
    private Integer address_is_default;
    // 新增还是修改 0=新增，1=修改
    private Integer op;
    // 详细地址
    private String address ;

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

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Integer getAddress_is_default() {
        return address_is_default;
    }

    public void setAddress_is_default(Integer address_is_default) {
        this.address_is_default = address_is_default;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
