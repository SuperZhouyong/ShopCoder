package cn.hancang.www.ui.main.contract;

import cn.hancang.www.bean.AuitemPicBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BaseView;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/28-下午9:12
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface auitemItemPicContract {
    interface View extends BaseView{
        void returnAuitemPicBean(AuitemPicBean auitemPicBean);
    }
    interface Model extends BaseModel{
        Observable<AuitemPicBean> getAuitemBeanData();
    }
}
