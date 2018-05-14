package com.intention.sqtwin.bean;

import java.io.Serializable;

/**
 * @data 2017/4/28 0028
 * @aurher Administrator
 */

public class SQTUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private int member_id;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
}
