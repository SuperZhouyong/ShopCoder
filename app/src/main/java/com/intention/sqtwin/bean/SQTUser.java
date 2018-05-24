package com.intention.sqtwin.bean;

import java.io.Serializable;

/**
 * @data 2017/4/28 0028
 * @aurher Administrator  目前按照后台的逻辑修改
 */

public class SQTUser implements Serializable {

    private static final long serialVersionUID = 2L;


    private int member_id = 13;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
}
