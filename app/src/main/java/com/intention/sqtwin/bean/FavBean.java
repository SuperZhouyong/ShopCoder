package com.intention.sqtwin.bean;

/**
 * Description: 关注需要传递
 * Data：2018/5/23 0023-下午 17:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class FavBean {
    private Integer postion ;
    private Integer FavId ;

    public FavBean(Integer postion, Integer favId) {
        this.postion = postion;
        FavId = favId;
    }

    public Integer getPostion() {
        return postion;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    public Integer getFavId() {
        return FavId;
    }

    public void setFavId(Integer favId) {
        FavId = favId;
    }
}
