package com.sauzny.gradlejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sauzny.gradlejava.utils.SpringUtils;

/**
 * *************************************************************************
 * @文件名称: Application.java
 *
 * @包路径  : com.sauzny.gradlejava 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午1:57:51 
 *	
 **************************************************************************
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		//初始化时，记录applicationContext
		SpringUtils.setApplicationContext(applicationContext);
	}
}
