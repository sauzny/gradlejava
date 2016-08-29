package com.sauzny.gradlejava.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="common")
@Data
public class CommonConfUtils {

	private String tempAddr;
	private String tempUpPath;
	private String tempDownPath;
	
}
