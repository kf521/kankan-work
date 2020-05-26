package com.kankan.service.provider;


import cn.hutool.json.JSON;
import com.kankan.service.config.ApiResponse;
import com.kankan.service.exception.ResponseEnum;
import com.kankan.service.exception.SystemResponseEnum;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义Zuul回退机制处理器。
 *
 * Provides fallback when a failure occurs on a route
 * 英文意思就是说提供一个回退机制当路由后面的服务发生故障时。
 */
@Component
public class GatewayFallbackProvider implements FallbackProvider {

	/**
	 * 返回值表示需要针对此微服务做回退处理（该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称）；
	 * 表明是为哪个微服务提供回退，*表示为所有微服务提供回退
	 * 
	 * @return
	 */

	
	public String getRoute() {
		return "*";
	}

	/**
	 * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的， 不应该把api的404,500等问题抛给客户端
	 * 网关和api服务集群对于客户端来说是黑盒子
	 */

	
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		if (cause instanceof HystrixTimeoutException) {
			return this.response(SystemResponseEnum.SYSTEM_BUSY);
		} else {
			return this.response(SystemResponseEnum.SYSTEM_UNAVAILABLE_SERVICE);
		}
	}

	private ClientHttpResponse response(final ResponseEnum errorType) {

		return new ClientHttpResponse() {

			public InputStream getBody() throws IOException {
				return null;
			}

			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			public void close() {

			}


			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}

		};

	}

}
