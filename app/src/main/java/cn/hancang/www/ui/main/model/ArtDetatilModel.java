package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.ArtDetailBean;
import cn.hancang.www.ui.main.contract.ArtDetatilContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午1:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetatilModel implements ArtDetatilContract.Model {
    @Override
    public Observable<ArtDetailBean> getArtDetailDate(Integer artId, Integer page_no) {
        return Api.getDefault(HostType.Jsonpart).getArtDetail(artId, page_no).compose(RxSchedulers.<ArtDetailBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavArt(Integer favId, String FavType) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(favId, FavType).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
