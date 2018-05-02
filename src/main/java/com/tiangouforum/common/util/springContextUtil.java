package com.tiangouforum.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author Du Yihong
 * Decription：
 * Date Create in 2018/2/8
 */
public class springContextUtil implements ApplicationContextAware {


    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}
