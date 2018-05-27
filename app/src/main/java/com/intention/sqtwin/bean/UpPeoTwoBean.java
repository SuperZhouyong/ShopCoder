package com.intention.sqtwin.bean;

import android.support.annotation.NonNull;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-上午11:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class UpPeoTwoBean {
    // 名字
    private String name;
    private String id_card;
    private int phone;
    // 正面
    private String id_card_photo_front;
    // 背面
    private String id_card_photo_back;
    // 手持
    private String id_card_in_hand;

    //个人信息  或者  企业信息
//    @NonNull
    private int join_type ;

    public int getJoin_type() {
        return join_type;
    }

    public void setJoin_type(int join_type) {
        this.join_type = join_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getId_card_in_hand() {
        return id_card_in_hand;
    }

    public void setId_card_in_hand(String id_card_in_hand) {
        this.id_card_in_hand = id_card_in_hand;
    }
}
