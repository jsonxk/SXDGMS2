package com.xk.Util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: xk
 * @date:2017年11月19日 下午3:21:03
 * @version :
 * 
 */
@Component
public class SpringContextUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil .applicationContext=applicationContext;
		
	}
	public static ApplicationContext getApplicationContext() {
         return applicationContext;
	}
	@SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
         return (T) applicationContext.getBean(name);
     } 
}
