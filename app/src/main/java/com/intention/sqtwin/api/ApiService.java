package com.intention.sqtwin.api;


import com.intention.sqtwin.bean.AccountBean;
import com.intention.sqtwin.bean.AgentBidBean;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.ArtDetailBean;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.bean.AuctionListBean;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.BidBean;
import com.intention.sqtwin.bean.BidRecordBean;
import com.intention.sqtwin.bean.CategoryAllBean;
import com.intention.sqtwin.bean.DerivativesBean;
import com.intention.sqtwin.bean.LoginBean;
import com.intention.sqtwin.bean.MessageBean;
import com.intention.sqtwin.bean.MyCompeteBean;
import com.intention.sqtwin.bean.OrderListBean;
import com.intention.sqtwin.bean.OrganPeBean;
import com.intention.sqtwin.bean.PpAllDateBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
     * 获取订单列表
     *
     * @param status
     * @return
     */
    @GET("membercenter/get_order_list")
    Observable<OrderListBean> getOrderList(

            @Query("status") Integer status);

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

    @GET("membercenter/get_bid_item_list")
    Observable<MyCompeteBean> getMyCompeteBean(Integer page);

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

    @GET("auction/bid")
    Observable<BidBean> getBidDate(
            @Query("goods_id") Integer good_id,
            @Query("price") Integer price,
            @Query("member_id") Integer member_id
    );
    @FormUrlEncoded
    @POST("membercenter/login")
    Observable<LoginBean> getLoginBean(
            @Field("phone") String phone,
            @Field("code") String coer
    );
   /* *//*
    * 首页轮播图
    * *//*
    @GET("Auctionfield/get_home_adv")
    Observable<ShufflingPictureBean> getShufflingPicture(
            @Query("page") String page,
            @Query("position") Integer postion
    );


    @GET("Index/get_recommend_auction_item")
    Observable<RecommendedLots> getRecommendedLots(
            @Query("type") String type
    );

    @GET("index/get_recommend_auction_field")
    Observable<RecommendField> getRecommendield(
            @Query("type") String type
    );*/
