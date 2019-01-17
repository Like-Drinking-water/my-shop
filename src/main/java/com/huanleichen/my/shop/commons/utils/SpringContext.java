package com.huanleichen.my.shop.commons.utils;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value = "SpringContext")
public class SpringContext implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext context;
    private Logger logger = LoggerFactory.getLogger(SpringContext.class);

    /**
     * 从静态变量 context 中获取 Bean，自动转型成所赋值对象的类型
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) context.getBean(name);
    }

    /**
     * 从静态变量 context 中获取 Bean，自动转型成所赋值对象的类型
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return  context.getBean(clazz);
    }

    /**
     *  获取存储在静态变量中的ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return context;
    }

    /**
     * 实现ApplicationContextAware接口，在Context关闭时清空静态变量
     * @throws Exception
     */
    public void destroy() throws Exception {
        logger.debug("清除 SpringContext 中的 ApplicationContext : {}", context);
        context = null;
    }

    /**
     * 实现ApplicationContextAware接口，将Context注入静态变量
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 断言context已经注入
     */
    private static void assertContextInjected() {
        Validate.validState(context != null, "applicationContext 属性未注入，请在 spring-context.xml 配置中定义 SpringContext");
    }
}
