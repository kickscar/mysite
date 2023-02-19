package me.kickscar.mysite.config;

import me.kickscar.mysite.config.app.DBConfig;
import me.kickscar.mysite.config.app.MyBatisConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"me.kickscar.mysite.repository", "me.kickscar.mysite.service", "me.kickscar.mysite.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
}