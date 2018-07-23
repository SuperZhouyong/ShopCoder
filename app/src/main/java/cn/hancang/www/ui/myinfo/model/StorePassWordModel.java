package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.StoreLoginNameBean;
import cn.hancang.www.bean.StorePwInfoBean;
import cn.hancang.www.ui.myinfo.contract.StorePassWordContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:26
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StorePassWordModel implements StorePassWordContract.Model {
    @Override
    public Observable<StoreLoginNameBean> getStoreLoginName() {
        return Api.getDefault(HostType.Jsonpart).getStoreLoginName().compose(RxSchedulers.<StoreLoginNameBean>io_main());
    }

    @Override
    public Observable<StorePwInfoBean> postStorePw(String name, String pw,String oldPw) {
        return Api.getDefault(HostType.Jsonpart).PostStorePwInfo(name, pw,oldPw).compose(RxSchedulers.<StorePwInfoBean>io_main());
    }
}
