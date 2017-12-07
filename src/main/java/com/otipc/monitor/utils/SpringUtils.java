package com.otipc.monitor.utils;

import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by chaoguo.cui on 2017/12/7.
 */
@SuppressWarnings("unchecked")
@Component
public final class SpringUtils extends SpringBeanJobFactory implements
        ApplicationContextAware {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private transient AutowireCapableBeanFactory beanFactory;
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        SpringUtils.context=context;
        this.beanFactory = context.getAutowireCapableBeanFactory();

    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }

    public static <T> T getBean(String beanName) {
        if(context.containsBean(beanName)){
            return (T) context.getBean(beanName);
        }else{
            return null;
        }
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> baseType){
        return context.getBeansOfType(baseType);
    }
}