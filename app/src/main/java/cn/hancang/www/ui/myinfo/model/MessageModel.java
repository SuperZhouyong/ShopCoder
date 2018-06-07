package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.MessageBean;
import cn.hancang.www.ui.myinfo.contract.MessageContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:55
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessageModel implements MessageContract.Model {
    @Override
    public Observable<MessageBean> getMessagebean(Integer page_no) {
        return Api.getDefault(HostType.Jsonpart).getMessageBean(page_no).compose(RxSchedulers.<MessageBean>io_main());
    }
}
