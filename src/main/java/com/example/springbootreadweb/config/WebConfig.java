package com.example.springbootreadweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //配置登录验证拦截器
    @Autowired
    private MyInterceptor myInterceptor;

    // ctrl+o 查看可重写的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        <!--        与security有冲突-->
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**").excludePathPatterns(
                        "/login", "/css/*.css", "/js/*.js", "/img/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

//    //java后端解决跨域
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//
//
//        WebMvcConfigurer.super.addCorsMappings(registry);
//    }
}
