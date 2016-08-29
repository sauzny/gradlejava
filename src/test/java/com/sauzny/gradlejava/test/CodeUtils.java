package com.sauzny.gradlejava.test;

import java.util.UUID;

import com.sauzny.gradlejava.cognitivej.detect.DetectFacesFromImageUrlExample;
import com.sauzny.gradlejava.cognitivej.detect.DetectSingleFaceFromFileExample;

/**
 * *************************************************************************
 * @文件名称: CodeUtils.java
 *
 * @包路径  : com.sauzny.gradlejava.test 
 *				 
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述:  生成一些代码
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2016年8月25日 - 下午3:30:53 
 *	
 **************************************************************************
 */
public class CodeUtils {

	public static void genCognitivejManager(Class<?> clazz){
		
		String sn = clazz.getSimpleName();
		//cognitivejMap.put(DetectAllAttributesExample.class, ReflectionUtils.findMethod(DetectAllAttributesExample.class, "apply", String.class));
		System.out.println("cognitivejMap.put("+sn+".class, ReflectionUtils.findMethod("+sn+".class, \"apply\", String.class));");
	}
	
	public static void genSubscriptionKeyManager(String keyName){
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//private String emotion;
		//LOGGER.debug("azure.cognitive.emotion.subscriptionKey : " + emotion);
		//System.setProperty("azure.cognitive.emotion.subscriptionKey", emotion);
		
		System.out.println("private String "+keyName+";");
		System.out.println("LOGGER.debug(\"azure.cognitive."+keyName+".subscriptionKey : \" + "+keyName+");");
		System.out.println("System.setProperty(\"azure.cognitive."+keyName+".subscriptionKey\", "+keyName+");");
		
	}
	
	public static void genKeyPro(String keyName){
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//# Computer Vision - Preview
		//azure.cognitive.vision=xxx
		
		System.out.println("# "+keyName+" - Preview");
		System.out.println("azure.cognitive."+keyName+"=xxx");
	}
	
	public static void main(String[] args) {
		
		Class<?>[] clazzs = new Class<?>[]{
				DetectFacesFromImageUrlExample.class,
				DetectSingleFaceFromFileExample.class
		};
		
		for(Class<?> clazz : clazzs){
			genCognitivejManager(clazz);
		}
		
		genSubscriptionKeyManager("vision");
		
		genKeyPro("vision");
	}
}
