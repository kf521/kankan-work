package com.kankan.service.exception;

import lombok.Getter;

@Getter
public enum GatewayResponseEnum implements  ResponseEnum{

//	MISSING_TOKEN("403001", "缺少Authorization或access_token参数"),
	MISSING_TOKEN("403001", "需要登录"),
	EXPIRED_TOKEN("403002", "toekn过期，请重新登录"),
	INVALID_TOKEN("403003", "无效token，请重新登录"),
	ERROR_TOKEN("403004", "错误token，请重新登录"),
    ACCESS_DENIED("403005", "无访问权限"),
	KICK_OUT("403006","该用户已在其他设备登录"),
    BAN("403007","当前账号已被禁用,请联系客服");


    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String message;

    GatewayResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
