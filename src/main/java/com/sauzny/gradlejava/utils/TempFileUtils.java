package com.sauzny.gradlejava.utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * *************************************************************************
 * @文件名称: TempFileUtils.java
 *
 * @包路径  : com.sauzny.gradlejava.utils 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  临时文件使用的工具类
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月26日 - 上午11:35:54 
 *	
 **************************************************************************
 */
public final class TempFileUtils {

	private TempFileUtils(){}
	
	/**
	 * 	方法描述:  生成文件名字 使用_相连接，文件名后缀之前增加时间戳
	 *   
	 *  @author  ljx 创建时间 2016年8月26日 上午11:36:14
	 */
	public static String genJpgName(String... strings){
		
		// 当前时间 加 时区偏移 组织时间戳
		String dataTime = LocalDateTime.now().toString()+ZonedDateTime.now().getOffset().toString();
		String dataTimePType = dataTime.replace("-", "").replace("T", "").replace(":", "")+".jpg";
				
		return String.join("_", new String[]{String.join("_", strings),dataTimePType});
	}
	
	/**
	 * 	方法描述:  生成文件完整路径 使用/相连接
	 *   
	 *  @author  ljx 创建时间 2016年8月26日 上午11:36:39
	 */
	public static String genPath(String... strings){
		return String.join("/", strings);
	}
	
	/**
	 * 	方法描述:  生成临时文件
	 *   
	 *  @author  ljx 创建时间 2016年8月26日 下午1:39:24
	 */
	public static File genTempFile(String path){
		
		File file = new File(path);

		if(!file.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
			file.getParentFile().mkdirs(); 
        }  
		
		return file;
	}
}
