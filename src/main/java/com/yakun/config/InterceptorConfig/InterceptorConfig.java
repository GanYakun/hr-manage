package com.yakun.config.InterceptorConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")    //拦截所有请求 通过判断token是否合法来决定是否登陆
                .excludePathPatterns("/userLogin/login","/userLogin/register","/**/export","/**/import", "/file/**","/role/**","/menu/**"); //放行接口
    }
}
