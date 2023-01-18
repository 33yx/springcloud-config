package com.example.demo.config;

import com.example.demo.util.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class a  extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/*").excludePathPatterns("/css/*","/emoji/*","/img/*","/js/*","/languages/*","/lib/*","/love/*","/music/*","/plugins/*","/login","/index","/header","/footer","/");
    }
}
