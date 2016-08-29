package com.sauzny.gradlejava.utils;

import com.sauzny.gradlejava.entity.web.Result;

/**
 * *************************************************************************
 * @文件名称: ResultUtils.java
 *
 * @包路径  : com.sauzny.gradlejava.utils 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月29日 - 上午10:53:34 
 *	
 **************************************************************************
 */
public final class ResultUtils {

	private ResultUtils(){};
	
	public static final int SUCCESS = 200;
	public static final int FAILURE = 300;
	
	/**
	 * 	方法描述:  
	 *   
	 *  @author  ljx 创建时间 2016年8月29日 上午10:53:39
	 */
	public static Result gen200(){
		Result result = new Result();
		result.setStatus(SUCCESS);
		return result;
	}
}
