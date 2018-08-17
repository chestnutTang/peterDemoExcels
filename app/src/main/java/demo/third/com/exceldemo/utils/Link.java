package demo.third.com.exceldemo.utils;

import demo.third.com.exceldemo.BuildConfig;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 *
 * @author peter
 */

public class Link {
    public static String UPLOADIMAGE = BuildConfig.BUCKETIMGURL;
    public static final String UPLOAD_IMAGE_CONSTANT = BuildConfig.BUCKETIMG;
    /**
     * 获取验证码
     */
    public static final String SEND = BuildConfig.HOST + "sms/vc/send/v1";
    /**
     * 用户注册并登录接口（或单独登录）
     */
    public static final String SIGN = BuildConfig.HOST + "account/sign/v1";
    /**
     * 用户更新个人信息
     */
    public static final String UPDATE = BuildConfig.HOST + "account/info/update/v1";
    /**
     * 用户申请VIP
     */
    public static final String APPLY_VIP = BuildConfig.HOST + "account/vip/apply/v1";
    /**
     * 首页默认接口
     */
    public static final String HOMEPAGE = BuildConfig.HOST + "homepage/v1";
    /**
     * 首页搜索接口
     */
    public static final String SEARCH = BuildConfig.HOST + "homepage/search/v1";
    /**
     * 私募基金管理人查询
     */
    public static final String POFMANAGER = BuildConfig.HOST + "search/pof/manager/v1";
    /**
     * 私募基金管理人详情页信息接口
     */
    public static final String DETAIL = BuildConfig.HOST + "pof/manager/detail/v1";
    /**
     * 基金专户搜索
     */
    public static final String SEARCH_FUND = BuildConfig.HOST + "search/fund/account/v1";
    /**
     * 私募基金公示搜索
     */
    public static final String SEARCH_POF = BuildConfig.HOST + "search/pof/fund/v1";
    /**
     * 证券公司资管产品搜索
     */
    public static final String SEARCH_POF_SECURITIES = BuildConfig.HOST + "search/pof/securities/v1";
    /**
     * 期货公司资管产品搜索
     */
    public static final String SEARCH_POF_FUTURES = BuildConfig.HOST + "search/pof/futures/v1";
    /**
     * 证券公司直投基金搜索
     */
    public static final String SEARCH_AOIN = BuildConfig.HOST + "search/aoin/product/v1";
    /**
     * 证券公司私募投资基金搜索
     */
    public static final String SEARCH_POF_SUBFUND = BuildConfig.HOST + "search/pof/subfund/v1";
    /**
     * 从业机构公示
     */
    public static final String CYJGGS = BuildConfig.HOST + "search/cyjggs/v1";
    /**
     * 从业人员公示
     */
    public static final String SEARCHPERSON = BuildConfig.HOST + "search/person/v1";
    /**
     * 从业人员机构名单显示
     */
    public static final String SEARCHPERSONRPI = BuildConfig.HOST + "search/person/rpi/v1";
    /**
     * 黑名单公示
     */
    public static final String SEARCHHMD = BuildConfig.HOST + "search/hmd/v1";
    /**
     * 纪律处分公示
     */
    public static final String SEARCHJLCF = BuildConfig.HOST + "search/jlcf/v1";
    /**
     * 证券公司私募产品备案确认函
     */
    public static final String SEARCHZQGS = BuildConfig.HOST + "search/zqgs/v1";
    /**
     * 资产支持专项计划信息公示
     */
    public static final String ZXJH = BuildConfig.HOST + "search/zxjh/v1";
    /**
     * 考试成绩查询 code
     */
    public static final String EXAMQUERY = BuildConfig.HOST + "exam/query/v1";
    /**
     * 不予登记机构 pageIndex pageSize
     */
    public static final String BYDJJG = BuildConfig.HOST + "search/bydjjg/v1";
    /**
     * 资产支持专项计划备案确认函公示 pageIndex pageSize
     */
    public static final String ZCZCZXJHBAQRHGS = BuildConfig.HOST + "search/zczczxjhbaqrhgs/v1";
    /**
     * 公募基金管理人文档下载
     */
    public static final String DOWNLOADGMJJ = BuildConfig.HOST + "download/gmjj/v1";
    /**
     * 撤销管理人登记的名单 pageIndex pageSize
     */
    public static final String SEARCH_SEARCH = BuildConfig.HOST + "search/search/v1";
    /**
     * 基金托管人文档下载
     */
    public static final String DOWNLOAD_TGYX = BuildConfig.HOST + "download/tgyx/v1";
    /**
     * 销售账户公示
     */
    public static final String SEARCH_ZHGS = BuildConfig.HOST + "search/zhgs/v1";
    /**
     * 考试大纲 pageIndex pageSize
     */
    public static final String SEARCH_CYRYKS = BuildConfig.HOST + "search/cyryks/v1";
    /**
     * 考试教材订购
     */
    public static final String SEARCH_JCDG = BuildConfig.HOST + "search/jcdg/v1";
    /**
     * 从业资格考试信息 pageIndex pageSize
     */
    public static final String SEARCH_CYKSXX = BuildConfig.HOST + "search/cyksxx/v1";
    /**
     * 消息首页默认接口 pageIndex pageSize
     */
    public static final String MESSAGE_LIST = BuildConfig.HOST + "message/list/v1";
}
