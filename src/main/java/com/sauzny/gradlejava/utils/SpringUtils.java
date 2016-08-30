package com.sauzny.gradlejava.utils;

import org.springframework.context.ApplicationContext;

/**
 * *************************************************************************
 * @文件名称: SpringUtils.java
 *
 * @包路径  : com.sauzny.gradlejava.utils 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:   
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午1:56:12 
 *	
 **************************************************************************
 */
public final class SpringUtils {
	
	private SpringUtils(){}
	
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}
	
}
