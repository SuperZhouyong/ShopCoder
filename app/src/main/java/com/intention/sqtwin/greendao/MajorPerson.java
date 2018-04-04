package com.intention.sqtwin.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @data 2017/5/31 0031
 * @aurher Administrator
 */
@Entity
public class MajorPerson {
    @Id
    private String MajorId;
    private String MajorName;
    private String MajorSchoolName;

    @Generated(hash = 511165201)
    public MajorPerson(String MajorId, String MajorName, String MajorSchoolName) {
        this.MajorId = MajorId;
        this.MajorName = MajorName;
        this.MajorSchoolName = MajorSchoolName;
    }

    @Generated(hash = 1911871613)
    public MajorPerson() {
    }

    public String getMajorId() {
        return this.MajorId;
    }

    public void setMajorId(String MajorId) {
        this.MajorId = MajorId;
    }

    public String getMajorName() {
        return this.MajorName;
    }

    public void setMajorName(String MajorName) {
        this.MajorName = MajorName;
    }

    public String getMajorSchoolName() {
        return this.MajorSchoolName;
    }

    public void setMajorSchoolName(String MajorSchoolName) {
        this.MajorSchoolName = MajorSchoolName;
    }

    @Override
    public String toString() {
        return "MajorPerson{" +
                "MajorId='" + MajorId + '\'' +
                ", MajorName='" + MajorName + '\'' +
                ", MajorSchoolName='" + MajorSchoolName + '\'' +
                '}';
    }
}
