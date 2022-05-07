package com.zhy.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * [标准规范]服务+接口 统一返回错误码
 * 1xxxxxx：接口级验证错误
 * 2xxxxxx：内部不可控错误，如：MySQL不可用、MySQL插入失败、Memcached不可用等
 * 3xxxxxx：接口、服务等业务错误，如：记录不存在、人数已满等业务提示，按功能定义
 *
 * @author ding
 * @date 2020-11-26 11:17
 */
public final class ResultCode {
    public final static Map<Integer, String> CODE_MAPS = new HashMap<>();

    /**
     * 系统未定义错误code
     */
    public static final Integer SYS_UNDEFINED = -1;
    /**
     * 无效的请求体
     */
    public static final Integer INVALID_BODY = 1001000;
    /**
     * 无效的签名
     */
    public static final Integer INVALID_SIGN = 1001001;
    /**
     * 无效的会话
     */
    public static final Integer INVALID_SESSION = 1001002;
    /**
     * 无效的API方法
     */
    public static final Integer INVALID_METHOD = 1001003;
    /**
     * 无效的时间戳
     */
    public static final Integer INVALID_TIMESTAMP = 1001004;
    /**
     * 无效的版本号
     */
    public static final Integer INVALID_VERSION = 1001005;
    /**
     * 无效的格式
     */
    public static final Integer INVALID_FORMAT = 1001006;
    /**
     * 无效的微信码
     */
    public static final Integer INVALID_WXID = 1001007;
    /**
     * 无效的设备码
     */
    public static final Integer INVALID_UDID = 1001008;
    /**
     * 无效的应用ID
     */
    public static final Integer INVALID_APPID = 1001009;
    /**
     * 无效的TOKEN
     */
    public static final Integer INVALID_TOKEN = 1001010;

    //1002xxx 参数为缺失系列
    /**
     * 缺失参数
     */
    public static final Integer MISSING_PARAMS = 1002000;
    /**
     * 缺失签名
     */
    public static final Integer MISSING_SIGN = 1002001;
    /**
     * 缺失会话
     */
    public static final Integer MISSING_SESSION = 1002002;
    /**
     * 缺失API方法
     */
    public static final Integer MISSING_METHOD = 1002003;
    /**
     * 缺失时间戳
     */
    public static final Integer MISSING_TIMESTAMP = 1002004;
    /**
     * 缺失版本号
     */
    public static final Integer MISSING_VERSION = 1002005;
    /**
     * 缺失格式
     */
    public static final Integer MISSING_FORMAT = 1002006;
    /**
     * 缺失微信码
     */
    public static final Integer MISSING_WXID = 1002007;
    /**
     * 缺失设备码
     */
    public static final Integer MISSING_UDID = 1002008;
    /**
     * 缺失应用ID
     */
    public static final Integer MISSING_APPID = 1002009;
    /**
     * 缺失TOKEN
     */
    public static final Integer MISSING_TOKEN = 1002010;

    //账户相关 1003xxx
    /**
     * 账号登录过期，需要重新登录
     */
    public static final Integer ACCOUNT_LOGIN_EXPIRED = 1003001;
    /**
     * 账号不存在或被禁用
     */
    public static final Integer ACCOUNT_UNAVAILABLE = 1003002;
    /**
     * 账号无权访问该接口
     */
    public static final Integer ACCOUNT_METHOD_FORBIDDEN = 1003003;
    /**
     * 账号每分钟请求超出限制
     */
    public static final Integer ACCOUNT_ACCESS_LIMIT_MINUTE = 1003004;

    //1004xxx 其它参数检查异常系列
    /**
     * 请求必须为POST
     */
    public static final Integer REQUEST_NEED_POST = 1004001;
    /**
     * 请求必须为GET
     */
    public static final Integer REQUEST_NEED_GET = 1004002;

    // 服务端出现的不可控的错误，请以SERVICE_UNAVAILABLE_+错误功能 来区分具体错误在哪里，如：2001000为 memcached操作错误
    // 也可基于某个功能做延伸，如：SERVICE_UNAVAILABLE_MEMCACHED_xxx ，为2001001,2001002....后面的为预留错误码
    /**
     * 服务器内部错误
     */
    public static final Integer SERVER_UNAVAILABLE = 2000000;

