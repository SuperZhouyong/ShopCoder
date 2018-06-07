package cn.hancang.www.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class User {
    @Id
    private long id;
    private String userName;
    private String Code;
    private String Fneshu;
    private int age;
    private String gender;

    @Generated(hash = 625630968)
    public User(long id, String userName, String Code, String Fneshu, int age,
                String gender) {
        this.id = id;
        this.userName = userName;
        this.Code = Code;
        this.Fneshu = Fneshu;
        this.age = age;
        this.gender = gender;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getFneshu() {
        return this.Fneshu;
    }

    public void setFneshu(String Fneshu) {
        this.Fneshu = Fneshu;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
