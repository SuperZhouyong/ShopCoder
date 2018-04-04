package com.intention.sqtwin.app;

/**
 * des:
 * Created by xsf
 * on 2016.09.10:44
 */
public class AppConstant {
    //    wxd2fb38f960eb278e appid  wxd2fb38f960eb278e
    //wxe28f83bf7e4a9ecc
    public static final String WxAPP_ID = "wxd2fb38f960eb278e";
    public static final String WxAppSecret = "36e1f4140c4eb739d6c958c9e047fee8";
    // 去商城的 Type
    public static final int PayTypeRecommend = 2;
    public static final int PayTypeReport = 3;
    public static final String TOSHOP = "toshop";
    // 报告页面显示导蒙层
    public static final String REPORTCOLLECT = "reportcollect";
    public static final String CHANGEHOMEPAGE = "changehomepage";
    // 推荐报告购买完毕
    public static final String MAJORREBUYOVER = "majorrebuyover";
    // 公共专业报告购买完毕
    public static final String MAJORREPUBBUYOVER = "majorrepubbuyover";
    // 学校专业报告购买完毕
    public static final String MAJORRESCHBUYOVER = "majorreschbuyover";
    // 职业报告购买完毕
    public static final String PROREBUYOVER = "prorebuyover";
    /*记录去支付页面的tag*/
    public static final String FROMRECRE = "34";//从推荐去的支付页面
    public static final String FROMSCHRE = "35";//从学校报告去的支付页面
    public static final String FROMPRORE = "36";//从职业报告去的支付页面
    public static final String FROMPUBRE = "37";//从公共专业报告去的支付页面
    public static final String PURCHRECORD = "38"; //
    public static final String FROMRECOMMEND = "39";// 从推荐进去的
    public static final String FROMSHOPFRAGMENT = "40";// 从商城进
    public static final String TOCONFIRMORDER = "toconfirmorder";// 微信支付支付完成返回确认订单，通知支付完成
    public static final String ACTIONTYPE = "ACTIONTYPE";// 注意，与此字符串相同的时候，是没有参数返回的
    public static final String FROMMAJORSCORE = "frommajorscore";// 从查询专业分数线去支付页面
    public static final String FROMASPIRATIONTWO = "from_aspiration";// 从志愿填报第二步
    public static final String FROMASPIRATIONONE = "from_aspiration";// 从志愿填报第一步

    // 分布的最小比例
    public static final double MIN = 0.01;
    // 确认支付页面回调未支付订单
    public static final String ORDERPAID = "orderpaid";
    // 通知已支付订单页更新数据
    public static final String TELLORDERPAID = "tellorderpaid";
    /*报告的各种type*/
    public static final String REPORT_SEARCH = "report_search";// 报告-搜索条件
    public static final String REPORT_INFO = "report_info";// 报告-简介
    public static final String REPORT_ADMISSION = "report_admission";// 报告-录取概率
    public static final String REPORT_DISTRIBUTION = "report_distribution";// 报告-就业分布
    public static final String REPORT_SALARY = "report_Salary";// 报告-平均起薪
    public static final String REPORT_COUNTERPARTS = "report_Counterparts";// 报告-对口率
    public static final String REPORT_Growth = "report_Growth";// 报告-成长周期
    public static final String REPORT_CareerChange = "report_CareerChange";// 报告-转行率
    public static final String REPORT_CityRanking = "report_CityRanking";// 报告-就业地区分布
    public static final String REPORT_ReportPercent = "report_ReportPercent";// 报告-企业性质
    public static final String REPORT_Industry = "report_Industry";// 报告-行业分布
    public static final String REPORT_OTHERS = "report_others";// 报告-其他院校相同专业
    // 报告页购买新报告完毕后，刷新收藏或者是我的报告
    public static final String REFRESH = "refresh";

    //每次套餐价格的直接保存
    public static int PackgePriceShop = 0;
    public static final int GoodSIdFore = 4;

    // 保存每次套餐的价格
    public static final String PackagePrice = "packageprice";
    //第一次进入的状态
    public static final String isFirstStart = "isFirstStart";
    // fragment的三种状态
    public static final String FragmentType = "FragmentType";
    public static final String Fragment_TypeMajorPay = "MajorPayFragment";
    public static final String Fragment_TypeMajorDis = "MajorDisFragment";
    public static final String Fragment_TypeSuiteRate = "SuitedRateFragment";

    //Vp图标的 三种状态
    // 完成购买
    public static final int Tag_One = 0;
    // 去商城
    public static final int Tag_Two = 1;
    //扣除购买费用
    public static final int Tag_Three = 2;
    // 去登陆
    public static final int Tag_Four = 3;
    // 购买最新报告
    public static final int Tag_Five = 4;

    //邀请注册协议
    public static final String RegistAgreement = "/site/RegisterAgreementForWap";

