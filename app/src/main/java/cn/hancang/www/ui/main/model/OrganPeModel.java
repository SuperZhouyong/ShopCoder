package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.OrganPeBean;
import cn.hancang.www.ui.main.contract.OrganPeContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeModel implements OrganPeContract.Model {
    @Override
    public Observable<OrganPeBean> getOrganPeData(Integer staffId, Integer page) {
        return Api.getDefault(HostType.Jsonpart).getOrganPeData(staffId, page).compose(RxSchedulers.<OrganPeBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
