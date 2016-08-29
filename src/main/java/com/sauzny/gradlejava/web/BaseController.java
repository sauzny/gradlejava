package com.sauzny.gradlejava.web;

import java.io.File;
import java.net.URLDecoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sauzny.gradlejava.entity.web.Result;
import com.sauzny.gradlejava.service.BaseService;
import com.sauzny.gradlejava.utils.CommonConfUtils;
import com.sauzny.gradlejava.utils.ResultUtils;
import com.sauzny.gradlejava.utils.TempFileUtils;


/**
 * *************************************************************************
 * @文件名称: BaseController.java
 *
 * @包路径  : com.sauzny.gradlejava.web 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月26日 - 上午10:54:24 
 *	
 **************************************************************************
 */
public class BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	public Result apply(
			final String upType,
			final String imageUrl,
			final MultipartFile multipart,
			final String type,
			final CommonConfUtils commonConfUtils,
			final BaseService baseService,
			final HttpServletRequest request){

		String tempUpPath = commonConfUtils.getTempUpPath();
		String tempAddr = commonConfUtils.getTempAddr();
		
		LOGGER.debug("tempUpPath : " + tempUpPath);
		LOGGER.debug("tempAddr : " + tempAddr);
		
		Result result = ResultUtils.gen200();
		
		if(RequestMethod.OPTIONS.toString().equalsIgnoreCase(request.getMethod())){
			result.setMsg("OPTIONS OK");
			return result;
		}
		
		File file = new File("0.jpg");
		
        try{

        	// 创建请求id
        	String requestId = genRequestId();
        	
        	// 跨域设置
        	//crossDomain(response);
    		
        	String[] images = new String[1];
        	
        	if("imageUrl".equals(upType) && StringUtils.isNoneEmpty(imageUrl)){
        		
            	images = new String[]{URLDecoder.decode(imageUrl, "UTF-8")};
            	
        	}else if("multipart".equals(upType) && multipart != null){
        		
        		// 保存上传临时文件
        		
				String tempName = TempFileUtils.genJpgName( requestId );
				String tempPath = TempFileUtils.genPath(new String[]{ tempUpPath, type, tempName });
        		
        		FileUtils.writeByteArrayToFile(TempFileUtils.genTempFile(tempPath), multipart.getBytes());
        		
        		
        		// 上传临时文件 对应外部访问的资源位置
        		
        		String upImageUrl = TempFileUtils.genPath(new String[]{ tempAddr, "tempUpPath", type, tempName});
        		
            	images = new String[]{upImageUrl};
            	
            	LOGGER.debug("临时文件 对应外部访问的资源位置 : " + images[0]);
            	
        	}else{
        		result.setStatus(ResultUtils.FAILURE);
        		result.setMsg("upType is " + upType + " imageUrl is " + imageUrl + " multipart is " + multipart );
        	}
        	
        	if(ResultUtils.SUCCESS == result.getStatus()){
        		file = baseService.apply(requestId, type, images);
        	}
        	
        }catch(Exception e){
        	
        }
        
        if("0.jpg".equals(file.getName())){
        	result.setStatus(ResultUtils.FAILURE);
        	result.setMsg("没有分析出结果");
        }else{
            result.setImageUrl(TempFileUtils.genPath(type, file.getName()));
        }
		
        return result;
	}
	
	/**
	 * 	方法描述:  创建一个 RequestId
	 *   
	 *  @author  ljx 创建时间 2016年8月26日 上午10:55:35
	 */
	public String genRequestId(){
		return UUID.randomUUID().toString().replace("-", "");
	} 
}
