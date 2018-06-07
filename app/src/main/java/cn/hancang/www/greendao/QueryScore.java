package cn.hancang.www.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Entity
public class QueryScore {
    @Id
    private long _id;
    private int tag;//
    private String areaName;// 高考所在地
    private String areaId;// 高考所在地id
    private String year;// 招生年份
    private String type;// 高考模式id
    private String typeName;// 高考模式名字
    private String batch;// 录取批次id
    private String batchName;// 录取批次名字
    private String schoolWords;// 院校关键词
    private String majorWords;// 专业关键词
    private String score;// 分数
    private String rank;// 排名
    private String schoolId;// 院校所在地id
    private String schoolName;// 院校所在地名称
    @Generated(hash = 1341795065)
    public QueryScore(long _id, int tag, String areaName, String areaId, String year, String type,
            String typeName, String batch, String batchName, String schoolWords, String majorWords,
            String score, String rank, String schoolId, String schoolName) {
        this._id = _id;
        this.tag = tag;
        this.areaName = areaName;
        this.areaId = areaId;
        this.year = year;
        this.type = type;
        this.typeName = typeName;
        this.batch = batch;
        this.batchName = batchName;
        this.schoolWords = schoolWords;
        this.majorWords = majorWords;
        this.score = score;
        this.rank = rank;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }
    @Generated(hash = 1826004767)
    public QueryScore() {
    }
    public int getTag() {
        return this.tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }
    public String getAreaName() {
        return this.areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getAreaId() {
        return this.areaId;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public String getYear() {
        return this.year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTypeName() {
        return this.typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getBatch() {
        return this.batch;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public String getBatchName() {
        return this.batchName;
    }
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
    public String getSchoolWords() {
        return this.schoolWords;
    }
    public void setSchoolWords(String schoolWords) {
        this.schoolWords = schoolWords;
    }
    public String getMajorWords() {
        return this.majorWords;
    }
    public void setMajorWords(String majorWords) {
        this.majorWords = majorWords;
    }
    public long get_id() {
        return this._id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "QueryScore{" +
                "_id=" + _id +
                ", tag=" + tag +
                ", areaName='" + areaName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", batch='" + batch + '\'' +
                ", batchName='" + batchName + '\'' +
                ", schoolWords='" + schoolWords + '\'' +
                ", majorWords='" + majorWords + '\'' +
                ", score='" + score + '\'' +
                ", rank='" + rank + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
