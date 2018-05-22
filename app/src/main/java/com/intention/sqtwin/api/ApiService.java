package com.intention.sqtwin.api;


import com.intention.sqtwin.bean.AccountBean;
import com.intention.sqtwin.bean.AgentBidBean;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.ArtDetailBean;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.bean.AuctionListBean;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.BidBean;
import com.intention.sqtwin.bean.BidRecordBean;
import com.intention.sqtwin.bean.BindCardInfoBean;
import com.intention.sqtwin.bean.CategoryAllBean;
import com.intention.sqtwin.bean.ChargeBean;
import com.intention.sqtwin.bean.DerivativesBean;
import com.intention.sqtwin.bean.LoginBean;
import com.intention.sqtwin.bean.MessageBean;
import com.intention.sqtwin.bean.MyCompeteBean;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.bean.OrderListBean;
import com.intention.sqtwin.bean.OrganPeBean;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.bean.ReceivedGoodsBean;
import com.intention.sqtwin.bean.StoreInfoBean;
import com.intention.sqtwin.bean.StoreInfoComBean;
import com.intention.sqtwin.bean.StoreMessageBean;
import com.intention.sqtwin.bean.StoreMoneyBean;
import com.intention.sqtwin.bean.StoreReportOne;
import com.intention.sqtwin.bean.StoreReportTwo;
import com.intention.sqtwin.bean.SubmitAddressBean;
import com.intention.sqtwin.bean.SubmitClientInfo;
import com.intention.sqtwin.bean.SubmitInfoBean;
import com.intention.sqtwin.bean.SynchronousAuctionBean;
import com.intention.sqtwin.bean.SynchronousItemBean;
import com.intention.sqtwin.bean.TradingDeatilBean;
import com.intention.sqtwin.bean.UpdateAddressBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateIndentityBean;
import com.intention.sqtwin.bean.UpdateResultInfo;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscription;

/**
 * des:ApiService
 * Created by xsfm
 * on 2016.06.15:47
 */
public interface ApiService {
    /*
    * HOmePage 首页全部数据
    *
    * */
    @GET("index/index")
    Observable<AllDateBean> getHomeAllDate();

    /**
     * @param categoryId
     * @param status
     * @param page_no
     * @return 获取自营拍的数据
     */
    @GET("Auctionfield/get_self_auction_field_info")
    Observable<PpAllDateBean> getPlAllDate(
            @Query("category_id") Integer categoryId,
            @Query("status") Integer status,
            @Query("page_no") Integer page_no


    );

    /**
     * @param auction_field_id
     * @return 获取拍场的数据
     */
    @GET("auction/get_field_page_info")
    Observable<AuctionFiledAllBean> getAuctionFiled(
            @Query("auction_field_id") Integer auction_field_id,
            @Query("sort") Integer sort
    );

    /**
     * @param id
     * @return 出价界面
     */
    @GET("Auction/get_price_history")
    Observable<BidRecordBean> getBidRecord(
            @Query("goods_id") Integer id
    );

    /**
     * @param artId
     * @param page_no
     * @return 艺术者详情
     */
    @GET("auction/get_artist_home")
    Observable<ArtDetailBean> getArtDetail(
            @Query("artist_id") Integer artId,
            @Query("page_no") Integer page_no);

    /**
     * @param OrgId
     * @param page_no
     * @return 拍卖机构主页
     */
    @GET("auction/get_organization_home")
    Observable<AuctionOrgBean> getArtIst(
            @Query("organization_id") Integer OrgId,
            @Query("page_no") Integer page_no);

    /**
     * @param staff_id
     * @param page
     * @return 获取主理人数据
     */
    @GET("auction/get_staff_home")
    Observable<OrganPeBean> getOrganPeData(
            @Query("staff_id") Integer staff_id,
            @Query("page_no") Integer page
    );

    /**
     * @param id
     * @return 获取拍品界面
     */
    @GET("auction/get_item_info")
    Observable<AutionItemDetailBean> getAuctionItemDetail(
            @Query("auction_item_id") Integer id);

    /**
     * @param categoryId
     * @return 分类界面数据
     */
    @GET("auction/get_category")
    Observable<CategoryAllBean> getCategoryDate(
            @Query("current_category_id") Integer categoryId);

    /**
     * @param category
     * @param page
     * @return 拍品列表页
     */
    @GET("auction/get_auction_item_list")
    Observable<AuctionListBean> getAuctionList(
            @Query("category_id") Integer category,
            @Query("page_no") Integer page);

    /**
     * 获取订单列表 （会员中心）
     *
     * @param status  title状态
     * @param page_no 页码
     * @param type    个人和店铺的去人
     * @return
     */
    @GET("membercenter/get_order_list")
    Observable<OrderListBean> getOrderList(

            @Query("status") Integer status,
            @Query("page_no") Integer page_no,
            @Query("type") Integer type
    );

    /**
     * 获取消息列表
     *
     * @param page_no
     * @return
     */
    @GET("membercenter/get_message_list")
    Observable<MessageBean> getMessageBean(
            @Query("page_no") Integer page_no);

    /**
     * 获取账户信息
     *
     * @param accountId
     * @return
     */
    @GET("membercenter/get_member_balance")
    Observable<AccountBean> getAccountBeab(

            @Query("id") Integer accountId);

    /**
     * 衍生品界面
     *
     * @param type
     * @return
     */
    @GET("shop/get_goods_page")
    Observable<DerivativesBean> getDerivativesDate(
            @Query("docID") Integer type);

