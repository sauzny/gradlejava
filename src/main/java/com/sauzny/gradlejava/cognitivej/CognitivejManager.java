package com.sauzny.gradlejava.cognitivej;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.sauzny.gradlejava.cognitivej.attributes.DetectAllAttributesExample;
import com.sauzny.gradlejava.cognitivej.attributes.DetectFacialLandmarksExample;
import com.sauzny.gradlejava.cognitivej.attributes.DetectGenderAgeFromFileExample;
import com.sauzny.gradlejava.cognitivej.attributes.DetectGenderAgeFromURLExample;
import com.sauzny.gradlejava.cognitivej.computervision.DescribeImageExample;
import com.sauzny.gradlejava.cognitivej.computervision.OcrImageExample;
import com.sauzny.gradlejava.cognitivej.detect.DetectFacesFromImageUrlExample;
import com.sauzny.gradlejava.cognitivej.detect.DetectSingleFaceFromFileExample;

/**
 * *************************************************************************
 * @文件名称: CognitivejManager.java
 *
 * @包路径  : com.sauzny.gradlejava.cognitivej 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午2:40:51 
 *	
 **************************************************************************
 */
@Component
public class CognitivejManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CognitivejManager.class);
	
	private static Map<Class<?>, Method> cognitivejMap;
	
	@PostConstruct
	public void postConstruct(){
		cognitivejMap = new HashMap<Class<?>, Method>();
		
		// attributes
		cognitivejMap.put(DetectAllAttributesExample.class, ReflectionUtils.findMethod(DetectAllAttributesExample.class, "apply", String.class));
		cognitivejMap.put(DetectFacialLandmarksExample.class, ReflectionUtils.findMethod(DetectFacialLandmarksExample.class, "apply", String.class));
		cognitivejMap.put(DetectGenderAgeFromFileExample.class, ReflectionUtils.findMethod(DetectGenderAgeFromFileExample.class, "apply", String.class));
		cognitivejMap.put(DetectGenderAgeFromURLExample.class, ReflectionUtils.findMethod(DetectGenderAgeFromURLExample.class, "apply", String.class));
	
		//
		cognitivejMap.put(DescribeImageExample.class, ReflectionUtils.findMethod(DescribeImageExample.class, "apply", String.class));
		cognitivejMap.put(OcrImageExample.class, ReflectionUtils.findMethod(OcrImageExample.class, "apply", String.class));

		//
		cognitivejMap.put(DetectFacesFromImageUrlExample.class, ReflectionUtils.findMethod(DetectFacesFromImageUrlExample.class, "apply", String.class));
		cognitivejMap.put(DetectSingleFaceFromFileExample.class, ReflectionUtils.findMethod(DetectSingleFaceFromFileExample.class, "apply", String.class));
		
		LOGGER.debug(cognitivejMap.toString());
	}

	public static Map<Class<?>, Method> getCognitivejMap() {
		return cognitivejMap;
	}
	
}
