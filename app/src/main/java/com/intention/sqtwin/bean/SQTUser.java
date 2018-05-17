package com.intention.sqtwin.bean;

import java.io.Serializable;

/**
 * @data 2017/4/28 0028
 * @aurher Administrator
 */

public class SQTUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String image;
    private String name;
    private String sex;
    private String birthday;
    private String member_provinceid;
    private String member_cityid;
    private String member_areaid;
    private String phone;

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
}
