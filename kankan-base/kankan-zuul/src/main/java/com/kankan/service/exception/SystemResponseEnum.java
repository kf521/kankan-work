package com.kankan.service.exception;

/**
 * @description:
 * @author: Administrator
 * @date: 2020-05-11 13:54
 */
public enum  SystemResponseEnum implements ResponseEnum{
    SUCCESS("200", "操作成功"),
    SYSTEM_ERROR("100000", "系统异常"),
    SYSTEM_BUSY("100001", "系统繁忙，请稍候再试"),
    SYSTEM_UNAVAILABLE_SERVICE("100002", "服务不可用，请稍候再试"),
    SYSTEM_RESOURCE_FALLBACK("100003", "资源服务繁忙，请稍候再试"),
    SYSTEM_AUTHORIZATION_ERROR("110000", "认证服务异常"),
    SYSTEM_AUTHORIZATION_UNAVAILABLE("110001", "认证服务不可用，请稍候再试"),
    GATEWAY_NOT_FOUND_SERVICE("010404", "服务未找到"),
    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),
    ARGUMENT_NOT_VALID("020000", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("020001", "上传文件大小超过限制"),
    REFRESH_TOKEN("100005", "refreshToken已刷新");

    private String code;
    private String message;

    private SystemResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
