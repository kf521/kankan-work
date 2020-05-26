package com.kankan.service.controller;

import com.kankan.service.config.ApiResponse;
import com.kankan.service.exception.GatewayResponseEnum;
import com.kankan.service.exception.SystemResponseEnum;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Administrator
 * @date: 2020-05-11 13:26
 */
@RestController
@Slf4j
public class ZuulErrorController implements ErrorController {
    public static  final  String ERROR_PATH = "/error";

    /**
     * 网关服务的错误最终会执行到这里来
     */
    @RequestMapping(ERROR_PATH)
    public Object error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        String meesage = SystemResponseEnum.GATEWAY_ERROR.getMessage();
        if (throwable != null) {
            meesage = throwable.getMessage();
            log.error(meesage);
        }
        return ApiResponse.fail(SystemResponseEnum.GATEWAY_ERROR.getCode(), meesage, null);
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}
