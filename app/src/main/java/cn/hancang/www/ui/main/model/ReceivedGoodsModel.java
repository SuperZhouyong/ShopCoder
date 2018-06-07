package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.DeleteReceiverBean;
import cn.hancang.www.bean.ReceivedGoodsBean;
import cn.hancang.www.bean.SetDefaultAddressBean;
import cn.hancang.www.ui.main.contract.ReceivedGoodsContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-上午 11:15
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsModel implements ReceivedGoodsContract.Model {
    @Override
    public Observable<ReceivedGoodsBean> getReceivedGoodsBeanDate() {
        return Api.getDefault(HostType.Jsonpart).getReceivedGoods().compose(RxSchedulers.<ReceivedGoodsBean>io_main());
    }

    @Override
    public Observable<DeleteReceiverBean> getDeleteReceiver(Integer receiverId) {
        return Api.getDefault(HostType.Jsonpart).getDeleteReceiver(receiverId).compose(RxSchedulers.<DeleteReceiverBean>io_main());
    }

    @Override
    public Observable<SetDefaultAddressBean> getSetDefaultAddress(Integer addressId) {
        return Api.getDefault(HostType.Jsonpart).getSetDefaultAddress(addressId).compose(RxSchedulers.<SetDefaultAddressBean>io_main());
    }
}
