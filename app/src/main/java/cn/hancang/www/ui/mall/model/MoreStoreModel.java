package cn.hancang.www.ui.mall.model;

import com.intention.sqtwin.bean.AllStoreListBean;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.ui.mall.contract.MoreStoreContract;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-上午1:03
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MoreStoreModel implements MoreStoreContract.Model {
    @Override
    public Observable<AllStoreListBean> getAllStoreListData(int page) {
        return Api.getDefault(HostType.Jsonpart).getAllStoreListData(page).compose(RxSchedulers.<AllStoreListBean>io_main());
    }
}
