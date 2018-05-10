package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.MessageBean;
import com.intention.sqtwin.ui.myinfo.contract.MessageContract;

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