    //用户服务协议
    public static final String UserAgreemnet = "/site/ServiceAgreementForWap";

    //    public static final String AssmentContant = "http://zhiyuan.souqiantu.com/";
    public static String AssmentContant = "https://www.zhiyuan360.cn/";
    public static String AssmentUrlContent = "https://192.168.0.66:8082/";
    //    public static final String official = "http://zhiyuan.souqiantu.com/api/";
    //todo
    public static String official = "https://www.zhiyuan360.cn/api/";
    /*
    * WebView 相关界面         www.zhiyuan360.cn
    * */
    public static String Guhaiye = "http://192.168.0.8:8088/api/";
    public static final String YangChunHao = "http://192.168.0.205:1001/api/";
    public static final String XuZhen = "http://192.168.0.5:89/api/";

    //临时的Url
    public static String TempUrl = "http://www.zhiyuan360.cn/api/";
    // 线上66 测试 api   https://www.zy360.com/
    public static String CESHI = "https://192.168.0.66:8082/api/";
    //    public static String CESHI = "https://www.zy360.com/api";
    // 关于Url的链接
    public static String GouHao = "http://192.168.0.12:1002/api/";
    //0.7 224
    public static String gaojiejing = "http://192.168.0.7:85/api/";
    //webView 的Titleapi
    public static final String WEBTITLE = "webTitle";

    public static final String MyAssessment = "MyAssessment";
    //Question
    public static final String MyAssessmentFristpage = "TalentTest/Index";

    public static final String ALLTAG = "ALLTAG-------------";

    public static final String Constant = "http://192.168.0.66:8082/api/";
    public static final String KEY = "sqtapi123456";
    //  todo 我的报告的图片返回的非固定路径的前缀
    public static final String LOGO = "http://www.souqiantu.com:8123/highschool";

    //共享动画
//    public static final String TRANSITION_ANIMATION_NEWS_PHOTOS = "transition_animation_news_photos";
    //个人信息修改
    public static final String REVAMP = "revamp";
    /*
    * ColllegesFilter四种参数
    * */
    public static final String SchoolArea = "SchoolArea";
    public static final String SchoolType = "SchoolType";
    public static final String Degree = "Degree";
    public static final String Fame = "Fame";
    public static final String Inviate = "Inviate";
    /*
    * 院校大全进入院校详情
    * */
    public static final String CollegesDetail = "CollegesDetail";
    /*
    * 院校大全的 收藏状态
    * */
    public static final String IsCollect = "isCollect";
    /*
    * RecomedSchoolMajor Collect status
    * 推荐学校专业的 的 刷新收藏状态的 标记
    * */
    public static final String RecommendSchoolMajor = "RecommendSchoolMajor";
    /*
    * 图片详情界面
    * */
    public static final String PHOTO_DETAIL = "PHOTO_DETAIL";
    /*
    * 修改收藏图标
    * */
    public static final String SwitchCollect = "SwitchCollect";
    /*
    *   购物车删除了第一个商品 ，且删除成功了
    * */
//    public static final String deleteTest = "deleteTest";

    /**
     * The constant DEBUG_TAG.
     */
    public static final String DEBUG_TAG = "logger";// LogCat的标记

    /*****************************************************************
     * mMode参数解释： "00" - 启动银联正式环境 "01" - 连接银联测试环境
     *****************************************************************/
    public static final String mMode = "01";
    public static final String HOME_CURRENT_TAB_POSITION = "HOME_CURRENT_TAB_POSITION";
    public static final String MENU_SHOW_HIDE = "MENU_SHOW_HIDE";
    //增加购物车
//    public static final String ADD_TO_SHOPCART = "ADDTOSHOPCART";
    //修改了购物车的信息
    public static final String Operation_ShopCart = "Operationshopcart";
    public static final String Operation_ShopCart1 = "Operationshopcart1";
    //总计金额通知
    public static final String TOTAL_MONEY_INFORM = "TOTALMONEYINFORM";
    //结算生成的订单
    public static final String Settlement = "Settlement";
    // 搜索的类型
    public static final String SEARCH_TYPE = "SEARCHTYPE";
    //搜索专业的类型
    public static final String SERACH_MAJOR_TYPR = "searchmajortype";
    // 开始对比
    public static final String START_COMPARE = "COMPARE";
    public static final String Search_School = "school";
    public static final String Serarch_Major = "major";
    public static final String Search_CheckOther = "Search_CheckOther";
    public static final String Search_school_name = "Search_school_name";
    //二级fragment 跳入到 购买界面
    public static final String ActivitySwictToFragment = "SwitchToFragment";
    //验证银联验证回调

    //    验证码
    public static final String REGISTER = "register";
    public static final String FINDPASSF = "findPassF";
    //支付方式
    public static final String alipay = "alipay";
    public static final String wxpay = "wxpay";
    public static final String UnPay = "unpay";
    //key
//    public static final String KEY = "zbjsqt123456";

