package me.kickscar.mysite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import me.kickscar.mysite.config.web.FileuploadConfig;
import me.kickscar.mysite.config.web.MessageConfig;
import me.kickscar.mysite.config.web.MvcConfig;
import me.kickscar.mysite.config.web.SecurityConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"me.kickscar.mysite.controller", "me.kickscar.mysite.exception"})
@Import({MvcConfig.class, MessageConfig.class, FileuploadConfig.class, SecurityConfig.class})
public class WebConfig {
}