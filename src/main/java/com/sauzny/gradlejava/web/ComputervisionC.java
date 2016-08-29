package com.sauzny.gradlejava.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sauzny.gradlejava.entity.web.Result;
import com.sauzny.gradlejava.service.ComputervisionS;
import com.sauzny.gradlejava.utils.CommonConfUtils;

/**
 * *************************************************************************
 * @文件名称: ComputervisionC.java
 *
 * @包路径  : com.sauzny.gradlejava.web 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月29日 - 下午1:43:50 
 *	
 **************************************************************************
 */
@Controller
@RequestMapping("/c/computervision")
public class ComputervisionC extends BaseController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComputervisionC.class);

	@Autowired private ComputervisionS computervisionS;
	@Autowired private CommonConfUtils commonConfUtils;

	/**
	 * 	方法描述:  描述图片
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 下午1:45:40
	 */
	@RequestMapping(value = "/describeImageExample", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS  })
	@ResponseBody
	public Result describeImageExample(
			@RequestParam(required=true) String upType,
			@RequestParam(required=false) String imageUrl,
			@RequestParam(value="multipart", required=false) MultipartFile multipart,
			HttpServletRequest request,
			HttpServletResponse response){ 
		
		String type = ComputervisionS.Type.describeImageExample.toString();
		
		LOGGER.debug("method : " + request.getMethod());
		LOGGER.debug("upType : " + upType);
		LOGGER.debug("imageUrl : " + imageUrl);
		LOGGER.debug("multipart : " + multipart);
		LOGGER.debug("type : " + type);
		LOGGER.debug("computervisionS : " + computervisionS);
		
		Result result = apply(upType, imageUrl, multipart, type, commonConfUtils, computervisionS, request);
        
        LOGGER.debug(result.toString());
        
		return result;
	}
	
	/**
	 * 	方法描述:  识别文字
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 下午1:45:54
	 */
	@RequestMapping(value = "/ocrImageExample", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS  })
	@ResponseBody
	public Result ocrImageExample(
			@RequestParam(required=true) String upType,
			@RequestParam(required=false) String imageUrl,
			@RequestParam(value="multipart", required=false) MultipartFile multipart,
			HttpServletRequest request,
			HttpServletResponse response){ 
		
		String type = ComputervisionS.Type.ocrImageExample.toString();
		
		LOGGER.debug("method : " + request.getMethod());
		LOGGER.debug("upType : " + upType);
		LOGGER.debug("imageUrl : " + imageUrl);
		LOGGER.debug("multipart : " + multipart);
		LOGGER.debug("type : " + type);
		LOGGER.debug("computervisionS : " + computervisionS);
		
		Result result = apply(upType, imageUrl, multipart, type, commonConfUtils, computervisionS, request);
        
        LOGGER.debug(result.toString());
        
		return result;
	}
	
}
