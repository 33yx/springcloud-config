package com.xzf.springboot.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/sys/login.html").setViewName("login");
//        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/sys/welcome.html").setViewName("welcome");
        registry.addViewController("/sys/admin-add.html").setViewName("admin-add");
        registry.addViewController("/sys/member-add.html").setViewName("member-add");
        registry.addViewController("/sys/seller-add.html").setViewName("seller-add");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/login","/","/fore/order-list","/sys/index","/css/**","/images/**","/js/**","/fonts/**","/lib/layui/**","/sys/indexss");
    }






}
