package com.intention.sqtwin.bean;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午1:19
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */
/*
*
* company_name	 企业名称	string
2
corporation_name	 法人姓名	 string
3
corporation_id_card_number	 法人身份证号
string
4	business_licence_number_electronic	 营业执照照片	string
5	corporation_id_card_photo_front	 法人身份证正面照	string
6	corporation_id_card_photo_back	 法人身份证反面照	string	*/
public class UpComPanyTwoBean {
    private String company_name;
    private String corporation_name;
    private String corporation_id_card_number;
    private String business_licence_number_electronic;
    private String corporation_id_card_photo_front;
    private String corporation_id_card_photo_back;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCorporation_name() {
        return corporation_name;
    }

    public void setCorporation_name(String corporation_name) {
        this.corporation_name = corporation_name;
    }

    public String getCorporation_id_card_number() {
        return corporation_id_card_number;
    }

    public void setCorporation_id_card_number(String corporation_id_card_number) {
        this.corporation_id_card_number = corporation_id_card_number;
    }

    public String getBusiness_licence_number_electronic() {
        return business_licence_number_electronic;
    }

    public void setBusiness_licence_number_electronic(String business_licence_number_electronic) {
        this.business_licence_number_electronic = business_licence_number_electronic;
    }

    public String getCorporation_id_card_photo_front() {
        return corporation_id_card_photo_front;
    }

    public void setCorporation_id_card_photo_front(String corporation_id_card_photo_front) {
        this.corporation_id_card_photo_front = corporation_id_card_photo_front;
    }

    public String getCorporation_id_card_photo_back() {
        return corporation_id_card_photo_back;
    }

    public void setCorporation_id_card_photo_back(String corporation_id_card_photo_back) {
        this.corporation_id_card_photo_back = corporation_id_card_photo_back;
    }
}
