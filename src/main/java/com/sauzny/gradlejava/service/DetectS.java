package com.sauzny.gradlejava.service;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cognitivej.vision.overlay.builder.ImageOverlayBuilder;

@Service
public class DetectS extends BaseService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DetectS.class);
	
	public static enum Type {
		
		// 框选出人脸 form url
		detectFacesFromImageUrlExample,
		
		// 框选出人脸 form file
		detectSingleFaceFromFileExample,
		
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
