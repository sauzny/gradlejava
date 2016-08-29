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
import com.sauzny.gradlejava.service.AttributesS;
import com.sauzny.gradlejava.utils.CommonConfUtils;

/**
 * *************************************************************************
 * @文件名称: AttributesC.java
 *
 * @包路径  : com.sauzny.gradlejava.web 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月26日 - 上午10:52:00 
 *	
 **************************************************************************
 */
@Controller
@RequestMapping("/c/attributes")
public class AttributesC extends BaseController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributesC.class);

	@Autowired private AttributesS attributesS;
	@Autowired private CommonConfUtils commonConfUtils;
	
	/**
	 * 	方法描述:  所有属性
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 下午1:34:22
	 */
	@RequestMapping(value = "/detectAllAttributesExample", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS  })
	@ResponseBody
	public Result detectAllAttributesExample(
			@RequestParam(required=true) String upType,
			@RequestParam(required=false) String imageUrl,
			@RequestParam(value="multipart", required=false) MultipartFile multipart,
			HttpServletRequest request,
			HttpServletResponse response){ 
		
		String type = AttributesS.Type.detectAllAttributesExample.toString();
		
		LOGGER.debug("method : " + request.getMethod());
		LOGGER.debug("upType : " + upType);
		LOGGER.debug("imageUrl : " + imageUrl);
		LOGGER.debug("multipart : " + multipart);
		LOGGER.debug("type : " + type);
		LOGGER.debug("attributesS : " + attributesS);
		
		Result result = apply(upType, imageUrl, multipart, type, commonConfUtils, attributesS, request);
        
        LOGGER.debug(result.toString());
        
		return result;
	}
	
	/**
	 * 	方法描述:  五官标记
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 下午1:34:36
	 */
	@RequestMapping(value = "/detectFacialLandmarksExample", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS  })
	@ResponseBody
	public Result detectFacialLandmarksExample(
			@RequestParam(required=true) String upType,
			@RequestParam(required=false) String imageUrl,
			@RequestParam(value="multipart", required=false) MultipartFile multipart,
			HttpServletRequest request,
			HttpServletResponse response){ 
		
		String type = AttributesS.Type.detectFacialLandmarksExample.toString();
		
		LOGGER.debug("method : " + request.getMethod());
		LOGGER.debug("upType : " + upType);
		LOGGER.debug("imageUrl : " + imageUrl);
		LOGGER.debug("multipart : " + multipart);
		LOGGER.debug("type : " + type);
		LOGGER.debug("attributesS : " + attributesS);
		
		Result result = apply(upType, imageUrl, multipart, type, commonConfUtils, attributesS, request);
        
        LOGGER.debug(result.toString());
        
		return result;
	}
	
	/**
	 * 	方法描述:  性别年龄
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 下午1:34:41
	 */
	@RequestMapping(value = "/detectGenderAgeFromURLExample", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS  })
	@ResponseBody
	public Result detectGenderAgeFromURLExample(
			@RequestParam(required=true) String upType,
			@RequestParam(required=false) String imageUrl,
			@RequestParam(value="multipart", required=false) MultipartFile multipart,
			HttpServletRequest request,
			HttpServletResponse response){ 
		
		String type = AttributesS.Type.detectGenderAgeFromURLExample.toString();
		
		LOGGER.debug("method : " + request.getMethod());
		LOGGER.debug("upType : " + upType);
		LOGGER.debug("imageUrl : " + imageUrl);
		LOGGER.debug("multipart : " + multipart);
		LOGGER.debug("type : " + type);
		LOGGER.debug("attributesS : " + attributesS);
		
		Result result = apply(upType, imageUrl, multipart, type, commonConfUtils, attributesS, request);
        
        LOGGER.debug(result.toString());
        
		return result;
	}
}
