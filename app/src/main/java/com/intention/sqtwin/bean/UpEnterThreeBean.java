package com.intention.sqtwin.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午1:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */
/*
*
* 1	name	姓名	string
2
id_card	 身份证号	 string
3
phone	电话	int
4	 id_card_photo_front 	 身份证正面照	 string
5	id_card_photo_back	 身份证反面照	 string
6	id_card_in_hand	 手持身份证照片	 string	*/
public class UpEnterThreeBean {
    private String name;
    private String id_card;
    private int phone;
    private String id_card_photo_front;
    private String id_card_photo_back;
    private String id_card_in_hand;

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
