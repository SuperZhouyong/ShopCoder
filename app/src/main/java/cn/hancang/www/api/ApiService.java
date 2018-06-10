package cn.hancang.www.api;


import cn.hancang.www.bean.AccountBean;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AgentBidBean;
import cn.hancang.www.bean.AllDateBean;
import cn.hancang.www.bean.AllMallDateBean;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.ArtDetailBean;
import cn.hancang.www.bean.AuctionFiledAllBean;
import cn.hancang.www.bean.AuctionListBean;
import cn.hancang.www.bean.AuctionOrgBean;
import cn.hancang.www.bean.AutionItemDetailBean;
import cn.hancang.www.bean.BidBean;
import cn.hancang.www.bean.BidRecordBean;
import cn.hancang.www.bean.BindCardInfoBean;
import cn.hancang.www.bean.CategoryAllBean;
import cn.hancang.www.bean.ChargeBean;
import cn.hancang.www.bean.DeleteFavBean;
import cn.hancang.www.bean.DeleteReceiverBean;
import cn.hancang.www.bean.DerivativesBean;
import cn.hancang.www.bean.GoosPageInfoBean;
import cn.hancang.www.bean.HotSearchInfoBean;
import cn.hancang.www.bean.IdentityProveBean;
import cn.hancang.www.bean.LoginBean;
import cn.hancang.www.bean.MessageBean;
import cn.hancang.www.bean.MyCompeteBean;
import cn.hancang.www.bean.MyInfoBean;
import cn.hancang.www.bean.NormalBankInfoBean;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.OrderIdDetailBean;
import cn.hancang.www.bean.OrderListBean;
import cn.hancang.www.bean.OrganPeBean;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.PayPassWordBean;
import cn.hancang.www.bean.PpAllDateBean;
import cn.hancang.www.bean.RealNamePeoTwoBean;
import cn.hancang.www.bean.RealNameStatusBean;
import cn.hancang.www.bean.ReanlNameStoreInfoBean;
import cn.hancang.www.bean.ReceivedGoodsBean;
import cn.hancang.www.bean.SearchInfoBean;
import cn.hancang.www.bean.SetDefaultAddressBean;
import cn.hancang.www.bean.ShopCartGoodsBean;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.bean.StoreInfoBean;
import cn.hancang.www.bean.StoreInfoComBean;
import cn.hancang.www.bean.StoreLoginNameBean;
import cn.hancang.www.bean.StoreMessageBean;
import cn.hancang.www.bean.StoreMoneyBean;
import cn.hancang.www.bean.StorePwInfoBean;
import cn.hancang.www.bean.StoreReportOne;
import cn.hancang.www.bean.StoreReportTwo;
import cn.hancang.www.bean.SubmitAddressBean;
import cn.hancang.www.bean.SubmitClientInfo;
import cn.hancang.www.bean.SynchronousAuctionBean;
import cn.hancang.www.bean.SynchronousItemBean;
import cn.hancang.www.bean.TaobaoStoreInfoBean;
import cn.hancang.www.bean.TellBackBean;
import cn.hancang.www.bean.TradingDeatilBean;
import cn.hancang.www.bean.UpComPanyTwoBean;
import cn.hancang.www.bean.UpEnterThreeBean;
import cn.hancang.www.bean.UpPeoTwoBean;
import cn.hancang.www.bean.UpdateAddressBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.bean.UpdateIndentityBean;
import cn.hancang.www.bean.UpdateMySelf;
import cn.hancang.www.bean.UpdateResultInfo;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

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
    @GET("auction/get_self_auction_field_info")
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
            @Query("page_no") Integer page_no,
            @Query("status") Integer status
    );

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
            @Query("page_no") Integer page,
            @Query("goods_type") Integer goods_type);

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

    @POST("membercenter/Member_address_submit")
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
     * @return membercenter/get_financial_details
     */
    @GET("membercenter/get_financial_details")
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

    /**
     * 删除收获地址
     *
     * @return
     */
    @GET("membercenter/delete_address_info")
    Observable<DeleteReceiverBean> getDeleteReceiver(
            @Query("address_id") Integer addressId
    );

    //index/del_fav_info?fav_id&fav_type 取消关注
    //http://ta.beikunit.com/api/index/get_fav_info?fav_id=1&fav_type=store 加入关注
    //类型:goods为商品,store为店铺, artst为艺术家, organ为拍卖机构，field为拍场

    /**
     * 加入关注
     *
     * @param fav_id
     * @param fav_type
     * @return
     */
    @GET("index/get_fav_info")
    Observable<AddFavBean> getAddFavbean(
            @Query("fav_id") Integer fav_id,
            @Query("fav_type") String fav_type
    );

    /**
     * 删除关注
     *
     * @param fac_id
     * @param fav_type
     * @return
     */
    @GET("index/del_fav_info")
    Observable<DeleteFavBean> getDeleteFavBean(
            @Query("fav_id") Integer fac_id,
            @Query("fav_type") String fav_type
    );

    /**
     * 获取淘宝店铺的信息
     *
     * @return
     */
    @GET("auction/get_store_home_page")
    Observable<TaobaoStoreInfoBean> getTaoBaoStoreInfo(
            @Query("store_id") Integer store_id
    );

    /**
     * 会员中心的 个人认证
     *
     * @param updateMySelf
     * @return
     */
    @POST("Membercenter/member_information")
    Observable<IdentityProveBean> getIdentityProveBean(
            @Body UpdateMySelf updateMySelf
    );

    /**
     * 获取已完成的认证状态
     *
     * @return
     */
    @GET("Membercenter/join_in_home")
    Observable<RealNameStatusBean> getRealNameStatus();

    /**
     * 上传个人认证 的 个人信息
     *
     * @param upPerTwoBean
     * @return
     */
    @POST("membercenter/post_member_info")
    Observable<RealNamePeoTwoBean> getPostRealNamePeoTwo(
            @Body UpPeoTwoBean upPerTwoBean
    );

    /**
     * 上传公司认证信息的第二部    RealNamePeoTwoBean 都是一个返回格式的数据
     *
     * @param upComPanyTwoBean
     * @return
     */
    @POST("membercenter/post_company_info")
    Observable<RealNamePeoTwoBean> getPostCompanyTwo(
            @Body UpComPanyTwoBean upComPanyTwoBean
    );

    /**
     * 暂时用不到  上传店铺信息 第三部
     *
     * @param upPeoTwoBean
     * @return
     */
    @POST("membercenter/post_member_info")
    Observable<RealNamePeoTwoBean> getPostRealEnterThree(@Body UpEnterThreeBean upPeoTwoBean);

    /**
     * 上传 店铺信息
     *
     * @param name
     * @param logo
     * @param description
     * @return
     */
    @FormUrlEncoded
    @POST("membercenter/join_post_store_info")
    Observable<ReanlNameStoreInfoBean> getPostRealNameStoreInfo(
            @Field("name") String name,
            @Field("logo") String logo,
            @Field("description") String description

    );

    /**
     * 获取商品信息页面
     *
     * @param goodsId
     * @return
     */
    @GET("shop/get_goods_info")
    Observable<GoosPageInfoBean> getGoodsPageInfo(
            @Query("goods_id") Integer goodsId);

    /**
     * 获得会员银行卡的信息
     *
     * @return
     */
    @GET("membercenter/get_bank_card")
    Observable<NormalBankInfoBean> getNormalBankInfo();

    /**
     * 设置为默认地址
     *
     * @param address_id
     * @return
     */
    @FormUrlEncoded
    @POST("membercenter/set_default_address")
    Observable<SetDefaultAddressBean> getSetDefaultAddress(
            @Field("address_id") Integer address_id
    );

    /**
     * 修改支付密码
     *
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("Membercenter/pay_password_edit")
    Observable<PayPassWordBean> getResetPayPassword(
            @Field("password") String password
    );

    /**
     * 修改登录密码
     *
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("Membercenter/log_password_edit")
    Observable<PayPassWordBean> getResetLoginPassword(
            @Field("password") String password
    );

    /**
     * 上传账户密码
     *
     * @return
     */
    @POST("membercenter/set_store_login_password")
    @FormUrlEncoded
    Observable<StorePwInfoBean> PostStorePwInfo(
            @Field("member_name") String member_name,
            @Field("password") String password
    );

    /**
     * 获得登录名
     *
     * @return
     */
    @GET("Membercenter/get_member_name")
    Observable<StoreLoginNameBean> getStoreLoginName();

    /**
     * 获取支付订单
     *
     * @param num
     * @param type   pay_type	 支付平台	int	1=微信，2=支付宝
     * @param remark
     * @return
     */
    @FormUrlEncoded
    @POST("paycenter/recharge")
    Observable<OrderIdBean> getOrderIdBean(
            @Field("amount") Float num,
            @Field("pay_type") String type,
            @Field("remark") String remark);

    /**
     * 再次验证 是否支付成功
     *
     * @param orderId
     * @return
     */
    @FormUrlEncoded
    @POST("")
    Observable<TellBackBean> getTellBackBean(
            @Field("orderId") String orderId
    );

    /**
     * 热门搜索推荐
     *
     * @return
     */
    @GET("search/hot_search")
    Observable<HotSearchInfoBean> getHotSearchBean();

    /**
     * 获取搜索拍品
     *
     * @param keyword
     * @param page_no
     * @return
     */
    @GET("search/get_search_goods")
    Observable<SearchInfoBean> getSearchAuctionBean(
            @Query("keyword") String keyword,
            @Query("page_no") Integer page_no
    );

    /**
     * 获取详细支付订单信息
     *
     * @param orderid
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("order/get_order")
    Observable<OrderIdDetailBean> getOrderIdDeatil(
            @Field("order_id") String orderid,
            @Field("order_state") String type);

    /**
     * 加入购物车
     *
     * @param goodId
     * @param count
     * @return
     */
    @POST("shop/get_goods_in_cart")
    @FormUrlEncoded
    Observable<AddCartInfoBean> getAddGoodCart(
            @Field("goods_id") Integer goodId,
            @Field("goods_count") Integer count);

    /**
     * @return 获取购物车列表
     */
    @GET("shop/get_cart_list")
    Observable<ShopCartGoodsBean> getShopCartInfo();

    /**
     * 发送验证码
     *
     * @param phone
     * @param type  场景值:1为注册,2为绑定手机,3为找回密码,4为登录
     * @return
     */
    @GET("sms/send_code")
    Observable<SmsInfoBean> getSendSms(
            @Query("phone") String phone,
            @Query("type") String type
    );

    // 第三方信息上传
    @GET("membercenter/login_wx")
    Observable<OtherLoginBean> getOtherLoginBean(
            @Query("openid") String openid,
            @Query("nickname") String nickname,
            @Query("headimgurl") String headimgurl
    );

}