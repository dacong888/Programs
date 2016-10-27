package com.task11springmvc.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 定义工具类，用于获取spring中注入的类实例
 * @author Songbin
 *
 */
public class UserContext implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}
	
	public static Object getBean(String bean)
	{
		return applicationContext.getBean(bean);
	}
	
}
