package com.sauzny.gradlejava.service;

import java.io.File;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.sauzny.gradlejava.cognitivej.CognitivejManager;
import com.sauzny.gradlejava.utils.CommonConfUtils;
import com.sauzny.gradlejava.utils.SpringUtils;
import com.sauzny.gradlejava.utils.TempFileUtils;

import cognitivej.vision.overlay.builder.ImageOverlayBuilder;

/**
 * *************************************************************************
 * @文件名称: BaseService.java
 *
 * @包路径  : com.sauzny.gradlejava.service 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  service的基础类，封装一些公用方法
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午1:46:39 
 *	
 **************************************************************************
 */
@Component
public abstract class BaseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
	
	@Autowired private CommonConfUtils commonConfUtils;
	
	public abstract File apply(String requestId, String type, String[] images);
	
	/**
	 * 	方法描述:  图片分析过程
	 *   
	 *  @author  ljx 创建时间 2016年8月25日 下午2:37:08
	 */
	public ImageOverlayBuilder getImageOverlayBuilder(String type, String[] images){
		
		ImageOverlayBuilder imageOverlayBuilder = null;
		
		try{

			Class<?> clazz = SpringUtils.getApplicationContext().getType(type);
			LOGGER.debug("clazz :" + clazz.getName());
			
			Object target = SpringUtils.getApplicationContext().getBean(type, clazz);
			LOGGER.debug("target :" + target.toString());
			
			Method method = CognitivejManager.getCognitivejMap().get(clazz);
			LOGGER.debug("method :" + method.getName());
			
			Object[] objects = new Object[]{};
			
			if(images == null || images.length == 0){
				
			}else if(images.length == 1){
				
				objects = new Object[]{images[0]};
				
			}else{
				
				objects = new Object[]{images};
				
			}
			
			imageOverlayBuilder = (ImageOverlayBuilder) ReflectionUtils.invokeMethod(method, target, objects);
			
		}catch(Exception e){
			
			LOGGER.error("getImageOverlayBuilder error", e);
			
		}
		
		return imageOverlayBuilder;
		
	}
	
	/**
	 * 	方法描述:  图片分析之后的结果
	 *   
	 *  @author  ljx 创建时间 2016年8月25日 下午1:48:41
	 */
	public File getResult(String requestId, String type, ImageOverlayBuilder imageOverlayBuilder){
		
		File file = new File("0.jpg");
		
		try{
			
			if(imageOverlayBuilder != null){
				String tempName = TempFileUtils.genJpgName( requestId );
				String tempPath = TempFileUtils.genPath(new String[]{ commonConfUtils.getTempDownPath(), type.toString(), tempName});
				
				file = TempFileUtils.genTempFile(tempPath);
				imageOverlayBuilder.toDisk(file);
			}
			
		}catch(Exception e){
			
			LOGGER.error("getResult error", e);
			
		}
		
		return file;
		
	}
}
