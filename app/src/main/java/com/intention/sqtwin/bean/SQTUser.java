package com.intention.sqtwin.bean;

import java.io.Serializable;

/**
 * @data 2017/4/28 0028
 * @aurher Administrator
 */

public class SQTUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * gid : 1000052
     * phone : 15912345678
     * householdProvinceId : 340000
     * domicile : 安徽
     * name : 薛仁
     * sex : 1
     * createTime : 2017-09-25 15:23:46
     * lastLoginTime : 2017-09-27 10:32:37
     * loginTimes : 457
     * provinceId : 120000
     * provinceName : 天津
     * cityId : 120100
     * cityName : 天津
     * areaId : 120109
     * areaName : 大港区
     * schoolId : 365
     * subject : null
     * schoolName : 天津市大港区德远高中
     * grade : 1
     * classname : 56
     * registerType : 1
     * type : 2
     * semester : 高一上学期
     * isgrey : 0
     */

    private String gid;
    private String phone;
    private String householdProvinceId;
    private String domicile;
    private String name;
    private String sex;
    private String createTime;
    private String lastLoginTime;
    private String loginTimes;
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String areaId;
    private String areaName;
    private String schoolId;
    private String subject;
    private String schoolName;
    private String grade;
    private String classname;
    private String registerType;
    private int type;
    private String semester;
    private int isgrey;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHouseholdProvinceId() {
        return householdProvinceId;
    }

    public void setHouseholdProvinceId(String householdProvinceId) {
        this.householdProvinceId = householdProvinceId;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getIsgrey() {
        return isgrey;
    }

    public void setIsgrey(int isgrey) {
        this.isgrey = isgrey;
    }

    @Override
    public String toString() {
        return "SQTUser{" +
                "gid='" + gid + '\'' +
                ", phone='" + phone + '\'' +
                ", householdProvinceId='" + householdProvinceId + '\'' +
                ", domicile='" + domicile + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", loginTimes='" + loginTimes + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", subject='" + subject + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", grade='" + grade + '\'' +
                ", classname='" + classname + '\'' +
                ", registerType='" + registerType + '\'' +
                ", type=" + type +
                ", semester='" + semester + '\'' +
                ", isgrey=" + isgrey +
                '}';
    }
}
