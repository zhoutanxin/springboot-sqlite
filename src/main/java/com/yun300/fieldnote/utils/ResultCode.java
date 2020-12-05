package com.yun300.fieldnote.utils;

/**
 * @author tangjiawei
 * 说明: 签名相关错误, code 从 1000开始,1001-1999
 * 验证码相关错误,code 从 2000开始 2001-2999
 * 用户相关错误,code 从 3000开始  30001-3999
 * 图片相关错误, code 从 4000开始
 * 请求相关错误, code 从 5000开始
 * 业务相关错误, code 从 6000开始
 */

public enum ResultCode {

    ERROR(0, "失败"),

    SUCCESS(1, "成功"),


    SIGN_ERROR(1001, "签名错误"),

    TOKEN_ERROR(1002, "token错误"),

    CAPTCHA_EXPIRED(20001, "验证码已经过期"),

    CAPTCHA_ERROR(20002, "验证码错误"),

    MESSAGE_CODE_FREQUENTLY(2003, "验证码发送频繁，请稍后再试"),

    MESSAGE_COUNT_ERROR(2004, "验证失败次数过多,请几分钟后再试"),

    IMG_CAPTCHA_IS_ERROR(2005, "图形验证码错误"),

    IMG_CAPTCHA_NOT_FIND(2006, "获取图形验证码异常"),

    REQUEST_SMS_SERVICE_ERROR(2007, "短信服务暂时失败，请稍后再试"),

    REQUEST_SMS_SERVICE_COUNT_ERROR(2008, "发送验证码次数过多，请联系管理员"),


    USER_EXPIRE(3001, "用户过期，请重新登录"),

    INVALID_TOKEN(3002, "用户没有登录或登录已失效"),

    NOT_AUTHORIZED(3003, "没有权限访问"),

    NOT_FOUND_USER(3004, "该用户不存在"),

    NOT_HAS_LOGIN_AUTHORITY(3005, "您的手机号没有权限登录，请联系管理员"),

    PHONE_IS_EXIST(3006, "手机号已经存在"),

    USER_NOT_HAS_AUTHORITY(3007, "没有该操作权限"),

    USER_LOGIN_FAIL(3008, "账号或密码错误"),

    ONLINE_NOT_HAS_AUTHORITY(3009, "生产环境不允许操作"),

    USER_LOGIN_STOP(3010, "账号已停用"),

    IP_OPERATOR_FREQUENTLY(3011, "操作太频繁,请联系管理员"),

    ACCOUNT_HAS_BIND_WX(3012, "该微信账号已经绑定其他账号,请勿重复绑定"),

    ACCOUNT_HAS_EXIST(3013, "该账号已存在"),

    IMAGE_BIGGER(4001, "图片太大啦"),


    INVALID_PARAM(5001, "请求参数缺失或不正确"),


    NOT_SUPPORT_REQUEST_TYPE(5003, "不支持的请求类型"),

    URL_NOT_FOUND(5004, "请求服务不存在"),

    SERVICE_UNAVAILABLE(5005, "服务异常，请稍后再试"),

    TIMEOUT_UNAVAILABLE(5006, "超时异常"),

    RATE_LIMITER(5007, "我抗不住了，慢点请求吧"),

    REQUEST_PARAMETER_IS_NOT_LEGAL(6000, "请求数据不合法"),

    ORDER_STATUS_iS_NOT_WAIT_DELIVERY(6001, "订单状态不是代发货"),

    PRODUCT_SPEC_HAS_USED(6002, "该规格已被属性模板使用,不可删除"),

    PRODUCT_TEMPLATE_HAS_USED(6003, "该属性模板已被分类使用,不可删除"),

    PRODUCT_CATEGORY_HAS_CONTAINS_CHILDREN(6004, "该分类下有子分类，无法删除"),

    PRODUCT_CATEGORY_HAS_USED(6005, "该分类下包含商品,不允许删除"),

    INFO_CATEGORY_HAS_USED(6006, "该分类下包含资讯,不允许删除"),

    CUSTOM_FORM_HAS_USED(6007, "该表单包含内容,不允许删除"),

    COMMON_CONTENT_CATEGORY_HAS_USED(6008, "该分类下包含通用内容,不允许删除"),

    PRODUCT_ITEM_IS_NOT_ENABLE(6008, "货品未启用或者库存为零"),


    CLASS_CONTAINS_STUDENT(6009, "该班级下存在学生,不允许删除"),

    PUBLISH_WORK_ERROR(7001, "发布学生作业异常"),

    PUBLISH_COURSE_NOT_CONTAINS_LESSON_PERIOD(7002,"该课程下面不包含课时,不允许发布"),

    PUBLISH_EXAM_ERROR(7101, "发布学生考试异常");

    private int code;

    private String msg;

    ResultCode(int status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
