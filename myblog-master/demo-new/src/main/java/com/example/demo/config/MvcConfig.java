package com.example.demo.config;


import com.example.demo.util.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源映射
        registry.addResourceHandler("/article/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/template/**").addResourceLocations("classpath:/static/");
    }


}
