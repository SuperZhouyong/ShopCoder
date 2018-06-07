package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.CategoryAllBean;
import cn.hancang.www.ui.main.contract.CategoryContract;

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
    public Observable<CategoryAllBean> getCategoryDate(Integer CategoryId) {
        return Api.getDefault(HostType.Jsonpart).getCategoryDate(CategoryId).compose(RxSchedulers.<CategoryAllBean>io_main());
    }
}