    /**
     * 服务器内部错误-API文件不存在
     */
    public static final Integer SERVER_UNAVAILABLE_API_NOT_EXISTS = 2000001;
    /**
     * 服务器内部错误-HTTP请求错误
     */
    public static final Integer SERVER_UNAVAILABLE_CALL_HTTP_FAILED = 2000002;
    /**
     * 服务器内部错误-JSON 解析错误
     */
    public static final Integer SERVER_JSON_DECODE_FAILED = 2000003;
    /**
     * 服务器内部错误-网络信息解密错误
     */
    public static final Integer SERVER_UNAVAILABLE_DECRYPT_FAILED = 2000004;
    /**
     * 服务器内部错误-Object转换错误
     */
    public static final Integer SERVER_OBJECT_CONVERT_FAILED = 2000005;
    /**
     * 服务器内部错误-ArrayUtil转换错误
     */
    public static final Integer SERVER_ARRAY_UTIL_FAILED = 2000006;
    /**
     * 服务器内部错误-StringUtil转换错误
     */
    public static final Integer SERVER_STRING_UTIL_FAILED = 2000007;
    /**
     * 服务器内部错误-memcached错误
     */
    public static final Integer SERVER_UNAVAILABLE_MEMCACHED = 2001000;
    /**
     * 服务器内部错误-memcached错 误-put错误
     */
    public static final Integer SERVER_UNAVAILABLE_MEMCACHED_PUT = 2001001;
    /**
     * 服务器内部错误-MySQL错误
     */
    public static final Integer SERVER_UNAVAILABLE_MYSQL = 2002000;
    /**
     * 服务器内部错误-MySQL错误-插入错误
     */
    public static final Integer SERVER_UNAVAILABLE_MYSQL_INSERT = 2002001;
    /**
     * 服务器内部错误-MySQL错误-更新错误
     */
    public static final Integer SERVER_UNAVAILABLE_MYSQL_UPDATE = 2002002;

    /**
     * 抛出异常
     */
    public static final Integer SERVER_UNAVAILABLE_EXCEPTION = 2003000;

    /**
     * 服务器内部错误-redis错误
     */
    public static final Integer SERVER_UNAVAILABLE_REDIS = 2004000;

    /**
     * 服务器内部错误-Feign错误
     */
    public static final Integer SERVER_UNAVAILABLE_FEIGN = 2005000;

    /**
     * 活动平台返回错误
     */
    public static final Integer SERVER_UNAVAILABLE_ACTIVITY = 2006000;

    // 限流、分步式锁、熔断等错误系列
    /**
     * 分步式锁等待
     */
    public static final Integer SERVER_LOCK_WAIT = 2010001;

    // 接口内部定义错误码
    /**
     * API接口错误
     */
    public static final Integer APP_ERROR = 3000000;
    /**
     * 查询记录不存在
     */
    public static final Integer APP_RECORD_NOT_EXISTS = 3001001;
    /**
     * 查询记录与线上不匹配
     */
    public static final Integer APP_RECORD_NOT_MATCHED = 3001002;
    /**
     * 缺少参数
     */
    public static final Integer APP_MISSING_PARAMS = 3001003;
    /**
     * 参数有误
     */
    public static final Integer APP_INVALID_PARAMS = 3001004;
    /**
     * 查询记录不允许修改了
     */
    public static final Integer APP_RECORD_NOT_MODIFIED = 3001005;
    /**
     * 查询记录已存在
     */
    public static final Integer APP_RECORD_HAS_EXISTS = 3001006;

    /**
     * 查询记录状态错误
     */
    public static final Integer APP_RECORD_STATUS_ERROR = 3001007;

    /**
     * 订单创建失败
     */
    public static final Integer APP_ORDER_CREATE_FAILED = 3001100;
    /**
     * 订单商品库存不足
     */
    public static final Integer APP_ORDER_ITEM_QTY_NOT_ENOUGH = 3001101;
    /**
     * 订单商品超过限购数量
     */
    public static final Integer APP_ORDER_ITEM_NUM_LIMIT = 3001102;
    /**
     * 订单状态不对
     */
    public static final Integer APP_ORDER_STATUS_ERROR = 3001103;

    /**
     * 交易状态不匹配
     */
    public static final Integer APP_TRADE_STATUS_NOT_MATCH = 3001200;

    /**
     * 该笔交易有误
     */
    public static final Integer APP_TRADE_FAILED = 3001201;
    public static final Integer APP_TRADE_FAILED_CPCN = 3001202;
    public static final Integer APP_TRADE_REFUND_FAILED = 3001203;
    /**
     * 赠品不支持退款
     */
    public static final Integer APP_TRADE_REFUND_FAILED_GIVEAWAY = 3001204;

    /**
     * 查询用户信息记录不匹配
     */
    public static final Integer APP_MEMBER_NOT_MATCH = 3002101;
    /**
     * 网络请求会员中心错误
     */
    public static final Integer APP_MEMBER_USER_CENTER_ERROR = 3002102;

