package me.kickscar.mysite.config;

import me.kickscar.config.web.FileuploadConfig;
import me.kickscar.config.web.MvcConfig;
import me.kickscar.config.web.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"me.kickscar.mysite.controller", "me.kickscar.mysite.exception"})
@Import({MvcConfig.class, FileuploadConfig.class, SecurityConfig.class})
public class WebConfig {
}