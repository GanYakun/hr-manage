package com.yakun.util.MessageUtil;

import com.yakun.util.i18nUtil.LocaleUtil;

import lombok.Getter;

/**
 * 公共错误码
 */
public enum CommonMessageCode {
    //响应成功
    SUCCESS("200","i18n.status.success"),
    //导入成功
    IMPORT("200", "i18n.status.import.success"),
    //响应失败
    FAIL("COMAPP999", "i18n.status.fail"),
    //登录失败
    LOGIN_FAILURE("3040", "i18n.status.login.fail"),
    //已登录
    LOGIN_Token("3041", "i18n.status.login.logged"),
    //已注册
    USER_EXISTS("3042","i18n.status.register.repeat"),
    //密码错误
    WRONG_PW("3043", "i18n.status.password.wrong"),
    //文件为空
    FILE_IS_EMPTY("00000002", "i18n.status.file.empty"),
    //登录成功
    LOGIN_SUCCESS("200", "i18n.status.login.success"),
    //未注册
    USER_NOT_EXISTS("401","i18n.status.register.unregistered"),
    //注册成功
    REGISTER_SUCCESS("200","i18n.status.register.success"),
    //退出登录
    LOGIN_OUT("00000002", "i18n.status.logout.success"),
    //需要更新密码
    UPDATE_PWD("200","i18n.status.password.update"),
    //token验证失败，重新登陆
    TOKEN_FAILED("401", "i18n.token.validate.failed"),
    //没有token，重新登陆
    NO_TOKEN("401", "i18n.token.lost.login");

    /**
     * 提示
     */
    private final String message;
    /**
     * 状态吗
     * -- GETTER --
     *  获取错误code
     *
     * @return 错误code

     */
    @Getter
    private final String code;

    CommonMessageCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取国际化错误提示
     *
     * @return 错误提示文本
     */
    public String getMessage() {
        return LocaleUtil.getMessage(message, message);
    }

    /**
     * 获取国际化错误提示
     *
     * @param args 错误提示参数
     * @return 错误提示文本
     */
    public String getMessage(Object[] args) {
        return LocaleUtil.getMessage(message, args, message);
    }

}
