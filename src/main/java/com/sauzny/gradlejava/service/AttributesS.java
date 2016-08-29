package com.sauzny.gradlejava.service;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cognitivej.vision.overlay.builder.ImageOverlayBuilder;


/**
 * *************************************************************************
 * @文件名称: AttributesS.java
 *
 * @包路径  : com.sauzny.gradlejava.service 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午1:44:43 
 *	
 **************************************************************************
 */
@Service
public class AttributesS extends BaseService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributesS.class);
	
	public static enum Type {
		
		//检测出人脸的所有属性 url文件
		detectAllAttributesExample,
		
		// 检测人脸面部标记 标记的点比较大，只能识别单人 url文件
		detectFacialLandmarksExample,
		
		// 检测 性别和年龄 本地文件
		detectGenderAgeFromFileExample,
		
		// 检测 性别和年龄 url文件
		detectGenderAgeFromURLExample
	}
	
	
	
	/**
	 * 	方法描述:  
	 *   
	 *  @author  ljx 创建时间 2016年8月24日 下午5:03:58
	 */
	public File apply(String requestId, String type, String[] images){
		
		LOGGER.debug("type : " + type);
		LOGGER.debug("images : " + Arrays.toString(images));
		
		ImageOverlayBuilder imageOverlayBuilder = getImageOverlayBuilder(type, images);
		
		return getResult(requestId, type.toString(), imageOverlayBuilder);
	}

}
