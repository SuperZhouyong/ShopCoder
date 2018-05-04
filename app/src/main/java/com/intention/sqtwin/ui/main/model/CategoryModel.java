package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.CategoryBena;
import com.intention.sqtwin.ui.main.contract.CategoryContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryModel implements CategoryContract.Model {
    @Override
    public Observable<CategoryBena> getCategoryDate(Integer CategoryId) {
        return Api.getDefault(HostType.Jsonpart).getCategoryDate(CategoryId).compose(RxSchedulers.<CategoryBena>io_main());
    }
}
