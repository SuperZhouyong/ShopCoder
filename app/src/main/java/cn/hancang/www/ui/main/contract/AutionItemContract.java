package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AgentBidBean;
import cn.hancang.www.bean.AutionItemDetailBean;
import cn.hancang.www.bean.BidBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemContract {
    public interface Model extends BaseModel {

        // 获取拍品详情
        Observable<AutionItemDetailBean> getAutionDetaiData(Integer id);
       //代理出价  goods_id 拍品id  price 报价 member_id 报价者id
        Observable<AgentBidBean> getAgentBidDate(Integer goods_id,Integer price,Integer member_id);
        //出价
        Observable<BidBean> getBindDate(Integer goods_id,Integer price,Integer member_id);


        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);
    }

    public interface View extends BaseView {
//        void  returnWorkList(WorkerListBean workerListBean);
        void returnAutionItemDeatil(AutionItemDetailBean autionItemDetailBean);

        void returnAgentBidDate(AgentBidBean agentBidBean);

        void returnBidDate(BidBean bidBean);

        void returnAddFavBean(AddFavBean addFavBean);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {
//        public abstract void getWorkListRequest(Integer id, Integer type);
        public abstract void getAutionDetailRequest(Integer id);

        public abstract void getAgentBidBeanRequest(Integer goods_id,Integer price,Integer member_id);

        public abstract void getBidBeanRequest(Integer goods_id,Integer price,Integer member_id);

        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }
}
