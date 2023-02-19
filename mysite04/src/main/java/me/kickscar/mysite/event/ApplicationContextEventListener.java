package me.kickscar.mysite.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kickscar.mysite.service.SiteService;
import me.kickscar.mysite.vo.SiteVo;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.Map;
import java.util.function.Supplier;

public class ApplicationContextEventListener {
    @Autowired
    private ApplicationContext applicationContext;

    @EventListener({ContextRefreshedEvent.class})
    public void handleContextRefreshEvent() {
        System.out.println("--- Context Refresh Event Received --- : " + applicationContext);

        SiteVo vo = applicationContext.getBean(SiteService.class).getSite();

        Map<?, ?> mapPropertyValues = new ObjectMapper().convertValue(vo, Map.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues(mapPropertyValues);

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SiteVo.class);
        beanDefinition.setPropertyValues(propertyValues);

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry)applicationContext.getAutowireCapableBeanFactory();
        registry.registerBeanDefinition("site", beanDefinition);

//        ((GenericWebApplicationContext)applicationContext).registerBean(SiteVo.class, new Supplier<SiteVo>() {
//            @Override
//            public SiteVo get() {
//                try {
//                    return (SiteVo)vo.clone();
//                } catch (CloneNotSupportedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }

    @EventListener({ContextStartedEvent.class, ContextStoppedEvent.class})
    public void handleMultipleEvents() {
        System.out.println("----- Multi-event listener invoked ----");
    }
}