    /**
     * 我的竞拍
     *
     * @param page
     * @return
     */
    @GET("membercenter/get_bid_item_list")
    Observable<MyCompeteBean> getMyCompeteBean(
            @Query("page_no") Integer page);

    /**
     * goods_id 拍品id  price 报价 member_id 报价者id
     *
     * @param good_id
     * @param price
     * @param member_id
     * @return
     */
    @GET("auction/agentbid")
    Observable<AgentBidBean> getAgenBidDate(
            @Query("goods_id") Integer good_id,
            @Query("price") Integer price,
            @Query("member_id") Integer member_id
    );

    /**
     * 出价
     *
     * @param good_id
     * @param price
     * @param member_id
     * @return
     */
    @GET("auction/bid")
    Observable<BidBean> getBidDate(
            @Query("goods_id") Integer good_id,
            @Query("price") Integer price,
            @Query("member_id") Integer member_id
    );

    /**
     * 登陆接口
     *
     * @param phone
     * @param coer
     * @return
     */
    @FormUrlEncoded
    @POST("membercenter/login")
    Observable<LoginBean> getLoginBean(
            @Field("phone") String phone,
            @Field("code") String coer
    );

    /*
    * 同步拍
    * */
    @GET("auction/sync_auction_field")
    Observable<SynchronousAuctionBean> getSynchronousAuction(

            @Query("page_no") Integer page_no);

    /**
     * 同步拍拍品
     *
     * @param goods_id
     * @return
     */
    @GET("auction/sync_auction_goods")
    Observable<SynchronousItemBean> getSynchronousItemBean(
            @Query("goods_id") Integer goods_id
    );

    /**
     * 获取个人信息
     *
     * @return
     */
    @GET("membercenter/get_member_info")
    Observable<MyInfoBean> getMyInfoBean();

    /**
     * 上传照片各种参数，身份认证
     *
     * @param body
     * @return
     */
    @Multipart
    @POST("")
    Observable<UpdateIndentityBean> getUpdateIndentity(
//            @PartMap() Map<String, RequestBody> maps
            @Body RequestBody body

    );

    /**
     * 绑定银行卡号
     *
     * @param bank_account_name
     * @param bank_name
     * @param bank_card_number
     * @return
     */
    @FormUrlEncoded
    @POST("Membercenter/Member_bind_card_info")
    Observable<BindCardInfoBean> getBindCardInfo(
            @Field("bank_account_name") String bank_account_name,
            @Field("bank_name") String bank_name,
            @Field("bank_card_number") String bank_card_number
    );

    /**
     * 收货地址列表
     *
     * @return
     */
    @GET("membercenter/get_address_list")
    Observable<ReceivedGoodsBean> getReceivedGoods();
/*
*   @Field("name") String name,
            @Field("phone") String phone,
            @Field("province_id") Integer id,
            @Field("city_id") Integer city_id,
            @Field("area_id") Integer area_id,
            @Field("address_is_default") Integer address_is_default,
            @Field("op") Integer op*/

    /**
     * 修改和新增地址
     *
     * @return
     */
    @FormUrlEncoded
    @POST("Membercenter/Member_address_edit_submit")
    Observable<SubmitAddressBean> submitAddress(
            @Body UpdateAddressBean updateAddressBean
    );

    /**
     * 获取全部地址
     *
     * @return
     */
    @GET("membercenter/get_area_info")
    Observable<AllRegion> getAllRegion();

    /**
     * @return
     */
    @FormUrlEncoded
    @POST("membercenter/recharge")
    Observable<ChargeBean> getChargeBean(
            @Field("recharge") Float recharge

    );

    /**
     * 入驻界面
     *
     * @return
     */
    @GET("membercenter/get_store_info")
    Observable<StoreInfoBean> getStoreInfo(


    );

    /**
     * 获取交易明细
     *
     * @return
     */
    @GET("Membercenter/financial_details")
    Observable<TradingDeatilBean> getTradingDeatil();

    /**
     * 获取店铺关注列表
     *
     * @return
     */
    @GET("membercenter/get_favorite")
    Observable<StoreInfoComBean> getStoreInfoComBean(
            @Query("page") Integer page,
            @Query("type") Integer type
    );

    /**
     * 获取卖家消息列表
     *
     * @return
     */
    @GET("membercenter/get_store_message_list")
    Observable<StoreMessageBean> getStoreMessagebean();

    /**
     * 获取店铺余额
     *
     * @return
     */
    @GET("membercenter/get_store_balance")
    Observable<StoreMoneyBean> get_store_balance();

    /**
     * 获取 资金报表接口
     *
     * @return
     */
    @GET("membercenter/get_capital_report")
    Observable<StoreReportOne> getCapitalReport();

    /**
     * 获取 经营报表接口
     *
     * @return
     */
    @GET("membercenter/get_manage_report")
    Observable<StoreReportTwo> getManageReport();

    /**
     * 万能上传多张图片
     *
     * @param maps
     * @return
     */
    @Multipart
    @POST("index/batch_upload_images")
    Observable<UpdateImageBean> PostImage(
            @PartMap Map<String, RequestBody> maps
    );

    /**
     * 提交编辑的信息
     *
     * @param submitClientInfo
     * @return
     */
    @POST("membercenter/member_edit_submit")
    Observable<UpdateResultInfo> submitInfo(
            @Body SubmitClientInfo submitClientInfo
    );

    /**
     * 获取商城列表的数据
     *
     * @return
     */
    @GET("Taobao/Taobao_index")
    Observable<AllMallDateBean> getAllMallDate();
}