    /**
     * 网络请求订单商城错误
     */
    public static final Integer APP_MEMBER_CLOUD_JOYOUNG_ERROR = 3002103;

    /**
     * 网络请求活动平台错误
     */
    public static final Integer APP_MEMBER_ACTIVITY_PLATFORM_ERROR = 3002104;

    /**
     * 网络请求dms平台错误
     */
    public static final Integer APP_MEMBER_DMS_ERROR = 3002105;

    /**
     * 网络请求智能部 错误
     */
    public static final Integer APP_IOT_ERROR = 3002106;

    /**
     * 快递100返回错误
     */
    public static final Integer APP_KUAIDI100_ERROR = 3003200;
    /**
     * 双中心 库存中心 返回错误
     */
    public static final Integer APP_TWO_CENTER_STOCK_ERROR = 3003300;

    /**
     * 双中心 订单中心 返回错误
     */
    public static final Integer APP_TWO_CENTER_ORDER_ERROR = 3003400;
    //===

    /**
     * 查询门店类型不匹配
     */
    public static final Integer APP_SHOP_TYPE_NOT_MATCH = 3002201;

    /**
     * 微信返回错误
     */
    public static final Integer APP_WECHAT_ERROR = 3002000;
    /**
     * 用户没有创建微信会员卡
     */
    public static final Integer APP_WECHAT_CARD_NOT_EXISTS = 3002001;
    /**
     * 阿里云返回错误
     */
    public static final Integer APP_ALIYUN_ERROR = 3003000;
    /**
     * 阿里云oss上传返回错误
     */
    public static final Integer APP_ALIYUN_OSS_ERROR = 3003001;
    /**
     * 微服务网关返回错误
     */
    public static final Integer APP_MICROSERVICE_GATEWAY_ERROR = 3004000;
    /**
     * 微服务网关业务返回错误
     */
    public static final Integer APP_MICROSERVICE_GATEWAY_APP_ERROR = 3004001;

    /**
     * 添加分类，该分类已存在
     */
    public static final Integer APP_CATEGORY_ADD_IS_EXIST = 3005001;

    /**
     * 修改分类，该分类已存在
     */
    public static final Integer APP_CATEGORY_UPDATE_IS_EXIST = 3005002;

    /**
     * 审核商品，此商品已审核通过
     */
    public static final Integer APP_GOODS_AUDIT_TYPE_IS_APPROVED = 3006001;

    /**
     * 审核商品，此商品不在价格范围
     */
    public static final Integer APP_GOODS_AUDIT_TYPE_IS_FORCE_PRICE = 3006002;

    /**
     * 审核商品，此商品店铺最大优惠不在价格范围
     */
    public static final Integer APP_GOODS_AUDIT_TYPE_IS_FORCE_PRICE_SHOP = 3006004;

    /**
     * 审核商品-此商品已有审核在进行
     */
    public static final Integer APP_GOODS_AUDIT_TYPE_IS_WAITING = 3006003;

    /**
     * 操作库存，此商品非上架状态
     */
    public static final Integer APP_QTY_DECREASE_GOODS_STATUS_OFF = 3007001;

    /**
     * 此商品已下架
     */
    public static final Integer APP_GOODS_STATUS_OFF = 3007002;

    /**
     * 扣减库存失败
     */
    public static final Integer APP_QTY_DECREASE_FAILED = 3007003;

    /**
     * 我的优惠券错误
     */
    public static final Integer APP_MY_COUPON_ERROR = 3008000;
    /**
     * 优惠券已被使用
     */
    public static final Integer APP_MY_COUPON_IS_USED = 3008001;

    /**
     * 优惠券已过期
     */
    public static final Integer APP_MY_COUPON_IS_EXPIRED = 3008002;

    /**
     * 优惠券未到使用时间
     */
    public static final Integer APP_MY_COUPON_NOT_BEGIN = 3008003;

    /**
     * 领取优惠券超过限领数量
     */
    public static final Integer APP_MY_COUPON_LIMIT_COUNT = 3008004;

    /**
     * 核销优惠券失败
     */
    public static final Integer APP_MY_COUPON_CONSUME_FALSE = 3008005;

    /**
     * 回滚优惠券失败
     */
    public static final Integer APP_MY_COUPON_ROLLBACK_FALSE = 3008006;

