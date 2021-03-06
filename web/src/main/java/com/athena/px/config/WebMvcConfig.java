package com.athena.px.config;

import com.athena.px.interceptor.DefaultHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/5/24 11:09
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/js/**", "/img/**")
                .addResourceLocations("classpath:/css/","classpath:/js/","classpath:/img/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new DefaultHandlerInterceptor());
        registration.addPathPatterns("/");
    }
}
