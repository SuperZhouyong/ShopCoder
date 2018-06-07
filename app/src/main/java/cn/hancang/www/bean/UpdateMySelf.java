package cn.hancang.www.bean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/24 0024-下午 17:20
 * Blog：Super简单
 * Author: ZhouYong
 */

public class UpdateMySelf {
    // 名字
    private String member_name;
    //职位头衔
    private String profession;
    //身份证号
    private String id_card_number;
    // 身份证正面照
    private String id_card_photo_front;
    // 省份证背面照
    private String id_card_photo_back;
    //推荐人
    private String orderinviter_member_name;
    //工作证明
    private List<String> images;

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getId_card_photo_front() {
        return id_card_photo_front;
    }

    public void setId_card_photo_front(String id_card_photo_front) {
        this.id_card_photo_front = id_card_photo_front;
    }

    public String getId_card_photo_back() {
        return id_card_photo_back;
    }

    public void setId_card_photo_back(String id_card_photo_back) {
        this.id_card_photo_back = id_card_photo_back;
    }

    public String getOrderinviter_member_name() {
        return orderinviter_member_name;
    }

    public void setOrderinviter_member_name(String orderinviter_member_name) {
        this.orderinviter_member_name = orderinviter_member_name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
