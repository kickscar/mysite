package me.kickscar.mysite.config;

import me.kickscar.mysite.event.ApplicationContextEventListener;
import me.kickscar.mysite.interceptor.SiteInterceptor;
import org.springframework.context.annotation.*;

import me.kickscar.mysite.config.web.FileuploadConfig;
import me.kickscar.mysite.config.web.MessageConfig;
import me.kickscar.mysite.config.web.MvcConfig;
import me.kickscar.mysite.config.web.SecurityConfig;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"me.kickscar.mysite.controller", "me.kickscar.mysite.exception"})
@Import({MvcConfig.class, SecurityConfig.class, MessageConfig.class, FileuploadConfig.class})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ApplicationContextEventListener applicationContextEventListener() {
        return new ApplicationContextEventListener();
    }

    @Bean
    public HandlerInterceptor siteInterceptor() {
        return new SiteInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
            .addInterceptor(siteInterceptor())
            .addPathPatterns("/**");
    }
}