    public static final char[] LETTERS = {'热', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'
            , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final String NEWS_LIST_TO_TOP = "LISTTOTOP";
    /*
    * 移动到顶部
    * */

    public static final String TO_TOP = "TO_TOP";
    //'A','B','C','D','E','F','G','H','I','J','K','L','M','N','G','H'
    // 职业分布
    public static final String FRAGMENT_DATA = "fragment_data";
    // 平均薪资
    public static final String FRAGMENT_SALARY = "fragment_salary";
    // 对口率
    public static final String FRAGMENT_COUNTERPARTS = "fragment_counterparts";
    // 就业地区分布
    public static final String FRAGMENT_EMPLOYMENT = "fragment_employment";
    // 就业行业分布
    public static final String FRAGMENT_INDUSTRY = "fragment_industry";
    // 企业性质
    public static final String FRAGMENT_ENTERPRISE = "fragment_enterprise";
    // 职业报告的点击购买
    public static final String TOBUY = "tobuy";
    // 专业报告的点击购买
    public static final String TOBUY1 = "tobuy1";
    //对比页面
    public static final String COMPARE = "compare";
    // 职业对比报告点击年
    public static final String YEAR = "year";
    //
    public static final String TYPE_ONE = "type_one";
    public static final String TYPE_TWO = "type_two";
    // 调值参数学校的选择返回
    public static final String TOTONE = "totone";
    public static final String TOPROREORT = "toproreort";
    public static final String TOMAJORREPUB = "tomajorrepub";
    public static final String Update = "Update";
    public static final String App_DownUrl = "AppDownUrl";
    // 修改Homem的推荐
    public static final String UpdateMajor = "UpdateMajor";
    public static final String isUpdateMajor = "isUpdateMajor";
    public static final String Moneynum = "Moneynum";
    // HomePage 的已设置条件
    public static final String UpdateRecord = "UpdateRecord";
    public static final String UpdateHaveSearch = "UpdateHaveSearch";
    public static final String RegistUserInfo = "RegistUserInfo";
    public static final String ConfirmOk = "ConfirmOk";
    public static final String ConfirmSchool = "ConfirmSchool";
    public static final String VpCutent = "VpCutent";
    // 三加三的标签
    public static final String isThree = "ISTHREE";
    public static final String OnclickItem = "OnClickItem";
    public static final String ScoreTrend = "ScoreTrend";


    // 加密密钥
    public static final String[] EcryptArray = {"jW7D31IkoA51iUvl", "QgNACCAS1w9Ykko8", "gmxwxChjxiGRRO9G", "ABQXNvsYerndfTUp", "CR85hCIYyYUHZ7ql"};
    public static String Finsh_Rel = "finsh";
    public static String ProvinceID = "ProvinceID";
    // 志愿填报筛选界面的
    public static String IntentFiltrate = "IntentFiltrate";
    public static String SelectTag = "SelectTag";
//    public static final String[] SelectFilter = {"area","major",""} ;


    public static String UpdateMajorList = "UpdateMajorList";
    public static String AddMjor = "AddMajor";
    public static String UpdateUIBottom = "UpdateUIBottom";
    // 保存数组集合当前操作的
    public static String UpdateIntentionList = "UpdateIntentionList";
    public static String UpdateIntentionListOne = "UpdateIntentionListOne";
    // 初始化本科的一些数据
    public static String FirstInit = "FirstInit";

    //志愿填报的  排序条件，筛选条件
    // 院校风险
    public static String SelectSchool = "schoolRisk";
    // 专业风险
    public static String SelectMajor = "majorRisk";
    // 专业对口率
    public static String SelectMajorRate = "majorRate";
    // 平均薪资
    public static String SelectSalary = "averageSalary ";
    //院校所在地
    public static String SchollLocation = "schoolLocation";
    //专业类别
    public static String majorClass = "majorClass";
    //录取批次
    public static String recruitBatch = "recruitBatch";
    // 选考科目
    public static String chooseSubject = "chooseSubject";
    public static String descschool = "descSchool";
    public static String Titleschool = "titleSchool";
    public static String TO_TOP_RESEARCH = "TO_TOP_RESEARCH";
    public static String DeleteMajor = "DeleteMajor";
    public static String Note = "NOTE";
    public static String NOTESIZE = "NOTESIZE";
    public static String noteUpdate = "updateNote";
    // 咨询的筛选列表
    public static final String LevelBean = "LevelBean";
    public static final String RegionBean = "RegionBean";
    public static final String PID = "PID";
    public static final String Experts = "expert";
    public static final String content = "content";
    /*public static String SelectArea = "area";
    public static String SelectMajor = "major";
    public static String Selectbatch = "batch";*/


}
