package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.MyCompeteBean;
import cn.hancang.www.ui.myinfo.contract.MyCompeteContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteModel implements MyCompeteContract.Model {
    @Override
    public Observable<MyCompeteBean> getMyCompeteDate(Integer page) {
        return Api.getDefault(HostType.Jsonpart).getMyCompeteBean(page).compose(RxSchedulers.<MyCompeteBean>io_main());
    }
}
