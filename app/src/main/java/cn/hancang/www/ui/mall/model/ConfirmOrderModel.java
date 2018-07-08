package cn.hancang.www.ui.mall.model;


import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.SubmitOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderModel  implements ConfirmOrderContract.Model{


  /*  @Override
    public Observable<ConfirmOrderBean> getConfirmOrderData(String orderList) {
        return Api.getDefault(HostType.Jsonpart).getGoodsBuyNew(orderList).compose(RxSchedulers.<ConfirmOrderBean>io_main());
    }*/

//    @Override
//    public Observable<GoodsBuyNewBean> getConfirmOrderData(Integer goodsId, Integer count) {
//        return Api.getDefault(HostType.Jsonpart).getGoodsBuyNew(goodsId, count).compose(RxSchedulers.<T>io_main());
//    }

    @Override
    public Observable<GoodsBuyNewBean> getConfirmOrderData(String goodsId, String count) {
        return Api.getDefault(HostType.Jsonpart).getGoodsBuyNew(goodsId, count).compose(RxSchedulers.<GoodsBuyNewBean>io_main());
    }

    @Override
    public Observable<SubmitOrderBean> getSubmitOrderBean(String goods_id, String count, Integer address_id, Integer pay_type, String remark) {
        return Api.getDefault(HostType.Jsonpart).getSubmitOrderInfo(goods_id,count,address_id,pay_type,remark).compose(RxSchedulers.<SubmitOrderBean>io_main());
    }



    @Override
    public Observable<OrderIdBean> getOrderIdBeanData(Double Num, String type, String remark) {
        return Api.getDefault(HostType.Jsonpart).getOrderIdBean(Num, type, remark).compose(RxSchedulers.<OrderIdBean>io_main());
    }

    @Override
    public Observable<GoodsBuyNewBean> getCreateOrderByWinner(String goods_id_list) {
        return Api.getDefault(HostType.Jsonpart).getconfirmorderDetail(goods_id_list).compose(RxSchedulers.<GoodsBuyNewBean>io_main());
    }
}
