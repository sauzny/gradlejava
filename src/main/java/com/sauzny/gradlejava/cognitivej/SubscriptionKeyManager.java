package com.sauzny.gradlejava.cognitivej;

import javax.annotation.PostConstruct;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * *************************************************************************
 * @文件名称: SubscriptionKeyManager.java
 *
 * @包路径  : com.sauzny.gradlejava.cognitivej 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  负责key的初始化
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月24日 - 下午4:41:16 
 *	
 **************************************************************************
 */
@Component
@ConfigurationProperties(prefix="azure.cognitive")
@Data
public class SubscriptionKeyManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionKeyManager.class);

	private String face;
	private String emotion;
	private String vision;
	
	@PostConstruct
	public void postConstruct(){
		
		LOGGER.debug("azure.cognitive.subscriptionKey : " + face);
		System.setProperty("azure.cognitive.subscriptionKey", face);
		
		LOGGER.debug("azure.cognitive.emotion.subscriptionKey : " + emotion);
		System.setProperty("azure.cognitive.emotion.subscriptionKey", emotion);
		
		LOGGER.debug("azure.cognitive.vision.subscriptionKey : " + vision);
		System.setProperty("azure.cognitive.vision.subscriptionKey", vision);
	}
}