//    @GET("get_home_adv")
//    Observable<> getBanner(
//            @Query("page") String page ,
////            @Query()
//    );


    /*
    * 版本号获取
    * *//*
    @POST("site/getVersions")
    Observable<VersionCode> getVersionCode(
    );


    *//*
   * 注册
   * *//*
    @POST("user/register")
    Observable<RegistInfo> regist(
            @Body PostRegistInfo postRegistInfo

    );

    *//*
    * 获取所有的地区
    * *//*
    @POST("user/getAllRegion")
    Observable<AllRegion> getAllRegion(

    );

    *//*
    * 获取注册所需要的学校
    * *//*
    @FormUrlEncoded
    @POST("user/getRegisterSchool")
    Observable<RegisterSchool> getRegisterSchool(
            @Query("id") String SchoolId
    );


    *//*\



    * 获取短信验证码
    * *//*
    @FormUrlEncoded
    @POST("user/sendPhoneCode")
    Observable<SmsLoginInfo> getSmsCode(
            @Field("phone") String phone,
            @Field("param") String param

    );

    *//*
    * 登录
    * *//*
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginInfo> login(
            @Field("phone") String phone,
            @Field("password") String password
    );


    *//*
    * 重置密码
    * *//*
    @FormUrlEncoded
    @POST("user/findPass")
    Observable<ResetPwInfo> ResetPW(
            @Field("phone") String phone,
            @Field("password") String password,
            @Field("param") String param,
            @Field("code") String code


    );

    *//*
    * 点击去商城生成订单号
    * *//*
    //// TODO: 2017/5/25 0025  这里与购物车所用的javabena  所用一个接口

    @POST("pay/CreatOrderListForAction")
    Observable<OrderInfoShopCart> getCreateOrderForAction(

            @Body CreateOrderForAction mCreateOrder
    );

    *//*
    * 个人中心-修改个人信息
    * *//*

    @POST("user/updateUser")
    Observable<UpdateUserInfo> UpdateUser(
            @Body PostUpdateInfo mPostUpdateInfo
          *//*  @Field("household") String household,
            @Field("name") String name,
            @Field("sex") int sex,
            @Field("gid") int gid,
            @Field("province") String provinceId ,
            @Field("city") String CityId ,
            @Field()*//*

    );

    *//*
    * 个人中心-邀请码
    * *//*
    @FormUrlEncoded
    @POST("user/useInvitationCode")
    Observable<ActivityCodeBean> InvitationCode(
            @Field("gid") String gid,
            @Field("code") String code

    );

    *//**
     * @param gid
     * @return 获取修改个人信息的时间
     *//*
    @FormUrlEncoded
    @POST("user/registerNinetyDays")
    Observable<NinetyDays> getNinetDays(
            @Field("gid") String gid
    );

    *//*http://192.168.0.9:1002/user/userIsBuyEvaluation
    * 判断用户是否有权限 做测评@POST("/userIsBuyEvaluation")
    * *//*
    @FormUrlEncoded
    @POST("user/userIsBuyEvaluation")
    Observable<UserIsBuyEvaluation> getUserIsBuyEvaluation(
            @Field("gid") int gid
    );

    *//*
    *//*
    * 判断用户是否购买过推荐
    * *//*
    @FormUrlEncoded
    @POST("recommend/isBuy")
    Observable<UserIsBuyRecommend> getUserIsBuyRecommend(
            @Field("gid") Integer gid,
            @Field("subject") int subject,
            @Field("score") Integer score,
            @Field("h_id") int h_id,
            @Field("i_id") String i_id,
            @Field("year") int year,
            @Field("rank") Integer rank
    );

    *//*
    * 个人中心 修改密码
    * *//*
    @FormUrlEncoded
    @POST("user/resetPassword")
    Observable<ChargeInfo> resetPassword(
            @Field("old_password") String old_password,
            @Field("password") String password,
            @Field("gid") int gid
    );

    *//*
        *//**//*
    * 个人中心-收藏的专业报告
    * *//**//*
    @FormUrlEncoded
    @POST("user/majorReport")
    Observable<CollectMajorReportInfo> CollectMajorReport(
            @Field("gid") int gid,
            @Field("year") int year

    );

    *//*
    * 个人中心-收藏的学校
    * *//*
    @FormUrlEncoded
    @POST("user/schoolDetails")
    Observable<CollectSchoolInfo> schoolDetails(
            @Field("schoolId") String schoolId
    );

    *//*
    * 个人中心-购买记录
    * *//*
    @FormUrlEncoded
    @POST("user/purchaseLog")
    Observable<PurchseRecordInfo> PurchaseRecord(
            @Field("gid") int gid,
            @Field("page") int page
    );

//    *//*
//    * 个人中心-消费记录
//    * *//*
//    @FormUrlEncoded
//    @POST("user/reconsumptionLog")
//    Observable<ConsumeRecordInfo> ReconsumeRecord(
//            @Field("gid") int gid,
//            @Field("page") int page
//
//    );

    *//*
    * 已购买的职业报告
    * *//*
    @FormUrlEncoded
    @POST("user/occupationReportPay")
    Observable<BuyedProfessionalReportInfo> getBuyedProfessionalReport(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("overdue") int overdue

    );

    *//*
    * 已购买的个人专业报告  已购买的公共职业报告
    * *//*
    @FormUrlEncoded
    @POST("user/majorReportPay")
    Observable<BuyedMajorReport> getBuyMajorReport(
            @Field("gid") String gid,
            @Field("type") int type,
            @Field("page") int page,
            @Field("overdue") int overdue
    );

    *//*
    * 个人中心 - 邀请有礼
    * *//*
    @FormUrlEncoded
    @POST("user/rewardLog")
    Observable<InvitePackageInfo> InvitePackage(
            @Field("gid") int gid,
            @Field("page") int page
    );


    @POST("user/invitationUrl")
    Observable<InvitationUrlInfo> invitationUrl();

    *//*
 * 个人中心-获得省市自治区数据
 *//*
    @FormUrlEncoded
    @POST("user/getProvincePy")
    Observable<ProvinceInfo> provincePy(
            @Field("gid") Integer gid
    );

    *//*
    * 个人中心-获得省市自治区数据
    *//*
    @POST("score/GetRegionSubject")
    Observable<ProvinceInfo> getRegionSubject();

    *//*
     * 个人中心--我的成绩
     *//*
    @FormUrlEncoded
    @POST("site/GetScore")
    Observable<MyScoreInfo1> getScore(
            @Field("gid") String gid
    );

    *//*
     * 个人中心--我的成绩保存
     *//*
    @POST("site/SaveScore")
    Observable<ChargeInfo> saveScore(
            @Body SaveScoreBean saveScoreBean
    );

    *//*
     * 个人中心--我的成绩修改次数
     *//*
    @FormUrlEncoded
    @POST("site/CanChangeTimes")
    Observable<CanChangeTimesBean> getChangeTime(
            @Field("gid") String gid,
            @Field("semesterId") Integer semesterId,
            @Field("sort") Integer sort
    );
    *//*个人中心-收藏职业报告*//*

    @FormUrlEncoded
    @POST("user/occupationReport")
    Observable<ProCollectbean> occupationReport(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("overdue") int overdue,
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );

    *//*个人中心-收藏个性专业报告*//*
    @FormUrlEncoded
    @POST("user/majorReport")
    Observable<MajorCollectbean> majorReport(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("overdue") int overdue,
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );

    *//*个人中心-收藏公共专业报告*//*
    @FormUrlEncoded
    @POST("user/majorReportPublic")
    Observable<MajorPublicCollectbean> majorReportPublic(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("overdue") int overdue,
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );

    *//*个人中心-收藏学校*//*
    @FormUrlEncoded
    @POST("user/schoolDetails")
    Observable<CollectSchoolInfo> schoolDetails(
            @Field("gid") int gid,
            @Field("page") int page,
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );

    *//*个人中心-取消收藏*//*
    @FormUrlEncoded
    @POST("user/cancelCollection")
    Observable<ChargeInfo> cancelCollection(
            @Field("gid") String gid,
            @Field("type") String type,//profess 职业报告      major  专业报告     school  学校
            @Field("entryId") String entryId
    );

    *//*
     * 个人中心--- 我的收藏去对比生成记录接口
     *//*
    @FormUrlEncoded
    @POST("user/goToCompareFromCollec")
    Observable<ChargeInfo> goToCompareFromCollec(
            @Field("gid") String gid,
            @Field("type") String type,//profess 职业报告      major  专业报告
            @Field("ids") String ids,//要对比的buyId或tplId，逗号分隔
            @Field("year") String year
    );

    *//*
     * 个人中心-对比个性、公共专业报告记录
     *//*
    @FormUrlEncoded
    @POST("user/contrastMajorReport")
    Observable<ContrastMajorReportInfo> contrastPublicMajorReport(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("type") String type,//当传参type=’public’时，获取公共专业报告对比记录
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );

    *//*
     * 个人中心-对比职业报告记录
     *//*
    @FormUrlEncoded
    @POST("user/contrastCareerReport")
    Observable<ContrastCareerReportInfo> contrastCareerReport(
            @Field("gid") int gid,
            @Field("page") int page,
            @Field("lastEntryId") String lastEntryId,
            @Field("lastUpdateAt") String lastUpdateAt
    );


    *//*
    * 个人中心- 职业对比(头部数据)
     *//*
    @FormUrlEncoded
    @POST("VoReport/ProfessionComparison")
    Observable<ProfesComparisonBean> professioncomparison(
            @Field("gid") int gid,
            @Field("year") int year,
            @Field("tplId") String tplId
    );


    *//*
    * 院校大全Filter
    * *//*
    @FormUrlEncoded
    @POST("list/schoolList")
    Observable<CollegesFiltrateInfo> getCollegeFilter(
            @Header("Cache-Control") String cacheControl,
            @Field("gid") Integer gid
    );

    *//*
    * 院校大全Filter
    * *//*
    @FormUrlEncoded
    @POST("list/schoolList")
    Observable<SchoolFilterInfo> getSchoolFilter(
            @Header("Cache-Control") String cacheControl,
            @Field("gid") Integer gid
    );

    *//*
    * 院校大全的学校列表
    * *//*
    @FormUrlEncoded
    @POST("list/ajaxSchool")
    Observable<CollegesAllInfo> getCollegeAll(
            @Header("Cache-Control") String cacheControl,
            @Query("area") int area,
            @Query("schoolType") int schoolType,
            @Query("degree") int degree,
            @Query("fame") int fame,
            @Query("pagesize") int pageCount,
            @Query("page") int page,
            @Field("gid") Integer gid
    );

    @FormUrlEncoded
    @POST("list/ajaxSchool")
    Observable<ResponseBody> getCollegeAllObject(
            @Header("Cache-Control") String cacheControl,
            @Query("area") int area,
            @Query("schoolType") int schoolType,
            @Query("degree") int degree,
            @Query("fame") int fame,
            @Query("pagesize") int pageCount,
            @Query("page") int page,
            @Field("gid") Integer gid
    );

    *//*
    * 搜索 学校
    * *//*
    @FormUrlEncoded
    @POST("list/search")
    Observable<SearchSchoolInfo> SearchSchool(
            @Field("searchType") String searchtype,
            @Field("searchContent") String SearchContent,
            @Query("page") int page,
            @Field("pagesize") int pagesize,
            @Field("gid") Integer gid
    );

    *//*
    * 搜索 专业   最后一个字段为区分   本科和专科
    * *//*
    @FormUrlEncoded
    @POST("list/search")
    Observable<SearchMajorInfo> Searchmajor(
            @Field("searchType") String searchtype,
            @Field("searchContent") String SearchContent,
            @Query("page") int page,
            @Field("pagesize") int pagesize,
            @Field("gid") Integer gid,
            @Field("majorType") Integer majorType
    );

    *//*
     * 搜索联想    最后一个字段为区分   本科和专科
     *//*
    @FormUrlEncoded
    @POST("list/searchName")
    Observable<AssociateInfo> associate(
            @Field("searchType") String searchType,
            @Field("searchContent") String searchContent,
            @Field("majorType") Integer majorType
    );

    *//*
    *   查看其他学校相同专业的filter
     *//*
    @FormUrlEncoded
    @POST("list/getArea")
    Observable<CheckOtherFilterBean> getAreaFilter(
            @Field("gid") String gid,
            @Field("majorId") String majorId,
            @Field("type") String type,  // public 或者  base
            @Field("schoolId") String schoolId

    );

    *//*
    *   查看其他学校相同专业----由个性报告点进来的
    *//*
    @FormUrlEncoded
    @POST("list/getSameSchoolPublic")
    Observable<SameSchoolPublicBean> getSameSchoolPublic(
            @Field("gid") String gid,
            @Field("schoolId") String schoolId,
            @Field("majorIdPublic") String majorIdPublic,  //
            @Field("type") String type,
            @Field("region") String region,
            @Field("degree") String degree,
            @Field("searchName") String searchName,
            @Field("page") int page,
            @Field("pagesize") int pagesize

    );

    *//*
    *   查看其他学校相同专业----由公共报告点进来的
    *//*
    @FormUrlEncoded
    @POST("list/getSameSchoolBase")
    Observable<SameSchoolPublicBean> getSameSchoolBase(
            @Field("gid") String gid,
            @Field("majorIdBase") String majorIdBase,  //
            @Field("type") String type,
            @Field("region") String region,
            @Field("degree") String degree,
            @Field("searchName") String searchName,
            @Field("page") int page,
            @Field("pagesize") int pagesize

    );

    *//*
    *
     *//*
    @FormUrlEncoded
    @POST("list/getThreeData")
    Observable<ThreeAndThreeBean> getThree(
            @Field("schoolId") String schoolId
    );

    *//*
    * 详情页的对比记录
     *//*
    @FormUrlEncoded
    @POST("user/compareList")
    Observable<ThreeDataBean> getThreeData(
            @Field("gid") String gid,
            @Field("type") String type // profess 职业报告对比记录   major  专业报告对比记录
    );

    *//*
    * 详情页的去对比
     *//*
    @FormUrlEncoded
    @POST("user/goToCompare")
    Observable<GoToCompareBean> goToCompare(
            @Field("gid") String gid,
            @Field("type") String type,// profess 职业报告对比记录   major  专业报告对比记录
            @Field("contrastId") String contrastId

    );

    *//*
    * 详情页的加入或删除对比
     *//*
    @FormUrlEncoded
    @POST("user/addAndDelCompare")
    Observable<AddAndDelBean> addAndDelCompare(
            @Field("gid") String gid,
            @Field("type") String type,// profess 职业报告对比记录   major  专业报告对比记录
            @Field("contrastId") String contrastId,
            @Field("id") String id,//要新增或删除的tplId或buyId
            @Field("operation") String operation,//add 加入，del 删除  newOne 新增
            @Field("year") String year

    );

    *//*
    * 我的对比-----删除整条对比记录
     *//*
    @FormUrlEncoded
    @POST("user/delCompareList")
    Observable<ChargeInfo> delCompareList(
            @Field("gid") String gid,
            @Field("type") String type,// profess 职业报告对比记录   major  专业报告对比记录
            @Field("contrastId") String contrastId
    );


    *//*
    * 学校详情
    * *//*
    @FormUrlEncoded
    @POST("list/schoolDetails")
    Observable<SchIntroduceInfo> getSchoolDetailIntro(
            @Header("Cache-Control") String cacheControl,
            @Field("schoolId") String schoolId,
            @Field("gid") Integer gid,
            @Field("version") Boolean version

    );

    *//*
    * 科研教学
    * *//*
    @FormUrlEncoded
    @POST("list/SchoolEdu")
    Observable<ResearchBean> getResearchInfo(
            @Field("gid") Integer gid,
            @Field("schoolId") String schoolId
    );

    *//*
    * 招生章程
    * *//*
    @FormUrlEncoded
    @POST("list/SchoolBrochure")
    Observable<SchoolBrochureBean> getSchoolBrochure(
            @Field("gid") Integer gid,
            @Field("schoolId") String schoolId
    );

    *//*
    * 学校详情 学校专业
    * *//*
    @FormUrlEncoded
    @POST("list/schoolMajor")
    Observable<schoolMajorInfo> getSchoolMajorInfo(
            @Header("Cache-Control") String cacheControl,
            @Field("schoolId") String schoolId,
            @Field("gid") Integer gid
    );

    *//*
    * 学校分数线
    * *//*
    @FormUrlEncoded
    @POST("list/ajaxSchoolScore")
    Observable<SchoolScore> getSchOOlScore(
            @Header("Cache-Control") String cacheControl,
            @Field("schoolId") int SchoolId,
            @Field("subject") int subject,
            @Field("batch") int batch,
            @Field("recruitArea") int MajorScore
    );

    *//*
     *招生计划
     *//*
    @FormUrlEncoded
    @POST("list/RecruitPlan")
    Observable<RecruitPlan> getRecruitPlan(
            @Field("schoolId") int schoolId,
            @Field("subject") int subject,
            @Field("batch") int batch,
            @Field("recruitArea") String areaName
    );

    *//*
    *学校 录取专业分数线
    *//*
    @FormUrlEncoded
    @POST("list/ajaxMajorScore")
    Observable<MajorScore> getMajorScore(
            @Field("schoolId") int SchoolId,
            @Field("subject") int subject,
            @Field("year") int batch,
            @Field("recruitArea") String MajorScore
    );


    *//*
    *
     *//*
    @FormUrlEncoded
    @POST("recommend/getMajorList")
    Observable<MajorListBean> majorList(
            @Header("Cache-Control") String cacheControl,
            @Field("gid") Integer gid
    );

    *//*
    *收藏专业\学校
     *//*
    @POST("voReport/CollectMajor")
    Observable<ChargeInfo> majorCollect(
            @Body MajorCollectInfo majorCollectInfo
    );

    *//*
    * 专业大全
    * *//*
    @FormUrlEncoded
    @POST("list/majorlist")
    Observable<MajorAllInfo> getMajorALLInfo(
            @Header("Cache-Control") String cacheControl,
            @Field("gid") Integer gid,
            @Field("majorType") Integer majorType

    );

    *//*
    *收藏职业
     *//*
    @FormUrlEncoded
    @POST("recommend/collectTpl")
    Observable<ChargeInfo> proCollect(
            @Field("gid") int gid,//	Y	int	用户gid
            @Field("year") int year,//	Y	int	年份(进入职业报告页面的url上参数 year 的值)
            @Field("tpl_id") int tpl_id,//	Y	int	 职能id
            @Field("collect_type") int collect_type//	Y	必填项， 1：收藏  2：取消收藏
    );

    *//*
    * 职业报告数据(职业详情、相关职业)
     *//*
    @FormUrlEncoded
    @POST("VoReport/ProfessionReport")
    Observable<ProReportBean> proReport(
            @Field("gid") int gid,
            @Field("year") int year,
            @Field("tplId") int tplId
    );


    *//*
    * 职业报告(调值参数的分布数据)
     *//*
    @FormUrlEncoded
    @POST("report/DataForTplMajorDistribution")
    Observable<ProReportTplBean> tplOnlyDis(
            @Field("tplId") int tplId,
            @Field("year") int year,
            @Field("type") int type,
            @Field("degree") int degree,
            @Field("schoolId") int schoolId,
            @Field("city") String city,
            @Field("industry") String industry
    );

    *//*
    * 职业报告(调值参数的成长周期数据)
     *//*
    @FormUrlEncoded
    @POST("report/DataForTplGrowthCycle")
//TplGrowthCycleInfo
    Observable<ProReportTplBean> tplOnlyGrowth(
            @Field("tplId") int tplId,
            @Field("year") int year,
            @Field("type") int type,
            @Field("degree") int degree,
            @Field("schoolId") int schoolId,
            @Field("city") String city,
            @Field("industry") String industry
    );

    *//*
    * 职业报告(调值参数的平均薪资数据)
     *//*
    @FormUrlEncoded
    @POST("report/DataForTplAverageSalary")
//TplAverageSalaryInfo
    Observable<ProReportTplBean> tplOnlySalary(
            @Field("tplId") int tplId,
            @Field("year") int year,
            @Field("type") int type,
            @Field("degree") int degree,
            @Field("schoolId") int schoolId,
            @Field("city") String city,
            @Field("industry") String industry
    );

    *//*
   * 职业报告(调值参数的转行率数据)
    *//*
    @FormUrlEncoded
    @POST("report/DataForTplCareerChange")
//TplMajorCareerChangeInfo
    Observable<ProReportTplBean> tplOnlyChange(
            @Field("tplId") int tplId,
            @Field("year") int year,
            @Field("type") int type,
            @Field("degree") int degree,
            @Field("schoolId") int schoolId,
            @Field("city") String city,
            @Field("industry") String industry
    );
        *//*
        * 个人专业扣费
         *//*

    *//*
    * 学校 收藏
    * *//*
    @FormUrlEncoded
    @POST("recommend/collectSchool")
    Observable<StatusInfo> GoCollectSchool(
            @Field("gid") Integer gid,
            @Field("school_id") int schoolId,
            @Field("collect_type") int collect_type //collect_type  必填项， 1：收藏  2：取消收藏
    );

    *//*
    * 个人和学校的专业扣费
     *//*
    @POST("RecommendApi/majorCharge")
    Observable<ChargeReturnIdInfo> majorCharge(
            @Body MajorChargeInfo majorChargeInfo
    );

    *//*
    * 职业报告扣费
     *//*
    @FormUrlEncoded
    @POST("RecommendApi/tplCharge")
    Observable<ChargeInfo> proCharge(
            @Field("gid") int gid,    //Y	int	用户gid
            @Field("year") int year,    //Y	int	年份(进入个性专业报告页面的url上参数 year 的值)
            @Field("tpl_id") int tpl_id   //Y	int	职能id
    );

    *//*
     * 调值参数的行业
     *//*
    @POST("VoReport/GetIndustry")
    Observable<IndustryBean> industry(

    );

    *//*
    * 调值参数的学校
     *//*
    @FormUrlEncoded
    @POST("VoReport/getAreaAndSchool")
    Observable<SchoolBean> schoolAll(
            @Field("schoolType") int schoolType,// 0 全部  1 985/211 2 其他
            @Field("schoolDegree") int schoolDegree  // 0 全部 1 本科 2 专科
    );

    *//*
    * 公共专业报告扣费
     *//*
    @FormUrlEncoded
    @POST("RecommendApi/publicCharge")
    Observable<ChargeReturnIdInfo> majorPublicCharge(
            @Field("gid") Integer gid,    //Y	int	用户gid
            @Field("year") int year,    //Y	int	年份(进入公共专业报告页面的url上参数 year 的值)
            @Field("major_id") int major_id    //Y	int	专业id
    );

    *//*
    * 公共专业报告收藏
     *//*
    @FormUrlEncoded
    @POST("recommend/collectMajorPublic")
    Observable<ChargeInfo> collectMajorPublic(
            @Field("gid") String gid,    //Y	int	用户gid
            @Field("year") int year,    //Y	int	年份(进入公共专业报告页面的url上参数 year 的值)
            @Field("major_id_base") int major_idBase,    //Y	int	专业id
            @Field("collect_type") int collect_type // 1 收藏 2 取消收藏
    );

    *//*
    *公共专业报告-数据(介绍、相关的)
     *//*
    @FormUrlEncoded
    @POST("VoReport/PublicMajorReport")
    Observable<PubMajReportBean> pubMajReport(
            @Field("gid") Integer gid,
            @Field("year") int year,
            @Field("majorIdBase") int majorId,
            @Field("type") String type  //公共专业报告的职业分布，点击跳转另一个公共专业报告的时候，type固定为1

    );

    *//*
    * 公共专业报告- 图表数据
     *//*
    @POST("report/MajorData")
    Observable<PubMajReportBeanTb> pubMajReportTb(
            @Body PubMajReportTbInfo pubMajReportTbInfo
    );


    //    Observable<ResponseBody>


    *//*
    * 已购买推荐条件
     *//*
    @FormUrlEncoded
    @POST("recommend/getFilter")
    Observable<PurchasedBean> purchasedCon(
            @Field("gid") int gid,
            @Field("year") String year
    );

    *//*
    * 获取历年批次线
     *//*

    @POST("list/CityScoreLine")
    Observable<ScoreLineInfo> cityScoreLine(
            @Body BatchInfoUpdate mbatchInfoUpdate
    );

    *//*
    * 获取商城列表
     *//*
    @FormUrlEncoded
    @POST("shop/getGoods")
    Observable<ShopMallInfo> getGoods(

            @Field("gid") int gid
    );

    *//*
    * 增加购物车的数据
    * *//*
    @FormUrlEncoded
    @POST("shop/AddShopCart")
    Observable<AddshopGoods> AddGoods(
            @Field("gid") int gid,
            @Field("goodsId") int goodsId,
            @Field("num") int num
    );

    *//*
    *
    * *//*
   *//* @FormUrlEncoded
    @POST("Accounts/{accountId}")
    Observable<PayInfo> updateExtras(
            @Path("accountId") String accountId,
            @Query("access_token") String access_token,
            @Body TellBackGrounInfo bean);*//*
    *//*
    * 购物车生成订单
    * *//*
    @POST("pay/CreatOrderListForShopCart")
    Observable<OrderInfoShopCart> getShopOrder(
            @Body OrderInfo mOrderInfo
    );

    *//*
    *   确认订单页的 生成订单号
    * *//*
    @FormUrlEncoded
    @POST("pay/CreatOrderList")
    Observable<OrderInfoShopCart> getShopOrderBuy(
            @Field("gid") int gid,
            @Field("goodsId") int goodsId,
            @Field("num") int Num
    );

    *//*
    *   确认订单页的 生成订单号
    * *//*
    @POST("pay/CreatOrderListMany")
    Observable<OrderInfoShopCart> getShopOrderBuyMany(
            @Body ShopOrderBuyMany shopOrderBuyMany
    );

    *//*支付*//*
    @POST("pay/SubmitOrder")
    @FormUrlEncoded
    Observable<PayInfo> Pay(
            @Field("gid") int gid,
            @Field("orderId") String orderid,
            @Field("useBonus") Boolean useBonus,
            @Field("type") String PayType,
            @Field("useCode") Boolean useCode
    );

    //TODO 第一次进入当前进去
    *//*
    * 确认订单页获取所有商品详情
    * *//*
    @POST("shop/GetOrder")
    @FormUrlEncoded
    Observable<ConfirmOrderInfo> getconfirmOrderInfo(
            @Field("gid") int gid,
            @Field("orderId") String orderId
    );

    @POST("pay/GetOrderStatus")
    @FormUrlEncoded
    Observable<TellBackGrounInfo> Tellbackground(
            @Field("gid") int gid,
            @Field("orderId") String orderId,
            @Field("type") String type

    );

*//*    @Multipart
    @POST
    Observable<PayInfo> zhe(
            @Part MultipartBody.Part Mu
    );*//*


    *//*
    * 短信登陆
    * *//*
    @FormUrlEncoded
    @POST
    Observable<SmsLoginInfo> SmsLogin(
            @Field("phone_number") String phone
    );

    *//*
    * 第一次进来获取得到购物车的信息
    * *//*
    @POST("shop/getShopCart")
    @FormUrlEncoded
    Observable<ShopCartInfo> getShopCart(
            @Field("gid") int gid
    );

    @POST("")
    @FormUrlEncoded
    Observable<ActionKey> getActionKey(
            @Field("gid") Integer gid,
            @Field("actionKey") String actionKey

    );

    *//*
    * 操作数据库之后对数据的数据变化
    * *//*
    @POST("shop/ChangeShopCart")
    Observable<ShopCartInfo> getShopCartOptertion(
            @Body LocaShopCartBean mLocaShopBean
    );

    // 分数走势图
    @FormUrlEncoded
    @POST("site/ScoreChart")
    Observable<ScoreChartTrend> getScoreChartTrend(
            @Field("gid") Integer gid
    );

    //个人中心-我的推荐
    @FormUrlEncoded
    @POST("user/RecommendLog")
    Observable<MyRecommendLogInfo> getmyRecommendLog(
            @Field("gid") Integer gid,
            @Field("page") Integer page
    );

    @Multipart
    @POST("user/uploadErrorFile")
    Observable<ResponseBody> updateFile(
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file
    );


    *//*
    *
    * 加密的接口
    * *//*
    *//*
    *公共专业报告- 图表数据(调值参数返回就业地区分布)
     *//*
    // TODO: 2017/9/7 0007 加密 ForMajorEmployInfo
    @FormUrlEncoded
    @POST("VoReport/DataForCityRanking")
    Observable<ResponseBody> majorOnlyEmploy(
            @Field("majorIdBase") String majorIdBase,
            @Field("year") String year,
            @Field("degree") String degree
    );

    *//*
*个人中心- 专业对比
 *//*
    // TODO: 2017/9/7 0007 加密  MajorComparisonBean
    @FormUrlEncoded
    @POST("VoReport/MajorComparison")
    Observable<ResponseBody> majorcomparison(
            @Field("gid") int gid,
            @Field("year") int year,
            @Field("id") String id
    );

    *//*
     * 公共对比报告页
     *//*
    @FormUrlEncoded
    @POST("VoReport/MajorPublicComparison")
    Observable<ResponseBody> majorPublicComparison(
            @Field("gid") String gid,
            @Field("id") String id,
            @Field("year") String year
    );

    *//*
 * 个人中心- 职业对比(图表数据)
  *//*
    // TODO: 2017/9/7 0007 加密 ProfessionComparisonBean
    @POST("VoReport/ProfessionComparisonData")
    Observable<ResponseBody> professioncomparison(
            @Body ProfessionComparisonInfo professionComparisonInfo
    );

    *//*
  * 搜索-推荐的学校和专业
  *//*
    // TODO: 2017/9/7 0007  加密
    @POST("recommend/search")
    Observable<ResponseBody> recommend(

            @Body ConditionInfo conditionInfo
    );

    *//*
 * 搜索推荐-扣费查看
  *//*
    // TODO: 2017/9/7 0007  加密
    @POST("recommend/recCharge")
    Observable<ResponseBody> recCharge(
            @Body RecChargeInfo recChargeInfo
    );

    *//*
  * 个性的专业报告页(推荐的)
   *//*
    // TODO: 2017/9/7 0007 加密   MajorReportBean
    @POST("VoReport/VoRecMajorReport")
    Observable<ResponseBody> majorReport(
            @Body MajorReportInfo majorReportInfo
    );

    *//*
  * 专业报告页(学校)
   *//*
    // TODO: 2017/9/7 0007 加密  MajorReportSchBean
    @POST("VoReport/MajorReport")
    Observable<ResponseBody> majorReportSch(
            @Body MajorReportSchInfo majorReportSchInfo
    );

    *//*
 * 职业报告数据(图表数据) 加密 ProReportTplBean
  *//*
    // TODO: 2017/9/7 0007  加密
    @FormUrlEncoded
    @POST("VoReport/TplData")
    Observable<ResponseBody> proReportTplData(
            @Field("tplId") int tplId,
            @Field("year") int year,
            @Field("type") int type,
            @Field("degree") int degree,
            @Field("schoolId") int schoolId,
            @Field("city") String city,
            @Field("industry") String industry
    );

    *//*
     *公共专业报告- 图表数据(调值参数返回对口率)
     *//*
    // TODO: 2017/9/7 0007 加密 DataForMajorProfessionalCounterparts
    @POST("VoReport/DataForMajorProfessionalCounterparts")
    Observable<ResponseBody> majorOnlycounter(
            @Body PubMajReportTbInfo pubMajReportTbInfo
    );

    *//*
     *公共专业报告- 图表数据(调值参数返回职业分布)
     *//*
    // TODO: 2017/9/7 0007 加密  ForMajorPositionDisInfo
    @POST("VoReport/DataForMajorPositionDistribution")
    Observable<ResponseBody> majorOnlyDis(
            @Body PubMajReportTbInfo pubMajReportTbInfo
    );

    *//*
  *公共专业报告- 图表数据(调值参数返回平均薪资)
   *//*
    // TODO: 2017/9/7 0007 加密 ForMajorAverageSalaryInfo
    @POST("VoReport/DataForMajorAverageSalary")
    Observable<ResponseBody> majorOnlySalary(
            @Body PubMajReportTbInfo pubMajReportTbInfo
    );

    *//*
   *公共专业报告- 图表数据(调值参数返回企业性质---饼状图)
    *//*
    // TODO: 2017/9/7 0007 加密   ForMajorPercentInfo
    @FormUrlEncoded
    @POST("VoReport/DataForMajorPercent")
    Observable<ResponseBody> majorOnlyEnterprse(
            @Field("majorIdBase") String majorIdBase,
            @Field("year") String year,
            @Field("degree") String degree
    );

    @FormUrlEncoded
    @POST("VoReport/DataForIndustryData")
    Observable<ResponseBody> majorOnlyIndustry(
            @Field("majorIdBase") String majorIdBase,
            @Field("year") String year,
            @Field("degree") String degree
    );

    *//*已支付订单*//*
    @FormUrlEncoded
    @POST("user/GetUserOrderList")
    Observable<OrderPaidBean> orderpaid(
            @Field("gid") String gid,
            @Field("page") int page
    );

    *//*已支付订单*//*
    @FormUrlEncoded
    @POST("user/GetUserOrderListNoPay")
    Observable<OrderUnpaidBean> orderunpaid(
            @Field("gid") String gid,
            @Field("page") int page
    );

    *//*删除未完成订单*//*
    @FormUrlEncoded
    @POST("pay/DeleteOrder")
    Observable<DeleteOrderBean> deleteOrder(
            @Field("gid") String gid,
            @Field("orderId") String orderId
    );

    *//*商品余量*//*
    @FormUrlEncoded
    @POST("user/PackageSurplus")
    Observable<SurplusBean> surplus(
            @Field("gid") String gid
    );

    *//*消费记录*//*
    @FormUrlEncoded
    @POST("user/reconsumptionLog")
    Observable<ConsumedBean> consumed(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("pagesize") int pagesize

    );

    *//*院校分数线获取数据*//*
    @FormUrlEncoded
    @POST("score/GetSchoolScoreData")
    Observable<ScoreResultData> getSchoolScoreData(

            @Field("provinceId") String provinceId,
            @Field("schoolArea") String schoolArea,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("batch") String batch,
            @Field("schoolName") String schoolName,
            @Field("page") int page,
            @Field("pageSize") int pageSize,
            @Field("type") String type

    );

    *//*专业分数线获取数据*//*
    @FormUrlEncoded
    @POST("score/GetMajorScoreData2")
    Observable<ScoreResultData> getMajorScoreData(
            @Field("gid") String gid,
            @Field("schoolArea") String schoolArea,
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("batch") String batch,
            @Field("majorName") String majorName,
            @Field("schoolName") String schoolName,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*地区分数线获取数据*//*
    @FormUrlEncoded
    @POST("score/GetRegionScoreData")
    Observable<RegionScoreData> getRegionScoreData(
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("batch") String batch,// batch  固定为0，版本兼容
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*地区分数线获取数据*//*
    @FormUrlEncoded
    @POST("score/GetRegionScoreData2")
    Observable<RegionScoreData2> getRegionScoreData2(
            @Field("provinceId") String provinceId,
            @Field("subject") String subject,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*一分一位分数线获取名称列表*//*
    @FormUrlEncoded
    @POST("score/GetScoreListData")
    Observable<ScoreListData> getScoreListData(
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject
    );

    *//*一分一位分数线获取名称列表*//*
    @FormUrlEncoded
    @POST("score/GetScoreRankData")
    Observable<ScoreRankData> getScoreRankData(
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*一分一位分数线获取名称列表*//*
    @FormUrlEncoded
    @POST("score/IsShow")
    Observable<ChargeInfo> isShow(
            @Field("gid") String gid
    );

    *//*一分一位分数线获取名称列表*//*
    @FormUrlEncoded
    @POST("score/GetProvinceInfo2")
    Observable<GetProvinceInfo> getProvinceInfo(
            @Field("type") String type
    );

    *//*志愿填报第一步---加载测评专业*//*
    @FormUrlEncoded
    @POST("list/VolunteerTalent")
    Observable<VolunteerTalentInfo> getVolunteerTalent(
            @Field("gid") String gid
    );

    *//*志愿填报第一步---加载已选的感兴趣专业*//*
    @FormUrlEncoded
    @POST("list/VolunteerInterest")
    Observable<VolunteerInterestInfo> getVolunteerInterest(
            @Field("gid") String gid,
            @Field("majorstamp") String majorstamp
    );

    *//*志愿填报第一步---搜索专业*//*
    @FormUrlEncoded
    @POST("list/VolunteerSearchMajor")
    Observable<VolunteerSearchMajorInfo> getVolunteerSearchMajor(
            @Field("gid") String gid,
            @Field("content") String content
    );

    *//*志愿填报第一步---所有专业*//*
    @FormUrlEncoded
    @POST("list/VolunteerAllMajor")
    Observable<VolunteerAllMajorInfo> getVolunteerAllMajor(
            @Field("gid") String gid
    );

    *//*志愿填报第一步---下一步*//*
    @POST("list/SaveInterestMajor")
    Observable<SaveInterestMajorInfo> getSaveInterestMajor(
            @Body SaveInterestMajorBean saveInterestMajorBean
    );

    *//*志愿填报第二步---是否要扣费*//*  *//*VoApiRecommend改为大写*//*
    @POST("RecommendApi/JudgeFee")
    Observable<JudgeFeeInfo> JudgeFee(
            @Body JudgeFeeBean judgeFeeBean
    );

    *//*志愿填报第二步---扣费*//*
    @POST("RecommendApi/FeeDeduction")
    Observable<JudgeFeeInfo> FeeDeduction(
            @Body JudgeFeeBean judgeFeeBean
    );

    *//*志愿填报第二步---第二步回到第一步*//*
    @POST("RecommendApi/FilterSaveParam")
    Observable<JudgeFeeInfo> FilterSaveParam(
            @Body JudgeFeeBean judgeFeeBean
    );

    *//*个人中心--我的志愿*//*
    @FormUrlEncoded
    @POST("site/voluntFilter")
    Observable<MyVoluntInfo> MyVoluntFilter(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*个人中心--我的志愿*//*
    @FormUrlEncoded
    @POST("site/DeleteVolunteer")
    Observable<ChargeInfo> DeleteVolunteer(
            @Field("gid") String gid,
            @Field("vid") String vid
    );

    *//*个人中心--我的志愿修改名称*//*
    @FormUrlEncoded
    @POST("site/UpdateName")
    Observable<ChargeInfo> UpdateName(
            @Field("gid") String gid,
            @Field("vid") String vid,
            @Field("name") String name
    );

    *//*个人中心--我的志愿筛选条件详情*//*
    @FormUrlEncoded
    @POST("site/getNum")
    Observable<GetNumInfo> getNum(
            @Field("gid") String gid,
            @Field("vid") String vid,
            @Field("fid") String fid
    );

    *//*院校详情--院校分数线*//*
    @FormUrlEncoded
    @POST("list/GetSchoolScoreData")
    Observable<ScoreResultData> SchoolScoreData(
            @Field("gid") String gid,
            @Field("schoolId") String schoolId,
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("batch") String batch,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*院校详情--专业分数线*//*
    @FormUrlEncoded
    @POST("list/GetMajorScoreData")
    Observable<ScoreResultData> MajorScoreDataLink(
            @Field("gid") String gid,
            @Field("schoolId") String schoolId,
            @Field("provinceId") String provinceId,
            @Field("year") String year,
            @Field("subject") String subject,
            @Field("batch") String batch,
            @Field("majorName") String majorName,
            @Field("page") int page,
            @Field("pageSize") int pageSize
    );

    *//*有风险等级的个性报告页*//*
    @POST("report/VoRecMajorReport")
    Observable<ResponseBody> VoRecMajorReport(
            @Body MajorReportInfo majorReportInfo
    );

    *//*我的志愿---志愿详情*//*
    @FormUrlEncoded
    @POST("site/VolunteerDetail")
    Observable<VolunteerDetailBean> VolunteerDetail(
            @Field("gid") String gid,
            @Field("vid") String vid
    );

    *//*我的志愿---更新、另存为*//*
    @POST("RecommendApi/SaveVolunteerByVid")
    Observable<SaveAsVolBean> SaveAsVol(
            @Body UpAspirationBean upAspirationBean
    );

    // 填报志愿第三步
   *//* @POST("Vorecommend/search")
    Observable<ResponseBody> getIntentionSearch(
            @Body UpdateFiltrateBean mUpdateFiltrateBean
    );*//*
    @POST("RecommendApi/search")
    Observable<ResponseBody> getIntentionSearch(
            @Body UpdateFiltrateBean mUpdateFiltrateBean
    );

    *//*
    * 志愿列表--获取备注
    * *//*
    @FormUrlEncoded
    @POST("RecommendApi/GetCommentByFid")
    Observable<NoteInfoBean> getNoteInfo(
            @Field("gid") Integer gid,
            @Field("fid") Integer fid

    );

    *//*
    * 修改备注
    * *//*
    @FormUrlEncoded
    @POST("RecommendApi/ChangeComment")
    Observable<UpdateNoteInfo> getUpdateNoteInfo(
            @Field("gid") Integer gid,
            @Field("fid") Integer fid,
            @Field("comment") String comment
    );


    // 获取学校下面的专业列表
    *//*@POST("Vorecommend/GetVoMajorData")
    Observable<ResponseBody> getIntentionMajorList(
            @Body UpdateMajorListbean mUpdateMajorListBean
    );*//*
    @POST("RecommendApi/GetVoMajorData")
    Observable<ResponseBody> getIntentionMajorList(
            @Body UpdateMajorListbean mUpdateMajorListBean
    );

    // 获取筛选条件
    @FormUrlEncoded
    @POST("RecommendApi/GetVoFilter")
    Observable<IntentionFragmentBean> getFilterList(
            @Field("gid") Integer gid,
            @Field("year") Integer year,
            @Field("filter_id") Integer filterId
    );

    *//*
    *  @FormUrlEncoded
    @POST("Vorecommend/GetVoFilter")
    Observable<IntentionFragmentBean> getFilterList(
            @Field("gid") Integer gid,
            @Field("year") Integer year,
            @Field("filter_id") Integer filterId
    );*//*
    // 新版获取筛选条件


    // 加载志愿单标红状态
    @FormUrlEncoded
    @POST("RecommendApi/GetRedData")
    Observable<IntentionRedList> getIntentionRedList(
            @Field("gid") Integer gid,
            @Field("filter_id") Integer filter_id,
            @Field("batch") Integer batch
    );

    // 志愿单详细数据
    @POST("RecommendApi/LoadVolunteer")
    Observable<IntentionRedList> LoadVolunteer(
            @Body LoadVolunteerBean loadVolunteerBean
    );

    // 志愿单列表
    @FormUrlEncoded
    @POST("RecommendApi/GetVolunteerList")
    Observable<VolunteerListBean> GetVolunteerList(
            @Field("gid") String gid
    );

    // 下一步的保存按钮
    @POST("RecommendApi/SaveVolunteerByFid")
    Observable<ResponseStatusMaMing> updateMamingDate(
            @Body UpdateMyIntentionListMaMing mUpdateMaMing
    );

    // 高洁净保存上一步的操作
    @POST("RecommendApi/SaveParam")
    Observable<ResponseStatusGAOJIEJING> updateGaojiejing(
            @Body UpdateMyIntentionListGaoJieJing mUppdategaojiejing
    );

    // 第四步保存按钮
    @POST("RecommendApi/SaveVolunteerByFid")
    Observable<ResponseStatusMaMing> saveDateByFid(
            @Body UpAspirationBean upAspirationBean
    );

    // 专业诊断第一步---获取感兴趣专业列表
    @FormUrlEncoded
    @POST("MajorDiagnost/getINTRSEDMajorList")
    Observable<InterestMajorData> getIntrsedMajorList(
            @Field("gid") String gid
    );

    //专业诊断第一步---提交感兴趣的专业
    @FormUrlEncoded
    @POST("MajorDiagnost/submitIntrsedMajorList")
    Observable<BasicBean> submitIntrsedMajorList(
            @Field("gid") String gid,
            @Field("majorId") String majorId
    );

    //专业诊断第二步---获取感兴趣专业详情(公共专业)
    @FormUrlEncoded
    @POST("MajorDiagnost/getIntrsedMajorListDetails")
    Observable<MajorListDetailsData> getIntrsedMajorListDetails(
            @Field("gid") String gid,
            @Field("proCpsOrder") Integer proCpsOrder,
            @Field("avgSalaryOrder") Integer avgSalaryOrder,
            @Field("order") Integer order
    );

    //专业诊断第二步---报告扣费(公共专业)
    @FormUrlEncoded
    @POST("MajorDiagnost/publicMajorCharge")
    Observable<PublicMajorChargeData> publicMajorCharge(
            @Field("gid") String gid,
            @Field("majorId") String majorId,
            @Field("degree") String degree
    );

    // 专业诊断第二步---获取优选专业(公共专业)
    @FormUrlEncoded
    @POST("MajorDiagnost/getOptimizationMajorList")
    Observable<OptimizationMajorData> getOptimizationMajorList(
            @Field("gid") String gid
    );

    // 专业诊断第二步---删除/增加优选专业(公共专业)
    @FormUrlEncoded
    @POST("MajorDiagnost/ADOptimizationMajor")
    Observable<BasicBean> ADOptimizationMajor(
            @Field("gid") String gid,
            @Field("majorId") String majorId,
            @Field("type") String type
    );

    // 专业诊断第三步---获取专业诊断filter信息
    @FormUrlEncoded
    @POST("MajorDiagnost/getMDFilterInfo")
    Observable<MDFilterInfo> getMDFilterInfo(
            @Field("gid") String gid
    );

    // 专业诊断第三步---根据filter信息获取优选专业下符合的(个性)专业信息
    @POST("MajorDiagnost/getMajorDetails")
    Observable<MajorDetailsInfo> getMajorDetails(
            @Body MajorDetailsBean majorDetailsBean
    );

    // 专业诊断第三步---获取目标专业
    @FormUrlEncoded
    @POST("MajorDiagnost/getObjectMajor")
    Observable<ObjectMajorInfo> getObjectMajor(
            @Field("gid") String gid
    );

    // 专业诊断第三步---删除/增加目标专业
    @FormUrlEncoded
    @POST("MajorDiagnost/ADObjectMajorList")
    Observable<BasicBean> ADObjectMajorList(
            @Field("gid") String gid,
            @Field("majorIdBase") String majorIdBase,
            @Field("majorIdPublic") String majorIdPublic,
            @Field("schoolId") String schoolId,
            @Field("subjectType") String subjectType,
            @Field("subjectIds") String subjectIds,
            @Field("type") String type
    );

    // 个人中心---我的目标
    @FormUrlEncoded
    @POST("MajorDiagnost/getMyObjectMajorDetails")
    Observable<MyObjectMajorBean> getMyObjectMajorDetails(
            @Field("gid") String gid
    );

    // 3+3选考的科目数据
    @FormUrlEncoded
    @POST("RecommendApi/GetSubject")
    Observable<SubjectsBean> GetSubject(
            @Field("gid") String gid
    );

    // 我的页面
    @FormUrlEncoded
    @POST("user/getMyBalance")
    Observable<MyBalanceBean> getMyBalance(
            @Field("gid") String gid
    );

    // 版本更新
    @POST("site/AppVersions")
    Observable<AppVersionBean> appVersions(
    );

    // 获取第二步志愿填报的必要参数
    @FormUrlEncoded
    @POST("RecommendApi/GetFilterData")
    Observable<FilterDataBean> getFilterData(
            @Field("gid") String gid,
            @Field("filterId") String filterId
    );

    *//*个性购买最新报告*//*
    @FormUrlEncoded
    @POST("VoReport/MajorAgainCharge")
    Observable<ChargeReturnIdInfo> MajorAgainCharge(
            @Field("gid") String gid,
            @Field("schoolId") String schoolId,
            @Field("majorIdPublic") String majorIdPublic,
            @Field("fod") String fod
    );

    *//*职业购买最新报告*//*
    @FormUrlEncoded
    @POST("VoReport/TplAgainCharge")
    Observable<ChargeInfo> TplAgainCharge(
            @Field("gid") String gid,
            @Field("tpl_id") String tpl_id
    );

    *//*公共购买最新报告*//*
    @FormUrlEncoded
    @POST("VoReport/PublicAgainCharge")
    Observable<ChargeReturnIdInfo> PublicAgainCharge(
            @Field("gid") String gid,
            @Field("majorIdBase") String majorIdBase
    );

    *//*公共购买最新报告*//*
    @FormUrlEncoded
    @POST("MajorDiagnost/PublicAgainCharge")
    Observable<PublicMajorChargeData> DiagnostPublicAgainCharge(
            @Field("gid") String gid,
            @Field("majorId") String majorId,
            @Field("degree") String degree
    );

    *//* 查分数----分数查位次、位次查分数*//*
    @FormUrlEncoded
    @POST("score/SearchRankOrScore")
    Observable<CandleInfoBean> SearchRankOrScore(
            @Field("provinceId") String provinceId,
            @Field("subject") String subject,//0 文科  1 理科  2 3+3
            @Field("param") String param,//分数或位次
            @Field("type") String type//2 根据分数查位次  3 根据位次查分数
    );

    *//* 专业诊断第四步*//*
    @FormUrlEncoded
    @POST("MajorDiagnost/ElectiveSubject")
    Observable<ElectiveSubjectBean> ElectiveSubject(
            @Field("gid") String gid
    );

    *//* 专业诊断第四步*//*
    @FormUrlEncoded
    @POST("MajorDiagnost/AjaxSaveDiagSubject")
    Observable<BasicBean> SaveDiagSubject(
            @Field("gid") String gid,
            @Field("subjectString") String subjectString
    );

    *//* 获取志愿文本*//*
    @FormUrlEncoded
    @POST("Expert/GetVolunteerText")
    Observable<VolunteerContentInfo> GetVolunteerText(
            @Field("gid") String gid,
            @Field("vid") String vid
    );

    *//* 申请咨询 返回专业 *//*
    @FormUrlEncoded
    @POST("Expert/GetMajorData")
    Observable<RegularMajorInfo> GetMajorData(
            @Field("level") String level   ///1 本科 2 专科
    );

    *//* 专家反馈  *//*
    @FormUrlEncoded
    @POST("Expert/GetFeedbackList")
    Observable<FeedbackInfo> GetFeedbackList(
            @Field("gid") String gid,
            @Field("page") int page
    );

    *//* 学生反馈  *//*
    @FormUrlEncoded
    @POST("Expert/GetStudentBack")
    Observable<StudentBackInfo> GetStudentBack(
            @Field("gid") String gid,
            @Field("type") String type,//请求类型 1学生提问  3学生发起终止 4专家的终止反馈|
            @Field("apply_id") String apply_id,
            @Field("content") String content,//学生用户提问信息 (type=4时,content给  1 同意  或者  2 不同意)
            @Field("msg_id") String msg_id
    );

    *//* 获取学生和专家的对话消息  *//*
    @FormUrlEncoded
    @POST("Expert/FeedbackDetail")
    Observable<FeedbackDetailInfo> FeedbackDetail(
            @Field("gid") String gid,
            @Field("page") int page,
            @Field("pageSize") int pageSize,
            @Field("apply_id") String apply_id,
            @Field("msg_id") String msg_id,
            @Field("state") String state
    );

    *//* 编辑成绩  *//*
    @POST("Expert/GetApiScore")
    Observable<GetApiScoreInfo> GetApiScore(
    );

    *//* 查分数---院校所在地  *//*
    @POST("score/SchoolAreaData")
    Observable<SchoolAreaData> SchoolAreaData(
    );

    *//*专家详情接口*//*
    @FormUrlEncoded
    @POST("expert/expertDetail")
    Observable<ExpertsDetailBean> getExpertsDeatils(
            @Field("gid") Integer gid,
            @Field("pid") String pid

    );

    *//*专家咨询支付界面*//*
    @FormUrlEncoded
    @POST("Expert/GetOrderPage")
    Observable<ExpertsOrderBean> getExpertsOrder(
            @Field("gid") Integer gid,
            @Field("orderId") String orderId
    );

    *//*专家咨询的筛选界面*//*
    @FormUrlEncoded
    @POST("Expert/ExpertListFilter")
    Observable<ExpertsFilterBean> getExpertsFilter(
            @Field("gid") Integer gid
    );

    *//*专家咨询的筛选界面结果页*//*
    @FormUrlEncoded
    @POST("Expert/ExpertList")
    Observable<ExpertsContentBean> getExpertsContent(
            @Field("gid") Integer gid,
            @Field("region") Integer region,
            @Field("level") Integer level,
            @Field("page") int page
    );

    *//*搜索专家*//*
    @FormUrlEncoded
    @POST("list/search")
    Observable<SearchExpertsBean> SearchExperts(
            @Field("searchType") String searchtype,
            @Field("searchContent") String SearchContent,
            @Field("page") int page,
            @Field("pagesize") int pagesize,
            @Field("gid") Integer gid
    );

    *//*获取api疾病  视力 选考科目*//*
    @FormUrlEncoded
    @POST("Expert/ApplyConstants")
    Observable<ApplyConstantsBean> ApplyConstants(
            @Field("gid") String gid
    );

    @FormUrlEncoded
    @POST("Expert/ApplyAppointment")
    Observable<ExpertsAppointmentBean> getApplyAppoinment(
            @Field("pid") String pid
    );

    //IsReadBean
    @FormUrlEncoded
    @POST("Expert/IsRed")
    Observable<ExpertReadMessage> getExpertsIsRead(
            @Field("gid") Integer gid
    );

    *//*
    * 保存预约的状态
    * *//*
    @POST("Expert/ProfessorSave")
    Observable<SoveExpertsStatus> getUpdateExpertsStatus(
            @Body ExpertsPostBean mExpertsPostBean
    );*/
}
