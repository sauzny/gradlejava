package com.sauzny.gradlejava.test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;


 
 /***************************************************************************
 * @文件名称: AppTest.java
 *
 * @包路径  : com.sauzny.gradlejava.test 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月26日 - 上午11:41:05 
 *	
 ***************************************************************************/
 
public class AppTest {

	public static void main(String[] args) {
		
		String requestId = UUID.randomUUID().toString().replace("-", "");
		
		System.out.println(requestId);
		
		System.out.println(String.join("/", new String[]{"a","b","c"}));

		String timeStr = LocalDateTime.now().toString()+ZonedDateTime.now().getOffset().toString();
		
		System.out.println(timeStr);
		
		System.out.println(timeStr.replace("-", "").replace("T", "").replace(":", ""));

	}

}
