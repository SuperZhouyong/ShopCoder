package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.StoreInfoBean;
import cn.hancang.www.ui.main.contract.EnterContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EnterModel implements EnterContract.Model{
    @Override
    public Observable<StoreInfoBean> getStoreInfo() {
        return Api.getDefault(HostType.Jsonpart).getStoreInfo().compose(RxSchedulers.<StoreInfoBean>io_main());
    }
}
