package com.chuan.kafka.config;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yuchuankai
 * @Date 2022/9/23 16:30
 * @Description:
 */
@Configuration
public class BeanContext implements ApplicationContextAware {


    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanContext.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过名字获取上下文中的bean
    public static Object getBean(String name) {
        if(name == null || name.length()==0) {
            return null;
        }
        try {
            String beanName = "";
            if(name.length() >1){
                beanName = name.substring(0, 1).toLowerCase() + name.substring(1);
            } else {
                beanName = name.toLowerCase();
            }
            return applicationContext.getBean(beanName);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    // 通过类型获取上下文中的bean
    public static <T> T getBean(Class<T> clazz) {
        try {
            return (T) applicationContext.getBean(clazz);
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