    static {
        CODE_MAPS.put(SYS_UNDEFINED, "系统未定义错误码");
        CODE_MAPS.put(INVALID_BODY, "无效的请求体");
        CODE_MAPS.put(INVALID_SIGN, "无效的签名");
        CODE_MAPS.put(INVALID_SESSION, "无效的会话");
        CODE_MAPS.put(INVALID_METHOD, "无效的API方法");
        CODE_MAPS.put(INVALID_TIMESTAMP, "无效的时间戳");
        CODE_MAPS.put(INVALID_VERSION, "无效的版本号");
        CODE_MAPS.put(INVALID_FORMAT, "无效的格式");
        CODE_MAPS.put(INVALID_WXID, "无效的微信码");
        CODE_MAPS.put(INVALID_UDID, "无效的设备码");
        CODE_MAPS.put(INVALID_APPID, "无效的应用ID");
        CODE_MAPS.put(INVALID_TOKEN, "无效的TOKEN");
        CODE_MAPS.put(MISSING_PARAMS, "缺失参数");
        CODE_MAPS.put(MISSING_SIGN, "缺失签名");
        CODE_MAPS.put(MISSING_SESSION, "缺失会话");
        CODE_MAPS.put(MISSING_METHOD, "缺失API方法");
        CODE_MAPS.put(MISSING_TIMESTAMP, "缺失时间戳");
        CODE_MAPS.put(MISSING_VERSION, "缺失版本号");
        CODE_MAPS.put(MISSING_FORMAT, "缺失格式");
        CODE_MAPS.put(MISSING_WXID, "缺失微信码");
        CODE_MAPS.put(MISSING_UDID, "缺失设备码");
        CODE_MAPS.put(MISSING_APPID, "缺失应用ID");
        CODE_MAPS.put(MISSING_TOKEN, "缺失TOKEN");
        CODE_MAPS.put(ACCOUNT_LOGIN_EXPIRED, "账号登录过期，需要重新登录");
        CODE_MAPS.put(ACCOUNT_UNAVAILABLE, "账号不存在或被禁用");
        CODE_MAPS.put(ACCOUNT_METHOD_FORBIDDEN, "账号无权访问该接口");
        CODE_MAPS.put(ACCOUNT_ACCESS_LIMIT_MINUTE, "账号每分钟请求超出限制");
        CODE_MAPS.put(REQUEST_NEED_POST, "请求必须为POST");
        CODE_MAPS.put(REQUEST_NEED_GET, "请求必须为GET");
        CODE_MAPS.put(SERVER_UNAVAILABLE, "服务器内部错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_API_NOT_EXISTS, "服务器内部错误-API文件不");
        CODE_MAPS.put(SERVER_UNAVAILABLE_CALL_HTTP_FAILED, "服务器内部错误-HTTP请求错误");
        CODE_MAPS.put(SERVER_JSON_DECODE_FAILED, "服务器内部错误-JSON 解析错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_DECRYPT_FAILED, "服务器内部错误-网络信息解密错误");
        CODE_MAPS.put(SERVER_OBJECT_CONVERT_FAILED, "服务器内部错误-Object转换错误");
        CODE_MAPS.put(SERVER_ARRAY_UTIL_FAILED, "服务器内部错误-ArrayUtil转换错误");
        CODE_MAPS.put(SERVER_STRING_UTIL_FAILED, "服务器内部错误-StringUtil转换错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_MEMCACHED, "服务器内部错误-memcache");
        CODE_MAPS.put(SERVER_UNAVAILABLE_MEMCACHED_PUT, "服务器内部错误-memcache");
        CODE_MAPS.put(SERVER_UNAVAILABLE_MYSQL, "服务器内部错误-MySQL错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_MYSQL_INSERT, "服务器内部错误-MySQL错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_MYSQL_UPDATE, "服务器内部错误-MySQL错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_EXCEPTION, "服务器Exception异常");
        CODE_MAPS.put(SERVER_UNAVAILABLE_REDIS, "服务器内部错误-redis错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_FEIGN, "服务器内部错误-Feign错误");
        CODE_MAPS.put(SERVER_UNAVAILABLE_ACTIVITY, "活动平台返回错误");
        CODE_MAPS.put(APP_ERROR, "API接口错误");
        CODE_MAPS.put(APP_RECORD_NOT_EXISTS, "查询记录不存在");
        CODE_MAPS.put(APP_RECORD_NOT_MATCHED, "查询记录与线上不匹配");
        CODE_MAPS.put(APP_MISSING_PARAMS, "缺少参数");
        CODE_MAPS.put(APP_INVALID_PARAMS, "参数有误");
        CODE_MAPS.put(APP_RECORD_NOT_MODIFIED, "查询记录不允许修改了");
        CODE_MAPS.put(APP_RECORD_HAS_EXISTS, "查询记录已存在");
        CODE_MAPS.put(APP_RECORD_STATUS_ERROR, "查询记录状态错误");
        CODE_MAPS.put(APP_ORDER_CREATE_FAILED, "订单创建失败");
        CODE_MAPS.put(APP_ORDER_ITEM_QTY_NOT_ENOUGH, "订单商品库存不足");
        CODE_MAPS.put(APP_ORDER_ITEM_NUM_LIMIT, "订单商品超过限购数量");
        CODE_MAPS.put(APP_ORDER_STATUS_ERROR, "订单状态不对");
        CODE_MAPS.put(APP_WECHAT_ERROR, "微信返回错误");
        CODE_MAPS.put(APP_WECHAT_CARD_NOT_EXISTS, "用户没有创建微信会员卡");
        CODE_MAPS.put(APP_ALIYUN_ERROR, "阿里云返回错误");
        CODE_MAPS.put(APP_ALIYUN_OSS_ERROR, "阿里云oss上传返回错误");
        CODE_MAPS.put(APP_MICROSERVICE_GATEWAY_ERROR, "微服务网关返回错误");
        CODE_MAPS.put(APP_MICROSERVICE_GATEWAY_APP_ERROR, "微服务网关业务返回错误");
        CODE_MAPS.put(APP_MEMBER_NOT_MATCH, "查询用户信息记录不匹配");
        CODE_MAPS.put(APP_MEMBER_USER_CENTER_ERROR, "网络请求会员中心错误");
        CODE_MAPS.put(APP_MEMBER_CLOUD_JOYOUNG_ERROR, "网络请求订单商城错误");
        CODE_MAPS.put(APP_MEMBER_ACTIVITY_PLATFORM_ERROR, "网络请求活动平台");
        CODE_MAPS.put(APP_KUAIDI100_ERROR, "快递100返回错误");
        CODE_MAPS.put(APP_CATEGORY_ADD_IS_EXIST, "添加分类-该分类已存在");
        CODE_MAPS.put(APP_CATEGORY_UPDATE_IS_EXIST, "修改分类-该分类已存在");
        CODE_MAPS.put(APP_GOODS_AUDIT_TYPE_IS_APPROVED, "审核商品-此商品已审核通过");
        CODE_MAPS.put(APP_GOODS_AUDIT_TYPE_IS_FORCE_PRICE, "审核商品-此商品不在价格范围");
        CODE_MAPS.put(APP_GOODS_AUDIT_TYPE_IS_FORCE_PRICE_SHOP, "审核商品-此商品店铺最大优惠不在价格范围");
        CODE_MAPS.put(APP_GOODS_AUDIT_TYPE_IS_WAITING, "审核商品-此商品已有审核在进行");
        CODE_MAPS.put(APP_QTY_DECREASE_GOODS_STATUS_OFF, "操作库存-此商品非上架状态");
        CODE_MAPS.put(APP_GOODS_STATUS_OFF, "此商品已下架");
        CODE_MAPS.put(APP_QTY_DECREASE_FAILED, "扣减库存失败");
        CODE_MAPS.put(APP_TRADE_FAILED, "交易状态不匹配");
        CODE_MAPS.put(APP_TRADE_STATUS_NOT_MATCH, "交易状态不匹配");
        CODE_MAPS.put(APP_TRADE_REFUND_FAILED, "交易退款失败");
        CODE_MAPS.put(APP_TRADE_REFUND_FAILED_GIVEAWAY, "赠品不支持退款");
        CODE_MAPS.put(APP_MY_COUPON_ERROR, "我的优惠券错误");
        CODE_MAPS.put(APP_MY_COUPON_IS_USED, "优惠券已被使用");
        CODE_MAPS.put(APP_MY_COUPON_IS_EXPIRED, "优惠券已过期");
        CODE_MAPS.put(APP_MY_COUPON_NOT_BEGIN, "优惠券未到使用时间");
        CODE_MAPS.put(APP_MY_COUPON_LIMIT_COUNT, "领取优惠券已达上限");
        CODE_MAPS.put(APP_MY_COUPON_CONSUME_FALSE, "核销优惠券失败");
        CODE_MAPS.put(APP_MY_COUPON_ROLLBACK_FALSE, "回滚优惠券失败");
        CODE_MAPS.put(APP_MEMBER_DMS_ERROR, "网络请求DMS错误");
        CODE_MAPS.put(APP_TWO_CENTER_STOCK_ERROR, "双中心库存中心返回错误");
        CODE_MAPS.put(APP_TWO_CENTER_ORDER_ERROR, "双中心订单中心返回错误");
    }
}
