package com.intention.sqtwin.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.intention.sqtwin.bean.ShufflingPictureBean;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;

import ezy.ui.view.BannerView;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午11:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public  class BannerViewFactory implements BannerView.ViewFactory<ShufflingPictureBean.DataBean> {
    @Override
    public View create(ShufflingPictureBean.DataBean item, int position, ViewGroup container) {
        ImageView iv = new ImageView(container.getContext());
//        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA);
        ImageLoaderUtils.display(container.getContext().getApplicationContext(),iv,item.getImage());
//            Glide.with(container.getContext().getApplicationContext()).load(item.image).apply(options).into(iv);
        return iv;
    }
}