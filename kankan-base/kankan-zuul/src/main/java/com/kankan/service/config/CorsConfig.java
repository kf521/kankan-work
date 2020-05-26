package com.kankan.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @description: 支持跨域
 * @author: kanfeng
 * @date: 2020-05-11 11:00
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);        //是否允许跨域
        corsConfiguration.addAllowedOrigin("*");            // #允许向该服务器提交请求的URI，*表示全部允许
        corsConfiguration.addAllowedHeader("*");            //允许访问的头信息 *代表全部
        corsConfiguration.setMaxAge(18000L);                /// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        corsConfiguration.addAllowedMethod("*");            // 允许提交请求的方法，*表示全部允许
        source.registerCorsConfiguration("/**",corsConfiguration); //
        return new CorsFilter(source);
    }
}
